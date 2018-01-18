package com.utils;

import java.io.Serializable;
import java.util.Date;

public class BaseModel implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String beginRow;
	private String pageSize;
	private Long createBy;
	private Date createTime;
	private Date updateTime;
	private Long updateBy;
	private Long version;
	private Integer flagPage;
	private Page page;
	

	public BaseModel()
	{
	}

	public String getBeginRow()
	{
		return beginRow;
	}

	public void setBeginRow(String beginRow)
	{
		this.beginRow = beginRow;
	}

	public String getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(String pageSize)
	{
		this.pageSize = pageSize;
	}

	public Long getCreateBy()
	{
		return createBy;
	}

	public void setCreateBy(Long createBy)
	{
		this.createBy = createBy;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	public Long getUpdateBy()
	{
		return updateBy;
	}

	public void setUpdateBy(Long updateBy)
	{
		this.updateBy = updateBy;
	}

	public Long getVersion()
	{
		return version;
	}

	public void setVersion(Long version)
	{
		this.version = version;
	}

	public Integer getFlagPage()
	{
		return flagPage;
	}

	public void setFlagPage(Integer flagPage)
	{
		this.flagPage = flagPage;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
}
