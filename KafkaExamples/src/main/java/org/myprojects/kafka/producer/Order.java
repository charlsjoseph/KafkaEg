package org.myprojects.kafka.producer;

public class Order {
	
	public Order(int orderId, int customerId, String customerEmailId, String itemDesc, float price) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.customerEmailId = customerEmailId;
		this.itemDesc = itemDesc;
		this.price = price;
	}
	public Order() {
		
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", customerEmailId=" + customerEmailId
				+ ", itemDesc=" + itemDesc + ", price=" + price + "]";
	}	
	private int orderId;
	private int customerId;
	private String customerEmailId;
	private String itemDesc;
	private float price;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	

}
