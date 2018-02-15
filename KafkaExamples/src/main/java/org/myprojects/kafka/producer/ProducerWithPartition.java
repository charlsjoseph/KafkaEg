package org.myprojects.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerWithPartition {

	public static void main(String[] args) {

	      String topicName = "SensorData";

	      Properties props = new Properties();
	      props.put("bootstrap.servers", "localhost:9092,localhost:9093");
	      props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
	      props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	      props.put("partitioner.class", SensorPartitioner.class.getName());
	      props.put("speed.sensor.name", "S1");

	      Producer<String, String> producer = new KafkaProducer <>(props);

	         for (int i=0 ; i<10 ; i++)
	         producer.send(new ProducerRecord<>(topicName,"S2","500"+i));

	         for (int i=0 ; i<10 ; i++)
	         producer.send(new ProducerRecord<>(topicName,"S1","500"+i));

	      producer.close();

	          System.out.println("SimpleProducer Completed.");
	   }

}
