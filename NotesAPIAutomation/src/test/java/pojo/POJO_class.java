package pojo;

public class POJO_class
{
	private String email;
	private String password;
	private String name;
	public POJO_class(String email,String password)
	{
		this.email=email;
		this.password=password;
	}
	public POJO_class(String name,String email,String password)
	{
		this.name=name;
		this.email=email;
		this.password=password;
	}
	public void setEmail()
	{
		this.email=email;
	}
	public void setPassword()
	{
		this.password=password;
	}
	public void setName()
	{
		this.name=name;
	}
	public String getEmail()
	{
		return email;
	}
	public String getPassword()
	{
		return password;
	}
	public String getName()
	{
		return name;
	}


}
