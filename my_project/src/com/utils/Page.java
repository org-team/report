package com.utils;

import java.io.Serializable;

public class Page implements Serializable {

	/**
	 * int start=(page.getCurPage()-1)*page.getPageCount()+1;
	 * int end  = (page.getCurPage()-1)*page.getPageCount() + page.getPageCount();
	 */
	private static final long serialVersionUID = 1L;

	// 当前第几页 从0开始
	private Integer curPage;
	// 一共多少页
	private Integer maxPage;
	// 数据总数
	private int totalRecord;
	// 每页多少数据
	private int pageCount;
	
	private int pageNumEnd;
	private int pageNumBegin;

	public Page() {
		this.curPage = Integer.valueOf(1);
		this.pageCount = 10;
	}

	public int getPageNumEnd() {
		this.pageNumEnd = (this.getCurPage()-1)*this.getPageCount() + this.getPageCount();
		return pageNumEnd;
	}

	public void setPageNumEnd(int pageNumEnd) {
		this.pageNumEnd = pageNumEnd;
	}

	public int getPageNumBegin() {
		this.pageNumBegin = (this.getCurPage()-1)*this.getPageCount()+1; 
		return pageNumBegin;
	}

	public void setPageNumBegin(int pageNumBegin) {
		this.pageNumBegin = pageNumBegin;
	}

	public Integer getCurPage() {
		return this.curPage;
	}

	public void setCurPage(Integer curPage) {
		if (curPage.intValue() < 1) {
			this.curPage = Integer.valueOf(1);
		} else if ((this.maxPage != null)
				&& (this.maxPage.intValue() < curPage.intValue())) {
			this.curPage = this.maxPage;
		} else {
			this.curPage = curPage;
		}
	}

	public Integer getMaxPage() {
		return this.maxPage;
	}

	public void setMaxPage(Integer maxPage) {
		if (maxPage.intValue() > 0)
			this.maxPage = maxPage;
		else {
			this.maxPage = Integer.valueOf(1);
		}
	}

	public Integer getTotalRecord() {
		return Integer.valueOf(this.totalRecord);
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord.intValue();
		setMaxPage(Integer.valueOf((totalRecord.intValue() - 1)
				/ this.pageCount + 1));
	}

	public Integer getPageCount() {
		return Integer.valueOf(this.pageCount);
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount.intValue();
	}

}
