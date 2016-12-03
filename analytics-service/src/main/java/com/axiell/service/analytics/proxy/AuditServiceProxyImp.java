package com.axiell.service.analytics.proxy;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.axiell.service.analytics.dto.HotTopic;

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

	@Value("${audit.service.path}")
	private String auditServicePath;

	@Override
	public HotTopic[] getHotSearchedTopics() {
		HotTopic[] hotTopics = null;
		List<ServiceInstance> instances = discoveryClient.getInstances(auditServiceName);
        if(instances != null && !instances.isEmpty()) {
            ServiceInstance serviceInstance = instances.get(0);
            String serviceUrl = serviceInstance.getUri()+auditServicePath;
            hotTopics = restTemplate.getForObject(serviceUrl, HotTopic[].class);
        }else {
        	logger.error("Fetal error: No available instances for audit service!");
        }
        return hotTopics;
	}

}
