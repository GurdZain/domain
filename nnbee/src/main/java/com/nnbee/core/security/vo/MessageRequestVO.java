package com.nnbee.core.security.vo;

public class MessageRequestVO {
	private Long enterprise_id;
	private Long enterprise_group_id;
	private String phone_numbers;
	private String content;
	private Byte message_type;

	public Long getEnterprise_id() {
		return enterprise_id;
	}

	public void setEnterprise_id(Long enterprise_id) {
		this.enterprise_id = enterprise_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Byte getMessage_type() {
		return message_type;
	}

	public void setMessage_type(Byte message_type) {
		this.message_type = message_type;
	}

	public String getPhone_numbers() {
		return phone_numbers;
	}

	public void setPhone_numbers(String phone_numbers) {
		this.phone_numbers = phone_numbers;
	}

	public Long getEnterprise_group_id() {
		return enterprise_group_id;
	}

	public void setEnterprise_group_id(Long enterprise_group_id) {
		this.enterprise_group_id = enterprise_group_id;
	}

}
