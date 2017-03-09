package com.ichunming.bms.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiConfiguration {
	@Value("#{configProperties['domain.url']}")
	private String domainUrl;

	@Value("#{configProperties['admin.name']}")
	private String adminName;
	
	@Value("#{configProperties['admin.password']}")
	private String adminPassword;
	
	public String getDomainUrl() {
		return domainUrl;
	}

	public void setDomainUrl(String domainUrl) {
		this.domainUrl = domainUrl;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}
