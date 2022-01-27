package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;
import entities.Product;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		
		System.out.println("Enter cliente data:");
				
		Order order = new Order();
		Client client = new Client();
		
		System.out.print("Name: ");
		client.setName(sc.nextLine());
		
		System.out.print("Email: ");
		client.setEmail(sc.nextLine());
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		client.setBirthDate(sdf.parse(sc.nextLine()));
		
		order.setClient(client);
		
		System.out.println("Enter order data:");
		
		System.out.print("Status: ");
		order.setStatus(OrderStatus.valueOf(sc.nextLine()));
		
		System.out.print("How many items to this order? ");
		int n_items = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < n_items; i++) {
			System.out.printf("Enter #%d item data:%n", i + 1);
			Product p = new Product();
			
			System.out.print("Product name: ");
			p.setName(sc.nextLine());
			
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			p.setPrice(price);
			
			OrderItem o_item = new OrderItem();
			o_item.setProduct(p);
			o_item.setPrice(price);
			
			System.out.print("Quantity: ");
			o_item.setQuantity(sc.nextInt());
			
			sc.nextLine();
			
			order.addItem(o_item);
		}
		
		order.setMoment(new Date());
		
		System.out.println(order);
						
		sc.close();
	}

}
