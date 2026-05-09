package utils;

public class ThreadLocalContext 
{
	private static ThreadLocal<String> objectId=new ThreadLocal<>();
	public static void setObjectId(String id)
	{
		objectId.set(id);
	}
	public static String getObjectId()
	{
		return objectId.get();
	}

}
