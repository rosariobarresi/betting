package betting.scraping.reader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import betting.scraping.CodaElaborazione;
import betting.scraping.connection.HTTPMethod;
import betting.scraping.connection.ScrapingConnection;
import betting.scraping.connection.bean.request.EmptyRequest;
import betting.scraping.connection.bean.response.Partita;
import betting.scraping.connection.bean.response.PartiteLega;
import betting.scraping.connection.factory.FactoryConnection;
import betting.scraping.connection.interfaces.ScrapingReaderInterface;
import betting.scraping.connection.outputconverter.HttpOutputConverterPartiteLega;

public class EurobetReader implements ScrapingReaderInterface<PartiteLega> {

	private CodaElaborazione<PartiteLega> codaElaborazione;
	private String urlToInvoke = "http://web.eurobet.it/webeb/sport?action=scommesseV2_meeting_comm&meetingsParam=22&chooseSport=1&showSplash=0&ts=1507584012702";

	@Override
	public void run() {
		ScrapingConnection<PartiteLega, EmptyRequest> scraping = null;
		HttpOutputConverterPartiteLega httpOutputConverterPartita = new HttpOutputConverterPartiteLega();
		scraping = FactoryConnection.getIstanceQuadro1(urlToInvoke, HTTPMethod.GET, httpOutputConverterPartita);
		EmptyRequest input = new EmptyRequest();
		try {
			scraping.invokeService(input);
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
