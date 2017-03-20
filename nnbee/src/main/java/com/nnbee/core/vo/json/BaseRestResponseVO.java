package com.nnbee.core.vo.json;

/**
 *=====================================================================
 * ACP Restful Web Service Based Response Value Object 
 *
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlElement;


@JsonPropertyOrder({"status"})
public abstract class BaseRestResponseVO {	

	protected StatusVO responseStatus;

	@JsonProperty("status")
	@XmlElement(name="status")
	public StatusVO getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(StatusVO responseStatus) {
		this.responseStatus = responseStatus;
	}

}