package org.myprojects.kafka.consumer;

import java.util.*;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.*;
import org.myprojects.kafka.producer.Order;

public class OrderConsumer{
    
    
    public static void main(String[] args) throws Exception{

            String topicName = "OrderTopic";
            KafkaConsumer<Integer, Order> consumer = null;
            
            String groupName = "orderGroup";
            Properties props = new Properties();
            props.put("bootstrap.servers", "localhost:9092,localhost:9093");
            props.put("group.id", groupName);
            props.put("key.deserializer", org.apache.kafka.common.serialization.IntegerDeserializer.class.getName());
            props.put("value.deserializer", org.myprojects.kafka.producer.OrderDeserializer.class.getName());
            props.put("auto.offset.reset", "earliest"); 

            consumer = new KafkaConsumer<>(props);
            
            System.out.print("coimg here");
            
            consumer.subscribe(Arrays.asList(topicName));
            try{
                while (true){
                    ConsumerRecords<Integer, Order> records = consumer.poll(100);
                    for (ConsumerRecord<Integer, Order> record : records){

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