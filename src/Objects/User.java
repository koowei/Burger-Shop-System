package Objects;


public abstract class User {
	private String userID;
	private String password;
	public User(String userID,String password)
	{
		this.userID = userID;
		this.password = password;
	}
	public String getID()
	{
		return this.userID;
	}
	public String getPass()
	{
		return this.password;
	}
	public void setPass(String newPassword)
	{
		this.password = newPassword;
	}
	public String toString()
	{
		return null;
	}
}
