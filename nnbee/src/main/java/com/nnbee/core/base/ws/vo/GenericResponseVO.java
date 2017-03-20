package com.nnbee.core.base.ws.vo;

import com.nnbee.core.vo.json.BaseRestResponseVO;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({ "status", "code", "build", "serverName", "duration",
"result" })
public class GenericResponseVO  extends BaseRestResponseVO{

	private Object payload;
	
	public GenericResponseVO(){
		
	}

	public GenericResponseVO(Object payload) {
		super();
		this.payload = payload;
	}

	@JsonProperty("result")
	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	
	
}
