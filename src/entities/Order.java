package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> OrderItems = new ArrayList<>();
	private Client client;
	
	public Order() {}

	public Order(Client client, Date moment, OrderStatus status) {
		this.client = client;
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return this.client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItems() {
		return OrderItems;
	}
	
	public void addItem(OrderItem orderItem) {
		this.OrderItems.add(orderItem);
	}
	public void removeItem(OrderItem orderItem) {
		this.OrderItems.remove(orderItem);
	}
	public double total() {
		double sum = 0;
		for (OrderItem o_item : this.OrderItems) {
			sum += o_item.subTotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		StringBuilder result = new StringBuilder();
		
		result.append("\nORDER SUMMARY:");
		
		result.append("\nOrder moment: " + sdf2.format(getMoment()));
		result.append("\nOrder status: " + getStatus());
		result.append(String.format("%nClient: %s (%s) - %s", getClient().getName(), sdf.format(getClient().getBirthDate()), getClient().getEmail()));
		result.append("\nOrder items:");
		
		for (OrderItem o_item : getOrderItems()) {
			result.append( String.format("%n%s, $%.2f, Quantity: %d, Subtotal: $%.2f", o_item.getProduct().getName(), o_item.getPrice(), o_item.getQuantity(), o_item.subTotal()) );
		}
		
		result.append(String.format("%nTotal price: $%.2f%n", total()));
		
		return result.toString();
	} 
}
