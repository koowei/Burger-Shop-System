package Controller;

import DataList.*;
import Objects.Item;
import Objects.Order;
import Objects.User;

public class Add implements Operation{
	UserData userRecord = UserData.getInstance();
	OrderData orderRecord = OrderData.getInstance();
	ItemData itemRecord = ItemData.getInstance();
	@Override
	public boolean onUser(User user) {
		// TODO Auto-generated method stub
		return userRecord.record().add(user);
	}

	@Override
	public boolean onItem(Item item) {
		// TODO Auto-generated method stub
		return itemRecord.record().add(item);
	}

	@Override
	public boolean onOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRecord.record().add(order);
	}

}
