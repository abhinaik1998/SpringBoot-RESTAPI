package com.springboot.blog.Payload;
import java.util.List;

import com.springboot.blog.DTO.PostDTO;
import com.springboot.blog.Entity.Post;
public class PostResponse {

	private List<PostDTO> content;
	private int pageNo;
	private int pageSize;
	private long totalElement;
	private int totalpages;
	private boolean lastPage;
	public List<PostDTO> getContent() {
		return content;
	}
	public void setContent(List<PostDTO> content) {
		this.content = content;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalElement() {
		return totalElement;
	}
	public void setTotalElement(long l) {
		this.totalElement = l;
	}
	public int getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}
	public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	public PostResponse( int pageNo, int pageSize, long totalElement, int totalpages,
			boolean lastPage,List<PostDTO> content) {
		super();
		
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalElement = totalElement;
		this.totalpages = totalpages;
		this.lastPage = lastPage;
		this.content = content;
	}
	public PostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
