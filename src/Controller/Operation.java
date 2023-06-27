package Controller;
import Objects.*;

public interface Operation {

	public boolean onUser(User user);
	public boolean onItem(Item item);
	public boolean onOrder(Order order);
}
