package com.axiell.service.audit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axiell.service.audit.solr.repo.AuditLogRepository;

/**
 * @author ashraf
 *
 */
@RestController
@RequestMapping("/audit")
public class AuditController {

	@Autowired
	private AuditLogRepository auditLogRepository;

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserLogs(@PathVariable String userId) {
		return new ResponseEntity<>(auditLogRepository.findByUserId(userId), HttpStatus.OK);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<?> searchLogs(@RequestParam(value = "term") String term,
			@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size) {
		return new ResponseEntity<>(auditLogRepository.findByCustomQuery(term, new PageRequest(page, size)),
				HttpStatus.OK);
	}

}
