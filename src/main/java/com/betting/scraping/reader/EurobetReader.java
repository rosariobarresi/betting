package com.betting.scraping.reader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;

import com.betting.scraping.CodaElaborazione;
import com.betting.scraping.connection.HTTPMethod;
import com.betting.scraping.connection.ScrapingConnection;
import com.betting.scraping.connection.bean.request.EmptyRequest;
import com.betting.scraping.connection.bean.response.PartiteLega;
import com.betting.scraping.connection.factory.FactoryConnection;
import com.betting.scraping.connection.interfaces.ScrapingReaderInterface;
import com.betting.scraping.connection.outputconverter.HttpOutputConverterPartiteLega;
import com.betting.scraping.writer.WriterMongo;

public class EurobetReader implements ScrapingReaderInterface<PartiteLega> {

	//
	@Autowired
	private CodaElaborazione<PartiteLega> codaElaborazione;
	private String urlToInvoke = "http://web.eurobet.it/webeb/sport?action=scommesseV2_meeting_comm&meetingsParam=22&chooseSport=1&showSplash=0&ts=<ts>";

	@Override
	public void run() {
		while (true) {
			ScrapingConnection<PartiteLega, EmptyRequest> scraping = null;
			HttpOutputConverterPartiteLega httpOutputConverterPartita = new HttpOutputConverterPartiteLega();
			scraping = FactoryConnection.getListaPartiteLega(
					urlToInvoke.replace("<ts>", "" + System.currentTimeMillis()), HTTPMethod.GET,
					httpOutputConverterPartita);
			EmptyRequest input = new EmptyRequest();
			try {
				PartiteLega invokeService = scraping.invokeService(input);
				codaElaborazione.enqueue(invokeService);
				codaElaborazione.setFinishReader(true);
			} catch (IllegalAccessException | InvocationTargetException | IOException e) {
				e.printStackTrace();
			} finally {
				try {
					Thread.sleep(60 * 15 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
