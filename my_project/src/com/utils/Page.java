package com.utils;
import java.io.Serializable;

public class Page implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer curPage;
	private Integer maxPage;
	private int totalRecord;
	private int pageCount;
	private int filterRecord;
	private boolean needPading;

	public Page()
	{
		curPage = Integer.valueOf(1);
		pageCount = 10;
		needPading = true;
	}

	public Integer getCurPage()
	{
		return curPage;
	}

	public void setCurPage(Integer curPage)
	{
		if (curPage.intValue() < 1)
			this.curPage = Integer.valueOf(1);
		else
		if (maxPage != null && maxPage.intValue() < curPage.intValue())
			this.curPage = maxPage;
		else
			this.curPage = curPage;
		if (maxPage != null)
			filterRecord = (this.curPage.intValue() - 1) * pageCount;
	}

	public Integer getMaxPage()
	{
		return maxPage;
	}

	public void setMaxPage(Integer maxPage)
	{
		if (maxPage.intValue() > 0)
			this.maxPage = maxPage;
		else
			this.maxPage = Integer.valueOf(1);
		if (curPage != null)
			filterRecord = (curPage.intValue() - 1) * pageCount;
		needPading = false;
	}

	public Integer getTotalRecord()
	{
		return Integer.valueOf(totalRecord);
	}

	public void setTotalRecord(Integer totalRecord)
	{
		this.totalRecord = totalRecord.intValue();
		setMaxPage(Integer.valueOf((totalRecord.intValue() - 1) / pageCount + 1));
		if (curPage != null && maxPage != null)
			filterRecord = (curPage.intValue() - 1) * pageCount;
	}

	public Integer getPageCount()
	{
		return Integer.valueOf(pageCount);
	}

	public void setPageCount(Integer pageCount)
	{
		this.pageCount = pageCount.intValue();
	}

	public Integer getFilterRecord()
	{
		return Integer.valueOf(filterRecord);
	}

	public void setNeedPading(boolean needPading)
	{
		this.needPading = needPading;
	}

	public boolean needQueryPading()
	{
		return needPading;
	}
}
