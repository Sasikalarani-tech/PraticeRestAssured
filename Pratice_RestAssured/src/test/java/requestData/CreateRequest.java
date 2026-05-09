package requestData;

public class CreateRequest 
{
	private String name;
	private Data data;
	public CreateRequest(String name,Data data)
	{
		this.name=name;
		this.data=data;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setData(Data data)
	{
		this.data=data;
	}
	public Data getData()
	{
		return data;
	}

}
