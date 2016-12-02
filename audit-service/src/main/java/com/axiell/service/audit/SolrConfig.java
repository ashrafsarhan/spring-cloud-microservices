/**
 * 
 */
package com.axiell.service.audit;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/**
 * @author ashraf
 *
 */
@Configuration
@EnableSolrRepositories(
  basePackages = "com.axiell.service.audit.solr.repo",
  namedQueriesLocation = "classpath:solr-named-queries.properties",
  multicoreSupport = true)
@ComponentScan
public class SolrConfig {
	
	@Value("${solr.url}")
	private String solrUrl;
 
    @Bean
    public SolrClient solrClient() {
        return new HttpSolrClient(solrUrl);
    }
 
    @Bean
    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
        return new SolrTemplate(client);
    }
}
