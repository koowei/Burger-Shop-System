package Objects;

public class Session {

	private User currentUser;
	public Session(){
		
	}
	public void setCurrentUser(User user)
	{
		this.currentUser = user;
	}
	public User getCurrentUser()
	{
		return this.currentUser;
	}
	public boolean Login(String id,String pass,User[] users)
	{
		for(User i:users)
		{
			if(id.equals(i.getID()))
			{
				if(pass.equals(i.getPass()))
				{
					this.currentUser = i;
					return true;
				}	
			}
		}
		return false;
	}
}
