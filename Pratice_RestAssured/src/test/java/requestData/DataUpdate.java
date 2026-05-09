package requestData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataUpdate
{
	private String year;
	private String price;
	@JsonProperty("CPU model")
	private String cpuModel;
	@JsonProperty("Hard disk size")
	private String hardDiskSize;
	private String color;
	public DataUpdate()
	{

	}
	public DataUpdate(String year,String price,String cpuModel,String hardDiskSize,String color)
	{
		this.year=year;
		this.price=price;
		this.cpuModel=cpuModel;
		this.hardDiskSize=hardDiskSize;
		this.color=color;
	}
	
	public void setYear(String year)
	{
		this.year=year;
	}
	public String getYear()
	{
		return year;
	}
	public void setPrice(String price)
	{
		this.price=price;
	}
	public String getPrice()
	{
		return price;
	}
	public String getCpuModel()
	{
		return cpuModel;
	}
	public void setCpuModel(String cpuModel)
	{
		this.cpuModel=cpuModel;
	}
	public String gethardDisk()
	{
		return hardDiskSize;
	}
	public void setHardDisk(String hardDiskSize)
	{
		this.hardDiskSize=hardDiskSize;
	}
	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color=color;
	}

}
