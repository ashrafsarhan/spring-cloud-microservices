package com.axiell.service.audit.solr.repo;

import java.util.List;

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
	public Page<AuditLog> findByCustomQuery(String searchTerm, Pageable pageable);

	@Query(name = "auditLog.findByNamedQuery")
	public Page<AuditLog> findByNamedQuery(String searchTerm, Pageable pageable);

}
