package com.betting.scraping.connection.interfaces;

public interface HttpGenericOutputConverter<T> {
	
	T convertObject(String outputData);

}
