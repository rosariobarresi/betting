package betting.scraping.connection.factory;

import betting.scraping.connection.HTTPMethod;
import betting.scraping.connection.ScrapingConnection;
import betting.scraping.connection.bean.request.EmptyRequest;
import betting.scraping.connection.bean.response.PartiteLega;
import betting.scraping.connection.outputconverter.HttpOutputConverterPartiteLega;

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
