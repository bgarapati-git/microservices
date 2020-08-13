package com.learning.microservices.limitsservice.bean;

public class LimitConfiguration {
	
	private int minLimit;
	private int maxLimit;
	
	protected LimitConfiguration() {
		
	}
	
	public LimitConfiguration(int minLimit, int maxLimit) {
		super();
		this.minLimit = minLimit;
		this.maxLimit = maxLimit;
	}

	public int getMinLimit() {
		return minLimit;
	}

	public void setMinLimit(int minLimit) {
		this.minLimit = minLimit;
	}

	public int getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}
	
	

}
