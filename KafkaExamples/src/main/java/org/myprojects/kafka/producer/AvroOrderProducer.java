package org.myprojects.kafka.producer;

import java.util.*;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.*;
public class AvroOrderProducer {
  
   public static void main(String[] args) throws Exception{
           
      String topicName = "OrderAvroTopic";
      
      Properties props = new Properties();
      props.put("bootstrap.servers", "localhost:9092,localhost:9093");
      props.put("key.serializer",org.apache.kafka.common.serialization.IntegerSerializer.class.getName());
      props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
      props.put("schema.registry.url", "http://localhost:8081");
      Producer<Integer, AvroOrder> producer = new KafkaProducer <>(props);
      Integer key = 1;
      AvroOrder order = new AvroOrder(1233, 1001, "abc@abc.com", "Jug", 10);
      
      
	  ProducerRecord<Integer, AvroOrder> record = new ProducerRecord<>(topicName,key,order);
	  producer.send(record);
      producer.close();
	  
	  System.out.println("Order Producer Completed.");
   }
}