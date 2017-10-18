package com.vivekaditya.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/*
 *
 */
@ConfigurationProperties(prefix = "user.service", ignoreUnknownFields = false)
@Component
public class ServiceProperties {

    @NotNull
	private String name = "Empty";

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
