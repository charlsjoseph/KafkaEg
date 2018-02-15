package org.myprojects.kafka.producer;

import java.util.*;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.*;
public class OrderProducer {
  
   public static void main(String[] args) throws Exception{
           
      String topicName = "OrderTopic";
      
      Properties props = new Properties();
      props.put("bootstrap.servers", "localhost:9092,localhost:9093");
      props.put("key.serializer",org.apache.kafka.common.serialization.IntegerSerializer.class.getName());
      props.put("value.serializer", org.myprojects.kafka.producer.OrderSerializer.class.getName());
      Producer<Integer, Order> producer = new KafkaProducer <>(props);
      Integer key = 1;
      Order order = new Order(1233, 1001, "abc@abc.com", "Jug", 10);
      
      
	  ProducerRecord<Integer, Order> record = new ProducerRecord<>(topicName,key,order);
	  producer.send(record);
      producer.close();
	  
	  System.out.println("Order Producer Completed.");
   }
}