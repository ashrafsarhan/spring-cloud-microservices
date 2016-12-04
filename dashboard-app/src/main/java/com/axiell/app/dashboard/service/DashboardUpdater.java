/**
 * 
 */
package com.axiell.app.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.axiell.app.dashboard.proxy.AnalyticsServiceProxyApi;

/**
 * @author ashraf
 *
 */
@Service
public class DashboardUpdater {
	
	private final static String DATA_TOPIC = "/topic/messages";
	private final static String DATA_UPDATE_SCHEDULE = "*/1 * * * * *";
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@Autowired
	private AnalyticsServiceProxyApi AuditServiceProxyApi;
	
	@Scheduled(cron = DATA_UPDATE_SCHEDULE)
	public void update() {
		if (true) {
			template.convertAndSend(DATA_TOPIC, AuditServiceProxyApi.getHotSearchedTopics());
		}
	}

}
