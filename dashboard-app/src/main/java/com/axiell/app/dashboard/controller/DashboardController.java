package com.axiell.app.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.axiell.app.dashboard.proxy.AnalyticsServiceProxyApi;

/**
 * @author ashraf
 *
 */
@RestController
@RequestMapping("/")
public class DashboardController {
	
	@Autowired
	private AnalyticsServiceProxyApi AuditServiceProxyApi;
	
	@RequestMapping(value = "/htopics", method = RequestMethod.GET)
	public ResponseEntity<?> getHotTopics() {
		return new ResponseEntity<>(AuditServiceProxyApi.getHotSearchedTopics(), HttpStatus.OK);
	}

}
