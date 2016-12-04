package com.axiell.app.search.dto;

/**
 * @author ashraf
 *
 */
public class AuditLog {
	
    private String id;
 
    private String userId;

	private String searchTerm;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

}
