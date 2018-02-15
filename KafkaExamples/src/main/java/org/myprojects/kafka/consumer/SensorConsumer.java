package org.myprojects.kafka.consumer;

import java.util.*;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.*;

public class SensorConsumer{
    
    
    public static void main(String[] args) throws Exception{

            String topicName = "SensorData";
            KafkaConsumer<String, String> consumer = null;
            
            String groupName = "S1Consumer";
            Properties props = new Properties();
            props.put("bootstrap.servers", "localhost:9092,localhost:9093");
            props.put("group.id", groupName);
            props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            props.put("auto.offset.reset", "earliest"); 

            consumer = new KafkaConsumer<>(props);
            
            System.out.print("coimg here");   
            
            consumer.subscribe(Arrays.asList(topicName));
            try{
                while (true){
                    ConsumerRecords<String, String> records = consumer.poll(100);
                    for (ConsumerRecord<String, String> record : records){

                        System.out.println("Topic:"+ record.topic() +" Partition:" + record.partition() + " Offset:" + record.offset() + " Value:"+ record.value());
                       // Do some processing and save it to Database
                        consumer.commitAsync();
                    }
                }
            }catch(Exception ex){
                System.out.println("Exception.");
                ex.printStackTrace();
            }
            finally{
                    consumer.close();
            }
            System.out.print("Comsumer completed");

            
    }
    
}