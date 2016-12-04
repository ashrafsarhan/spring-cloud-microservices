package com.axiell.service.audit.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axiell.service.audit.dto.Topic;
import com.axiell.service.audit.solr.doc.AuditLog;
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

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserLogs(@PathVariable String userId) {
		return new ResponseEntity<>(auditLogRepository.findByUserId(userId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public ResponseEntity<?> saveLog(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "searchTerm") String searchTerm) {
		AuditLog auditLog = new AuditLog(new String(userId+System.currentTimeMillis()), userId, searchTerm);
		return new ResponseEntity<>(auditLogRepository.save(auditLog), HttpStatus.OK);
	}

	@RequestMapping(value = "/topic/search", method = RequestMethod.GET)
	public ResponseEntity<?> searchLogs(@RequestParam(value = "term") String term,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		return new ResponseEntity<>(
				auditLogRepository.findByCustomQuery(term, new PageRequest(page, size)).getContent(), HttpStatus.OK);
	}

	@RequestMapping(value = "/topic/top", method = RequestMethod.GET)
	public ResponseEntity<?> getTopSearchedTopics(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		List<Topic> topics = new ArrayList<>();
		auditLogRepository.findTopSearchedTopics(new PageRequest(page, size)).getFacetResultPages().forEach(p -> {
			p.forEach(t -> {
				topics.add(new Topic(t.getValue(), t.getValueCount()));
			});
		});
		return new ResponseEntity<>(topics, HttpStatus.OK);
	}

}
