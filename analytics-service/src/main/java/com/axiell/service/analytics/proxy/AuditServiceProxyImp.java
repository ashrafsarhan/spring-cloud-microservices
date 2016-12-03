package com.axiell.service.analytics.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.axiell.service.analytics.dto.HotTopic;

/**
 * @author ashraf
 *
 */
@Service
public class AuditServiceProxyImp implements AuditServiceProxyApi {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${audit.service.url}")
	private String auditServiceUrl;

	@Override
	public HotTopic[] getHotSearchedTopics() {
		HotTopic[] hotTopics = restTemplate.getForObject(auditServiceUrl, HotTopic[].class);
		return hotTopics;
	}

}
