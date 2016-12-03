package com.axiell.service.audit.dto;

/**
 * @author ashraf
 *
 */
public class Topic {

	private String value;
	private Long valueCount;

	public Topic(String value, Long valueCount) {
		super();
		this.value = value;
		this.valueCount = valueCount;
	}

	public String getValue() {
		return value;
	}

	public Long getValueCount() {
		return valueCount;
	}

}
