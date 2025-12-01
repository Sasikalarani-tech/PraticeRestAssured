package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubCategory 
{
    @JsonProperty("parent_id")
    private String parentId;
	private String name,id,slug;
	@JsonProperty("sub_categories")
	private List<SubCategory> subCategories;

	public SubCategory()
	{
		this.name=name;
		this.id=id;
		this.slug=slug;
		this.parentId=parentId;
	}

public void setId(String id)
{
	this.id=id;
}
public String getId()
{
	return id;
}
public void setName(String name)
{
	this.name=name;
}
public String getName()
{
	return name;
}
public void setSlug(String slug)
{
	this.slug=slug;
}
public String getSlug()
{
	return slug;
}
public void setParentid(String parentId)
{
	this.parentId=parentId;
}
public String getParentid()
{
	return parentId;
}
public void setSubCategory(List<SubCategory> subCategories)
{
	this.subCategories=subCategories;
}
public List<SubCategory> getSubCategory()
{
	return subCategories;
}

}
