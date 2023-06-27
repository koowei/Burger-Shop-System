package Objects;

public class Client extends User {

	private String name;
	public Client(String userID, String password,String name) {
		super(userID, password);
		this.name = name;
	}
	///////////////////////////////////////////////////////////
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	@Override
	public String toString()
	{
		return "User Type :"+this.getClass().getName().substring(7)
			 + "\nUser Id :"+this.getID()
			 + "\nClient Name :"+this.getName();
	}
	
}
