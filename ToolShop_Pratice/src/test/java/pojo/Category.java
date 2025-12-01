package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category
{
	@JsonProperty("parent_id")
	private String parentId;
	private String name,id,slug;
	@JsonProperty("sub_categories")
	private List<SubCategory> subCategory;
public Category()
{
	
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
public void setSubCategory(List<SubCategory> subCategory)
{
	this.subCategory=subCategory;
}
public List<SubCategory> getSubCategory()
{
	return subCategory;
}

}
