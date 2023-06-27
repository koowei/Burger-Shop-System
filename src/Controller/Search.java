package Controller;

import DataList.ItemData;
import DataList.OrderData;
import DataList.UserData;
import Objects.Item;
import Objects.Order;
import Objects.User;

public class Search implements Operation{
	UserData userRecord = UserData.getInstance();
	OrderData orderRecord = OrderData.getInstance();
	ItemData itemRecord = ItemData.getInstance();
	@Override
	public boolean onUser(User user) {
		for(User u:userRecord.record())
			if(user.equals(u))
				return true;
		return false;
	}
	public User onUser(String id) {
		for(User u:userRecord.record())
			if(id.equals(u.getID()))
				return u;
		return null;
	}
	

	@Override
	public boolean onItem(Item item) {
		for(Item i:itemRecord.record())
			if(item.equals(i))
				return true;
		return false;
	}
	public Item onItem(int id)
	{
		for(Item i:itemRecord.record())
			if(id == (i.getId()))
				return i;
		return null;
	}

	@Override
	public boolean onOrder(Order order) {
		// TODO Auto-generated method stub
		for(Order o:orderRecord.record())
			if(order.equals(o))
				return true;
		return false;
	}
	public Order onOrder(int id)
	{
		for(Order o:orderRecord.record())
			if(id == o.getOrderId())
				return o;
		return null;
	}

}
