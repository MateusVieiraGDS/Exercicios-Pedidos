package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> OrderItems = new ArrayList<>();
	
	public Order() {}

	public Order(Date moment, OrderStatus status) {
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
}
