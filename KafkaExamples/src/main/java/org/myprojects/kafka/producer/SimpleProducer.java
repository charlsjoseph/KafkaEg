package org.myprojects.kafka.producer;

import java.util.*;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.*;
public class SimpleProducer {
  
   public static void main(String[] args) throws Exception{
           
      String topicName = "SimpleProducerTopic";
	  String key = "Key1";
	  String value = "Value-1";
      
      Properties props = new Properties();
      props.put("bootstrap.servers", "localhost:9092,localhost:9093");
      props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");         
      props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
      Producer<String, String> producer = new KafkaProducer <>(props);
	
	  ProducerRecord<String, String> record = new ProducerRecord<>(topicName,key,value);
	  // Synchronous call 
	  
	  Future<RecordMetadata> metastore = producer.send(record);	
	  if (metastore!=null ) {
		  System.out.println("Message Sent, partition" + metastore.get().partition() );
	  }
	  
	  // Asynchronous  call 
	  producer.send(record, new Callback () {

		@Override
		public void onCompletion(RecordMetadata metastore, Exception exception) {
			if (metastore!=null) 
				System.out.println("Message Sent, partition" + metastore.partition() );
			if (exception!=null) {
				// retry method
			}
			
		}} 
	
	);
	  
      producer.close();
	  
	  System.out.println("SimpleProducer Completed.");
   }
}