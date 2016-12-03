/**
 * 
 */
package com.axiell.service.analytics.proxy;

import com.axiell.service.analytics.dto.HotTopic;

/**
 * @author ashraf
 *
 */
public interface AuditServiceProxyApi {
	
	public HotTopic[] getHotSearchedTopics();

}
