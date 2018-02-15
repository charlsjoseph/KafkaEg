package org.myprojects.kafka.consumer;

import java.util.*;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.*;
import org.myprojects.kafka.producer.AvroOrder;
import org.myprojects.kafka.producer.Order;

public class AvroOrderConsumer{
    
    
    public static void main(String[] args) throws Exception{

            String topicName = "OrderAvroTopic";
            KafkaConsumer<Integer, AvroOrder> consumer = null;
            
            String groupName = "orderAvroGroup";
            Properties props = new Properties();
            props.put("bootstrap.servers", "localhost:9092,localhost:9093");
            props.put("group.id", groupName);
            props.put("key.deserializer", org.apache.kafka.common.serialization.IntegerDeserializer.class.getName());
            props.put("value.deserializer", io.confluent.kafka.serializers.KafkaAvroDeserializer.class.getName());
            props.put("schema.registry.url", "http://localhost:8081");
            props.put("auto.offset.reset", "earliest"); 

            consumer = new KafkaConsumer<>(props);
                        
            consumer.subscribe(Arrays.asList(topicName));
            try{
                while (true){
                    ConsumerRecords<Integer, AvroOrder> records = consumer.poll(100);
                    for (ConsumerRecord<Integer, AvroOrder> record : records){

                        System.out.println("Topic:"+ record.topic() +" Partition:" + record.partition() + " Offset:" + record.offset() + " Value:"+ record.value());
                       // Do some processing and save it to Database
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