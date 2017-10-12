package com.betting.scraping.connection.interfaces;

import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

public class ScrapingGenericOutputResponse {

	public ScrapingGenericOutputResponse() {
		// TODO Auto-generated constructor stub
	}

	@XmlTransient
	private Map<String, String> cookieMap;

	@XmlTransient
	public Map<String, String> getCookieMap() {
		return cookieMap;
	}

	public void setCookieMap(Map<String, String> cookieMap) {
		this.cookieMap = cookieMap;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScrapingGenericOutputResponse [cookieMap=");
		builder.append(cookieMap);
		builder.append("]");
		return builder.toString();
	}

}
