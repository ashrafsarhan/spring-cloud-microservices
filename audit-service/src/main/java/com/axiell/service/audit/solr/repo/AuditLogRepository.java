package com.axiell.service.audit.solr.repo;

import java.util.List;

import org.apache.commons.math.stat.descriptive.summary.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.axiell.service.audit.solr.doc.AuditLog;

/**
 * @author ashraf
 *
 */
public interface AuditLogRepository extends SolrCrudRepository<AuditLog, String> {

	public List<AuditLog> findByUserId(String userId);

	@Query("searchTerm:*?0*")
	public Page<Product> findByCustomQuery(String searchTerm, Pageable pageable);

	@Query(name = "auditLog.findByNamedQuery")
	public Page<Product> findByNamedQuery(String searchTerm, Pageable pageable);

}
