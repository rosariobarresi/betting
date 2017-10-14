package com.betting.scraping.connection;

public enum HTTPMethod {

	GET("GET"), POST("POST"), HEAD("HEAD"), PUT("PUT"), DELETE("DELETE"), CONNECT("CONNECT"), OPTIONS("OPTIONS");

	private String value;

	HTTPMethod(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
