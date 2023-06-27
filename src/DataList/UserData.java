package DataList;

import java.util.List;

import Objects.Admin;
import Objects.Client;
import Objects.User;

public class UserData implements IObjectData{
	private static UserData single_instance = null;
	private java.util.ArrayList<User> users;
	private UserData()
	{
		users = new java.util.ArrayList<User> ();
		defaultObject();
	}
	public static UserData getInstance() {
		if(single_instance == null)
			single_instance = new UserData();
		return single_instance;
	}

	@Override
	public Object[] getArray() {
		User [] usersArr = new User[this.users.size()];
		return this.users.toArray(usersArr);
	}

	@Override
	public void defaultObject() {
		users.add(new Admin("Admin","Admin","1"));
		users.add(new Admin("Manager","Manager","2"));
		users.add(new Admin("Cashier","Cashier","1"));
		users.add(new Client("user1", "pass1", "John Smith"));
		users.add(new Client("user2", "pass2", "Jane Doe"));
		users.add(new Client("user3", "pass3", "Bob Johnson"));
		users.add(new Client("user4", "pass4", "Sarah Lee"));
		users.add(new Client("user5", "pass5", "Mike Brown"));
		
	}
	@Override
	public List<User> record() {
		return this.users;
	}

}
