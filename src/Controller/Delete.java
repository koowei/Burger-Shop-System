package Controller;

import DataList.ItemData;
import DataList.OrderData;
import DataList.UserData;
import Objects.Item;
import Objects.Order;
import Objects.User;

public class Delete implements Operation{
	UserData userRecord = UserData.getInstance();
	OrderData orderRecord = OrderData.getInstance();
	ItemData itemRecord = ItemData.getInstance();

	@Override
	public boolean onUser(User user) {
		// TODO Auto-generated method stub
		return userRecord.record().remove(user);
	}

	@Override
	public boolean onItem(Item item) {
		// TODO Auto-generated method stub
		return itemRecord.record().remove(item);
	}

	@Override
	public boolean onOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRecord.record().remove(order);
		
	}
}
