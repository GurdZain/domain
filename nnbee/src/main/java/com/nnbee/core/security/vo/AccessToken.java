package com.nnbee.core.security.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户登录后的相关信息
 *
 */
public class AccessToken implements Serializable {

	private static final long serialVersionUID = 1L;

	private String accessToken;
	
	//private Long enterpriseUserId;
	
	private Long enterpriseId;
	
	private String enterpriseName;
	
	private String username;
	
	private Integer userType;
	
	private String clientIP;
	
	private String sessionId;
	
	private Date createdDate;
	
	private Date expiredDate;
	
	private String source;
	
	public AccessToken() {

	}
	
	public boolean isExpired(){
		if(expiredDate==null){
			return false;
		}else{
			return (expiredDate.getTime()-new Date().getTime())>0;
		}
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public Integer getUserType() {
		return userType;
	}


	public void setUserType(Integer userType) {
		this.userType = userType;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getClientIP() {
		return clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AccessToken [accessToken=" + accessToken
				+ ", enterpriseId="
				+ enterpriseId + ", enterpriseName=" + enterpriseName
				+ ", username=" + username + ", userType=" + userType
				+ ", clientIP=" + clientIP + ", sessionId=" + sessionId
				+ ", createdDate=" + createdDate + ", expiredDate="
				+ expiredDate + "]";
	}

}
