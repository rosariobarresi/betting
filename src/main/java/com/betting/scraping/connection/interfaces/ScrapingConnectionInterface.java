package com.betting.scraping.connection.interfaces;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.util.Map;

import com.betting.scraping.connection.HTTPMethod;

public interface ScrapingConnectionInterface<T, Z extends ScrapingGenericInput> {

	void setHttpMethod(HTTPMethod httpMethod);

	T invokeService(Z input) throws IOException, IllegalAccessException, InvocationTargetException;

	void setCookie(HttpURLConnection oHttpURLConnection, Z input);

	Map<String, String> parserCookies(HttpURLConnection oHttpURLConnection);

}
