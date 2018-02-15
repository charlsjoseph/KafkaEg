package org.myprojects.kafka.producer;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderSerializer implements Serializer<Order>{

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] serialize(String arg0, Order arg1) {
		 byte[] retVal = null;
		    ObjectMapper objectMapper = new ObjectMapper();
		    try {
		      retVal = objectMapper.writeValueAsString(arg1).getBytes();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    return retVal;	}

}
