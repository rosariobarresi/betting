package com.betting.scraping.connection.factory;

import com.betting.scraping.connection.HTTPMethod;
import com.betting.scraping.connection.ScrapingConnection;
import com.betting.scraping.connection.bean.request.EmptyRequest;
import com.betting.scraping.connection.bean.response.PartiteLega;
import com.betting.scraping.connection.outputconverter.HttpOutputConverterPartiteLega;

public class FactoryConnection {

	public static ScrapingConnection<PartiteLega, EmptyRequest> getListaPartiteLega(String urlToInvoke, HTTPMethod httpMethod,
			HttpOutputConverterPartiteLega httpOutputConverterPartita) {
		ScrapingConnection<PartiteLega, EmptyRequest> scrapingConnection = new ScrapingConnection<PartiteLega, EmptyRequest>();
		scrapingConnection.setUrl(urlToInvoke);
		scrapingConnection.setHttpMethod(httpMethod);
		scrapingConnection.setOutputConverter(httpOutputConverterPartita);
		return scrapingConnection;
	}

}
