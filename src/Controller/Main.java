package Controller;
import java.util.Scanner;

import DataList.*;
import Objects.*;
import View.mainView;
public class Main {
	public static void main(String [] args)
	{
		boolean loop = false;
		do {
		new mainView().preLoginMenu();
		Session currentSession = createSession(getOptionInput(1,2));
		if(currentSession!=null)
		{
			EventListener(currentSession);
		}
		}while(!loop);
	}
	public static Session createSession(int option)
	{
		Session session = new Session();
		switch(option)
		{
		
			case 1:
				if(loginEvent(session))
					return session;
				else
					return null;
			case 2:
				if (signUpEvent(session))
					return session; 
				else
					return null;		
		}
		return null;
	}

	public static boolean loginEvent(Session session) {
		String [] temp = new String[2];
		for(int i=0;i<temp.length;i++)
		{
			new mainView().loginMenu(i+1);
			temp[i]= getStringInput();
		}
		
		if(session.Login(temp[0],temp[1], (User[]) UserData.getInstance().getArray()))
			return true;
		else
		{
			new mainView().loginMenu(3);
			return false;
		}
		
	}
	public static boolean signUpEvent(Session session) 
	{
		String [] temp = new String[4];
		for(int i=0;i<temp.length;i++)
		{
			new mainView().signUpMenu(i+1);
			temp[i]=getStringInput();
		}
		if(!(temp[1].equals(temp[2])))
		{
			new mainView().signUpMenu(5);
			return signUpEvent(session);
		}
		else
		{
			for(User u:(User[]) UserData.getInstance().getArray())
			{
				if(u.getID().equals(temp[0]))
				{
					new mainView().signUpMenu(6);
					return false;
				}
			}
			return new Add().onUser(new Client(temp[0],temp[1],temp[3]));
		}
		
	}
	
	public static void EventListener(Session session)
	{
		while(session != null) {
		if(session.getCurrentUser() instanceof Admin)
		{
			new mainView().mainMenu(true);
			switch(getOptionInput(1,5))
			{
				case 1://order management
					new mainView().Management("Order");
					switch(getOptionInput(1,5))
					{ 
					case 1://add order in system
						addOrder(session);
						break;
					case 2:// delete order
						deleteOrder();
						break;
					case 3: //update order
						updateOrder();
						break;
					case 4: //list all order
						viewAll((Order[])OrderData.getInstance().getArray());
						break;
					case 5:
						break;
					}
					break;
				case 2://item management
					new mainView().Management("Item");
					switch(getOptionInput(1,5))
					{
						case 1://add item in system
							addItem();
							break;
						case 2://delete item in system
							deleteItem();
							break;
						case 3://update item in system
							updateItem();
							break;
						case 4://list items
							viewAll((Item[])ItemData.getInstance().getArray());
							break;
						case 5:
							break;
					}
					break;		
				case 3:
					new mainView().Management("User");
					switch(getOptionInput(1,5))
					{
					case 1://add admin user
						addUser();
						break;
					case 2://delete user
						deleteUser();
						break;
					case 3://update user (userId to able to be edit)
						updateUser();
						break;
					case 4://list users
						viewAll((User[])UserData.getInstance().getArray());
						break;
					case 5://exit
						break;
					}
					break;
				case 4://billing statement all
					viewBilling(session.getCurrentUser());
					break;
				case 5://logout
					session = null;
					break;
					
			}
		}
		else//Client View
		{
			new mainView().mainMenu(false);
			switch(getOptionInput(1,4))
			{
				case 1:
					addOrder(session);
					break;
				case 2:
					searchItem();
					break;
				case 3:
					viewBilling(session.getCurrentUser());
					break;
				case 4:
					session = null;
					break;
					
			}
		}
		}
	}
	//order management
	public static void addOrder(Session session)
	{
		Order currentOrder = new Order(session.getCurrentUser(),(((Order) OrderData.getInstance().getArray()[OrderData.getInstance().getArray().length-1]).getOrderId()+1));
		for(int i=0;i<ItemData.getInstance().getArray().length;i++)
			new mainView().Listing(i,((Item) ItemData.getInstance().getArray()[i]).getName());
		int choice,quantity; 
		Item itemChoice;
		do
		{
			new mainView().CreateOrderMessage(1);
			choice = getIntegerInput();
			if(choice != 0)
			{
				itemChoice = (Item) ItemData.getInstance().getArray()[choice-1];
				new mainView().CreateOrderMessage(2);
				quantity = getIntegerInput();
				currentOrder.addItem(new OrderDetail(itemChoice.getName(),quantity,itemChoice.getPrice()));
				new mainView().CreateOrderMessage(3);
			}
			
		}while(choice != 0);
		 new Add().onOrder(currentOrder);
		 new mainView().SucessMessage("Order", "Added");
	}
	public static void deleteOrder()
	{
		new mainView().OperationMenu("Order id", "Delete");
		Order orderToDelete = new Search().onOrder(getIntegerInput());
		if(orderToDelete != null)
		{
			if(new Delete().onOrder(orderToDelete))
				new mainView().SucessMessage("Order:"+orderToDelete.getOrderId(), "Delete");
		}
		else
			new mainView().ObjectNotFoundMessage("Order");
	}
	public static void updateOrder()
	{
		new mainView().OperationMenu("Order id", "Update");
		Order orderToUpdate = new Search().onOrder(getIntegerInput());
		if(orderToUpdate != null)
		{
			new mainView().Listing(1,orderToUpdate.toString());
			new mainView().OrderUpdateMenu();
			if(getIntegerInput() == 2)
			{
				new mainView().OperationMenu("Lines number", "Update");
				int option = getOptionInput(1,orderToUpdate.getOrderDetails().size()-1);
				orderToUpdate.getOrderDetails().remove(option-1);
			}
			else
			{
				new mainView().OperationMenu("Item Name","Add");
				String newItemName = getStringInput();
				new mainView().OperationMenu("Item Quantity","Add");
				int newItemQuantity = getIntegerInput();
				new mainView().OperationMenu("Item Unit Price","Add");
				double newItemPrice = getDoubleInput();
				orderToUpdate.getOrderDetails().add(new OrderDetail(newItemName,newItemQuantity,newItemPrice));
			}
		}
		else
			new mainView().ObjectNotFoundMessage("Order");
	}
	//item management
	public static void addItem()
	{
		String [] temp = new String[4];
		double unitPrice;
		for(int i=0;i<temp.length;i++)
		{
			new mainView().ItemMenu(i+1);
			if(i == 3)
			{
				unitPrice = getDoubleInput();
				temp[i] = String.valueOf(unitPrice);
			}
			else
				temp[i] = getStringInput();
		}
		new Add().onItem(new Item(((Item) ItemData.getInstance().getArray()[ItemData.getInstance().getArray().length-1]).getId()+1,temp[0],temp[1],temp[2],Double.parseDouble(temp[3])));
	}
	public static void deleteItem()
	{
		new mainView().OperationMenu("Item id", "Delete");
		Item itemToDelete = new Search().onItem(getIntegerInput());
		if(itemToDelete != null)
		{
			if(new Delete().onItem(itemToDelete))
				new mainView().SucessMessage("Item:"+itemToDelete.getName(), "Delete");
		}
		else
			new mainView().ObjectNotFoundMessage("Item");
	}
	public static void updateItem()
	{
		new mainView().OperationMenu("Item id", "Edit");
		Item itemToUpdate = new Search().onItem(getIntegerInput());
		if(itemToUpdate != null)
		{
			new mainView().ItemUpdateMenu();
			int option = getOptionInput(1,4);
			new mainView().ItemMenu(option);
			String newValue = getStringInput();
			switch(option)
			{
			case 1://update item's name
				itemToUpdate.setName(newValue);
				break;
			case 2://update item's description
				itemToUpdate.setDescription(newValue);
				break;
			case 3://update item's status
				itemToUpdate.setStatus(newValue);
				break;
			case 4://update item's price
				try {
					itemToUpdate.setPrice(Double.parseDouble(newValue));
				}catch(Exception e) {
					new mainView().InvalidMessage();
				}
				break;
			}
		}else
		{
			new mainView().ObjectNotFoundMessage("Item");
		}
	}
	public static void searchItem()
	{
		new mainView().OperationMenu("Item","Search");
		String keyword = getStringInput();
		for(Item i:(Item[])ItemData.getInstance().getArray())
		{
			if(i.getName().contains(keyword))
			{
				new mainView().Listing(i.getId(),i.toString());
			}
		}
	}
	
	//user management
	public static void addUser()
	{
		String [] temp = new String[3];
		for(int i=0;i<temp.length;i++)
		{
			new mainView().UserMenu(i+1);
			temp[i]=getStringInput();
		}
		if(new Add().onUser(new Admin(temp[0],temp[1],temp[2])))
			new mainView().SucessMessage("New Admin User", "Added");
	}
	public static void deleteUser()
	{
		new mainView().OperationMenu("User Id", "Delete");
		User userToDelete = new Search().onUser(getStringInput());
		if(userToDelete != null)
		{
			if(new Delete().onUser(userToDelete))
				new mainView().SucessMessage("User", "Delete");
		}
		else
			new mainView().ObjectNotFoundMessage("User");
	}
	public static void updateUser()
	{
		new mainView().OperationMenu("User", "Update");
		User userToUpdate = new Search().onUser(getStringInput());
		if(userToUpdate != null)
		{
			new mainView().UserUpdateMenu(userToUpdate.getClass().getName());
			int option = getOptionInput(1,2);
			new mainView().UserMenu(option+1);
			if(option == 1)
			{
				userToUpdate.setPass(getStringInput());
			}
			else if(option == 2)
			{
				if(userToUpdate instanceof Admin)
					((Admin) userToUpdate).setEmployeeNumber(getStringInput());
				else
					((Client) userToUpdate).setName(getStringInput());
			}
		}
		else
			new mainView().ObjectNotFoundMessage("User");
	}
	
	public static void viewBilling(User user)
	{
		boolean result = false;
		if(user instanceof Admin)
		{
			System.out.println("OrderId\t|OrderDate\t\t\t|OrderBy|Total Price\n");
			for(Order o:(Order[])OrderData.getInstance().getArray())
				System.out.println(o.getOrderId()+"\t|"+o.getDate()+"\t|"+o.getUser().getID()+"\t|"+o.getTotalPrice());
			result = true;
		}
		else
			System.out.println("OrderId\t|OrderDate\t\t\t|Total Price\n");
			for(Order o:(Order[])OrderData.getInstance().getArray())
			{
				if(o.getUser().equals(user))
				{
					System.out.println(o.getOrderId()+"\t|"+o.getDate()+"\t|"+o.getTotalPrice());
					result = true;
				}
				
			}
			if(!result)
				System.out.println("No Result found \n\n\n");
			
	}
	
	public static void viewAll(Object[] arr)
	{
		for(int i=0;i<arr.length;i++)
			new mainView().Listing(i,arr[i].toString());
	}
	public static int getIntegerInput()
	{
		Scanner input = new Scanner(System.in);
		try {
			String option = input.nextLine();
			return Integer.parseInt(option);
		}catch(NumberFormatException e)
		{
			System.out.println("Invalid Input , Integer Only : ");
			return getIntegerInput();
		}
	}
	public static double getDoubleInput()
	{
		Scanner input = new Scanner(System.in);
		try {
			String option = input.nextLine();
			return Double.parseDouble(option);
		}catch(NumberFormatException e)
		{
			System.out.println("Invalid Input , Double Only : ");
			return getDoubleInput();
		}
	}
	public static String getStringInput()
	{
		Scanner input = new Scanner(System.in);
		String str;
		do {
			str = input.nextLine();
		}while(str == null || str == "" || str == "\n");
		return str.strip();
	}
	public static int getOptionInput(int lowerBound , int upperBound)
	{
		int option = getIntegerInput();
		if(option < lowerBound || option > upperBound)
		{
			new mainView().InvalidMessage();
			return getOptionInput(lowerBound,upperBound);
		}
		return option;
	}
}
