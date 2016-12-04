package com.axiell.app.search.proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.axiell.app.search.dto.AuditLog;

/**
 * @author ashraf
 *
 */
@Service
public class AuditServiceProxyImp implements AuditServiceProxyApi {
	
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
    private DiscoveryClient discoveryClient;
	
	@Value("${audit.service.name}")
	private String auditServiceName;

	@Value("${audit.service.save.log}")
	private String auditServiceSaveLog;

	@Override
	public AuditLog saveUserSearchLog(String userId, String searchTerm) {
		AuditLog auditLog = null;
		List<ServiceInstance> instances = discoveryClient.getInstances(auditServiceName);
        if(instances != null && !instances.isEmpty()) {
        	Map<String, String> variables = new HashMap<String, String>(3);
            variables.put("userId", userId);
            variables.put("searchTerm", searchTerm);
            ServiceInstance serviceInstance = instances.get(0);
            String serviceUrl = serviceInstance.getUri()+auditServiceSaveLog+"?userId={userId}&searchTerm={searchTerm}";
            auditLog = restTemplate.getForObject(serviceUrl, AuditLog.class, variables);
        }else {
        	logger.error("Fetal error: No available instances for audit service!");
        }
        return auditLog;
	}

}
