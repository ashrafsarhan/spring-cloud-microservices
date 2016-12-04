/**
 * 
 */
package com.axiell.app.dashboard.proxy;

import com.axiell.app.dashboard.dto.HotTopic;

/**
 * @author ashraf
 *
 */
public interface AnalyticsServiceProxyApi {
	
	public HotTopic[] getHotSearchedTopics();

}
