package Objects;

public class Admin extends User{
	
	private String employeeNumber;
	public Admin(String userID, String password,String employeeNumber) {
		super(userID, password);
		this.employeeNumber = employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber)
	{
		this.employeeNumber = employeeNumber;
	}
	public String getEmployeeNumber()
	{
		return this.employeeNumber;
	}
	@Override
	public String toString()
	{
		return "User Type :"+this.getClass().getName().substring(7)
			 + "\nUser Id :"+this.getID()
			 + "\nEmployeeId :"+this.getEmployeeNumber();
	}
}
