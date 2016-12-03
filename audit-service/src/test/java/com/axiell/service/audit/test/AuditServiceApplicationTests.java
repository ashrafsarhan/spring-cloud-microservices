package com.axiell.service.audit.test;

import org.junit.After;
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
	
	private static final String [] TOPICS = {"Linear Regression", "Classification", "Logistic Regression", "Bayes Theorem", "Cross Validation"};
	
	@Autowired
	private AuditLogRepository auditLogRepository;

	@Test
	public void testAuditLogRepository() {
		for (int i = 0; i < TOPICS.length; i++) {
			AuditLog auditLog = new AuditLog();
			auditLog.setId(new Long(i+1).toString());
			auditLog.setUserId("12345");
			auditLog.setSearchTerm(TOPICS[i]);
			AuditLog saved = auditLogRepository.save(auditLog);
			Assert.assertNotNull("Error in AuditLogRepository Save", saved);	
		}
	}
	
	@After
	public void tearDown() {
		auditLogRepository.deleteAll();
	}

}
