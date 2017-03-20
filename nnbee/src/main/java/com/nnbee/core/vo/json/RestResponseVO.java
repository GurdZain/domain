package com.nnbee.core.vo.json;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;


public class RestResponseVO extends BaseRestResponseVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@JsonProperty("result")
	private Object result;
	

	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	

	

}
