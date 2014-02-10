package com.soryin.vo;


public class PageView<T> {
	/** 总页数 **/
	private long totalpage = 1;
	/** 每页显示记录数 **/
	private int maxresult = 10;
	/** 当前页 **/
	private int currentpage = 1;
	/** 总记录数 **/
	private long totalrecord;
	/** 页码数量 **/
	private int pagecode = 3;
	public long getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(long totalpage) {
		this.totalpage = totalpage;
	}
	public int getMaxresult() {
		return maxresult;
	}
	public void setMaxresult(int maxresult) {
		this.maxresult = maxresult;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public long getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(long totalrecord) {
		this.totalrecord = totalrecord;
	}
	public int getPagecode() {
		return pagecode;
	}
	public void setPagecode(int pagecode) {
		this.pagecode = pagecode;
	}

}
