package com.nnbee.core.vo.json;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonWriteNullProperties;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

@SuppressWarnings("deprecation")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonWriteNullProperties(false)

public class StatusVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("code")
	@XmlElement(name="code")
	private String code;
	@JsonProperty("message")
	@XmlElement(name="message")
	private String message;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}


	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


}