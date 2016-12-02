package com.axiell.service.audit.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.axiell.service.audit.solr.doc.AuditLog;
import com.axiell.service.audit.solr.repo.AuditLogRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditServiceApplicationTests {
	
	@Autowired
	private AuditLogRepository auditLogRepository;

	@Test
	public void testAuditLogRepository() {
		AuditLog auditLog = new AuditLog();
		auditLog.setId("1");
		auditLog.setUserId("12345");
		auditLog.setSearchTerm("computer science");
		AuditLog saved = auditLogRepository.save(auditLog);
		Assert.assertNotNull("Error in AuditLogRepository Save", saved);
		auditLogRepository.delete(saved);
	}

}
