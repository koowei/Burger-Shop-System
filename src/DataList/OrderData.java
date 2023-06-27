package DataList;

import java.util.List;

import Objects.Client;
import Objects.Order;
import Objects.OrderDetail;

public class OrderData implements IObjectData{
	private static OrderData single_instance = null;
	private java.util.ArrayList<Order> orders;
	private OrderData()
	{
		orders = new java.util.ArrayList<Order> ();
		defaultObject();
	}
	public static OrderData getInstance() {
		if(single_instance == null)
			single_instance = new OrderData();
		return single_instance;
	}

	@Override
	public Object[] getArray() {
		Order [] ordersArr = new Order[this.orders.size()];
		return this.orders.toArray(ordersArr);
	}

	@Override
	public void defaultObject() {

		Order order1 = new Order(new Client("user1", "pass1", "John Smith"), 1);
		order1.getOrderDetails().add(new OrderDetail("Veggie Burger", 2, 9.99));
		order1.getOrderDetails().add(new OrderDetail("Classic Cheeseburger", 1, 12.99));
		orders.add(order1);

		Order order2 = new Order(new Client("user2", "pass2", "Jane Doe"), 2);
		order2.getOrderDetails().add(new OrderDetail("Bacon Cheeseburger", 1, 14.99));
		orders.add(order2);

		Order order3 = new Order(new Client("user3", "pass3", "Bob Johnson"), 3);
		order3.getOrderDetails().add(new OrderDetail("Mushroom Swiss Burger", 2, 13.99));
		order3.getOrderDetails().add(new OrderDetail("Spicy Chicken Sandwich", 1, 10.99));
		orders.add(order3);

		Order order4 = new Order(new Client("user1", "pass1", "John Smith"), 4);
		order4.getOrderDetails().add(new OrderDetail("Grilled Chicken Sandwich", 1, 11.99));
		orders.add(order4);

		Order order5 = new Order(new Client("user2", "pass2", "Jane Doe"), 5);
		order5.getOrderDetails().add(new OrderDetail("Fish Burger", 1, 12.99));
		order5.getOrderDetails().add(new OrderDetail("Impossible Burger", 1, 15.99));
		orders.add(order5);

		Order order6 = new Order(new Client("user3", "pass3", "Bob Johnson"), 6);
		order6.getOrderDetails().add(new OrderDetail("Double Bacon Cheeseburger", 2, 17.99));
		orders.add(order6);

		Order order7 = new Order(new Client("user1", "pass1", "John Smith"), 7);
		order7.getOrderDetails().add(new OrderDetail("Turkey Burger", 1, 11.99));
		orders.add(order7);

		Order order8 = new Order(new Client("user2", "pass2", "Jane Doe"), 8);
		order8.getOrderDetails().add(new OrderDetail("Veggie Burger", 1, 9.99));
		order8.getOrderDetails().add(new OrderDetail("Bacon Cheeseburger", 1, 14.99));
		order8.getOrderDetails().add(new OrderDetail("Spicy Chicken Sandwich", 1, 10.99));
		orders.add(order8);

		Order order9 = new Order(new Client("user3", "pass3", "Bob Johnson"), 9);
		order9.getOrderDetails().add(new OrderDetail("Classic Cheeseburger", 2, 12.99));
		order9.getOrderDetails().add(new OrderDetail("Grilled Chicken Sandwich", 1, 11.99));
		order9.getOrderDetails().add(new OrderDetail("Fish Burger", 1, 12.99));
		orders.add(order9);

		Order order10 = new Order(new Client("user1", "pass1", "John Smith"), 10);
		order10.getOrderDetails().add(new OrderDetail("Mushroom Swiss Burger", 1, 13.99));
		order10.getOrderDetails().add(new OrderDetail("Impossible Burger", 1, 15.99));
		orders.add(order10);


		
	}
	@Override
	public List<Order> record() {
		// TODO Auto-generated method stub
		return this.orders;
	}

}
