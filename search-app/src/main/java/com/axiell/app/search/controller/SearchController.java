/**
 * 
 */
package com.axiell.app.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axiell.app.search.proxy.AuditServiceProxyApi;

/**
 * @author ashraf
 *
 */
@RestController
@RequestMapping("/")
public class SearchController {
	
	@Autowired
	private AuditServiceProxyApi AuditServiceProxyApi;
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<?> saveLog(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "searchTerm") String searchTerm) {
		return new ResponseEntity<>(AuditServiceProxyApi.saveUserSearchLog(userId, searchTerm), HttpStatus.OK);
	}

}
