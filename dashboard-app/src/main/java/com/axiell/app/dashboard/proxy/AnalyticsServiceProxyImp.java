package com.axiell.app.dashboard.proxy;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.axiell.app.dashboard.dto.HotTopic;

/**
 * @author ashraf
 *
 */
@Service
public class AnalyticsServiceProxyImp implements AnalyticsServiceProxyApi {
	
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
    private DiscoveryClient discoveryClient;
	
	@Value("${analytics.service.name}")
	private String analyticsServiceName;

	@Value("${analytics.service.hot.topics}")
	private String analyticsServiceHotTopics;

	@Override
	public HotTopic[] getHotSearchedTopics() {
		HotTopic[] hotTopics = null;
		List<ServiceInstance> instances = discoveryClient.getInstances(analyticsServiceName);
        if(instances != null && !instances.isEmpty()) {
            ServiceInstance serviceInstance = instances.get(0);
            String serviceUrl = serviceInstance.getUri()+analyticsServiceHotTopics;
            hotTopics = restTemplate.getForObject(serviceUrl, HotTopic[].class);
        }else {
        	logger.error("Fetal error: No available instances for analytics service!");
        }
        return hotTopics;
	}

}
