package com.axiell.service.analytics.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.axiell.service.analytics.proxy.AuditServiceProxyApi;

/**
 * @author ashraf
 *
 */
@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

	@Autowired
	private AuditServiceProxyApi auditServiceProxyApi;

	@RequestMapping(value = "/topic/hot", method = RequestMethod.GET)
	public ResponseEntity<?> getHotSearchedTopics() {
		return new ResponseEntity<>(auditServiceProxyApi.getHotSearchedTopics(), HttpStatus.OK);
	}

}
