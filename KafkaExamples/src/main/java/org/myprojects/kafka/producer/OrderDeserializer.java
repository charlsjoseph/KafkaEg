package org.myprojects.kafka.producer;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderDeserializer implements Deserializer<Order> {

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order deserialize(String arg0, byte[] byteValue) {
		ObjectMapper mapper = new ObjectMapper();
		Order order = null;
	    try {
	    	order = mapper.readValue(byteValue, Order.class);
	    } catch (Exception e) {
	 
	      e.printStackTrace();
	    }
	    return order;
	}

}
