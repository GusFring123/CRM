package com.crm.common.utils;

import java.util.List;

public class Page<T> {

	private int total;//总页数
	private int page;//当前页
	private int size;//每页显示个数
    private List<T> rows;//对象集合

	public Page() {
	}

	public Page(int total, int page, int size, List<T> rows) {
		this.total = total;
		this.page = page;
		this.size = size;
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
    
	
    
}
