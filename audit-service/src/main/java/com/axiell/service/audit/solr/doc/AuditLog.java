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

}
