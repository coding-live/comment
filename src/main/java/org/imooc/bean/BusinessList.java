package org.imooc.bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BusinessList {
	
	private boolean hasMore;
	private List<Business> data;
	
	public BusinessList() {
	    this.data = new ArrayList<>();
	}

	public boolean getHasMore() {
		return hasMore;
	}
	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}
	public List<Business> getData() {
	    return data;
	}
	public void setData(List<Business> data) {
	    this.data = data;
	}
}