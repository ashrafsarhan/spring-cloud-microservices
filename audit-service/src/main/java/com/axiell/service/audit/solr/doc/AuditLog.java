package com.axiell.service.audit.solr.doc;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * @author ashraf
 *
 */
@SolrDocument(solrCoreName = "audit")
public class AuditLog {
	
	@Id
    @Indexed(name = "id", type = "string")
    private String id;
 
    @Indexed(name = "userId", type = "string")
    private String userId;

	@Indexed(name = "searchTerm", type = "string")
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
