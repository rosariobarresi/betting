package com.betting.scraping.reader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.betting.scraping.CodaElaborazione;
import com.betting.scraping.connection.HTTPMethod;
import com.betting.scraping.connection.ScrapingConnection;
import com.betting.scraping.connection.bean.request.EmptyRequest;
import com.betting.scraping.connection.bean.response.Partita;
import com.betting.scraping.connection.bean.response.PartiteLega;
import com.betting.scraping.connection.factory.FactoryConnection;
import com.betting.scraping.connection.interfaces.ScrapingReaderInterface;
import com.betting.scraping.connection.outputconverter.HttpOutputConverterPartiteLega;

public class EurobetReader implements ScrapingReaderInterface<PartiteLega> {

	// ?action=scommesseV2_meeting_comm&meetingsParam=22&chooseSport=1&showSplash=0&ts=1507584012702
	private CodaElaborazione<PartiteLega> codaElaborazione;
	private String urlToInvoke = "http://web.eurobet.it/webeb/sport";

	@Override
	public void run() {
		ScrapingConnection<PartiteLega, EmptyRequest> scraping = null;
		HttpOutputConverterPartiteLega httpOutputConverterPartita = new HttpOutputConverterPartiteLega();
		scraping = FactoryConnection.getListaPartiteLega(urlToInvoke, HTTPMethod.GET, httpOutputConverterPartita);
		EmptyRequest input = new EmptyRequest();
		input.setAction("scommesseV2_meeting_comm");
		input.setMeetingsParam("22");
		input.setChooseSport("1");
		input.setShowSplash("0");
		input.setTs("" + System.currentTimeMillis());
		try {
			PartiteLega invokeService = scraping.invokeService(input);
			codaElaborazione.enqueue(invokeService);
		} catch (IllegalAccessException | InvocationTargetException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setCodaElaborazione(CodaElaborazione<PartiteLega> codaElaborazione) {
		this.codaElaborazione = codaElaborazione;
	}

	public static void main(String[] args) {
		EurobetReader eurobetReader = new EurobetReader();
		Thread t = new Thread(eurobetReader);
		t.start();
	}

}
