/**
 * 
 */
package com.axiell.app.search.proxy;

import com.axiell.app.search.dto.AuditLog;

/**
 * @author ashraf
 *
 */
public interface AuditServiceProxyApi {
	
	public AuditLog saveUserSearchLog(String userId, String searchTerm);

}
