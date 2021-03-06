package com.spoid.dto;

public class CriteriaMVDTO {
	private int page; // 페이지 번호(하단의 번호를 클릭)
	private int perPageNum; // 한 페이지에 보여줄 페이지 수
	private String keyword;
	private String flag;
	private String code;
	private String category;
	public CriteriaMVDTO() {
		// TODO Auto-generated constructor stub
		this.page=1;
		this.perPageNum = 50;
	}
	
	public CriteriaMVDTO(int page, int perPageNum, String keyword) {
		super();
		this.page = page;
		this.perPageNum = perPageNum;
		this.keyword = keyword;
	}

	public CriteriaMVDTO(int page, int perPageNum, String keyword, String flag, String code) {
		super();
		this.page = page;
		this.perPageNum = perPageNum;
		this.keyword = keyword;
		this.flag = flag;
		this.code = code;
	}

	public CriteriaMVDTO(int page, int perPageNum, String keyword, String flag, String code, String category) {
		super();
		this.page = page;
		this.perPageNum = perPageNum;
		this.keyword = keyword;
		this.flag = flag;
		this.code = code;
		this.category = category;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0) {
			this.page=1;
			return;
		}
		this.page = page;
	}
	//method for MyBatis SQL Mapper : 조회 시작 row : 취득하는 메서드

	public int getPageStart() {
		return (((this.page-1)*perPageNum)+1);
	}
	//method for MyBatis SQL Mapper : 조회 마지막 row : 취득하는 메서드
	
	public int getPerPageNum() {
		return this.page*perPageNum;
		//2 페이지 *10 = 20번 게시글까지 출력
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
		
	}

}
