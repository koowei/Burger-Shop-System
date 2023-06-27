package View;


public class mainView {
	public void mainMenu(boolean type){
		if(type)
			System.out.println("\n---------------------\n"
					+"1. Order Management\n"
					+ "2. Item Management\n"
					+ "3. User Management\n"
					+ "4. Billing Statement\n"
					+ "5. Logout\n"
					+ "---------------------");
		else
			System.out.println("\n---------------------\n"
					+ "1. Create New Order\n"
					+ "2. Search for Item\n"
					+ "3. Billing Statement\n"
					+ "4. Logout\n"
					+ "---------------------");
	}
	public void preLoginMenu()
	{
		System.out.println("1. Login\n"
		 		 		 + "2. Sign Up\n");
	}
	public void loginMenu(int step)
	{
		switch(step)
		{
			case 1:
				System.out.println("User Id:");
				break;
			case 2:
				System.out.println("Password:");
				break;
			case 3:
				System.out.println("User Id not found OR Password Incorrect");
				break;
		}
	}
	public void signUpMenu(int step)
	{
		switch(step)
		{
			case 1:
				System.out.println("User Id:");
				break;
			case 2:
				System.out.println("Password:");
				break;
			case 3:
				System.out.println("Confirm Password:");
				break;
			case 4:
				System.out.println("Name:");
				break;
			case 5:
				System.out.println("Password not match");
				break;
			case 6:
				System.out.println("User Id existed in system , try another");
				break;
		}	
	}
	public void Management(String object)
	{
		System.out.println(
				  "1. Add "+object+"\n"
				+ "2. Delete "+object+"\n"
				+ "3. Update "+object+"\n"
				+ "4. List all "+object+"\n"
				+ "5. Exit to main menu");
	}
	public void ItemMenu(int step) {
		switch(step)
		{
		case 1:
			System.out.println("Enter new Item name : ");
			break;
		case 2:
			System.out.println("Enter Item description : ");
			break;
		case 3:
			System.out.println("Enter Item status : ");
			break;
		case 4:
			System.out.println("Enter Item unit price : ");
			break;
		}
	}
	public void ItemUpdateMenu()
	{
		System.out.println(
				  "Update item's\n"
				+ "1. Name\n"
				+ "2. Description\n"
				+ "3. Status\n"
				+ "4. Unit Price\n");
	}
	public void UserMenu(int step) {
		switch(step)
		{
		case 1:
			System.out.println("Enter new Admin User Id : ");
			break;
		case 2:
			System.out.println("Enter new Admin User Password : ");
			break;
		case 3:
			System.out.println("Enter new Admin User Employee Number/Clie : ");
			break;
		
		}
	}
	public void UserUpdateMenu(String type)
	{
		System.out.println(
				  "Update User's \n"
				+ "1. Password\n");
		if(type.equals("Admin"))
			System.out.println("2. Employee Number\n");
		else
			System.out.println("2. Name\n");
	}
	public void OrderUpdateMenu()
	{
		System.out.println(
				  "Update Order Detail's \n"
				+ "1. Add lines\n"
				+ "2. Delete lines\n");
	}
	public void Listing(int count , String str)
	{
		System.out.println("("+(count+1)+")------------------\n"+str+"\n---------------------");
	}
	public void OperationMenu(String object,String operation)
	{
		System.out.print("Enter "+object+" to "+operation+" :");
	}
	public void SucessMessage(String object,String operation)
	{
		System.out.print("The "+object+" have been "+operation+" Sucessfully");
	}
	public void InvalidMessage()
	{
		System.out.println("\nInvalid Option");
	}
	public void ObjectNotFoundMessage(String object)
	{
		System.out.println("this "+object+" not found in system");
	}
	public void CreateOrderMessage(int step)
	{
		switch(step)
		{
		case 1:
			System.out.println("Enter Number of item to add it into your order :");
			break;
		case 2:
			System.out.println("Enter Quantity of item :");
			break;
		case 3:
			System.out.println("Continue add Item to Order ? Enter 0(zero) to complete this order.\n");
			break;
		}
	}
	
}
