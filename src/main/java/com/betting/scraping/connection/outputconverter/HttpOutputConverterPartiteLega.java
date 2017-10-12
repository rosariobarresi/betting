package com.betting.scraping.connection.outputconverter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.betting.scraping.connection.bean.response.Partita;
import com.betting.scraping.connection.bean.response.PartiteLega;
import com.betting.scraping.connection.interfaces.HttpGenericOutputConverter;

public class HttpOutputConverterPartiteLega implements HttpGenericOutputConverter<PartiteLega> {

	@Override
	public PartiteLega convertObject(String outputData) {
		PartiteLega partiteLega = new PartiteLega();
		Document doc = Jsoup.parse(outputData);
		Elements matches = doc.select("div.box_container_scommesse_evento.PBEvent");
		Partita partita;
		for(Element match : matches){
			partita = new Partita();
			partita.setPartita(match.select("div.box_container_scommesse_nomeEvento").text());
			partita.setQuotaVittoriaCasa((match.select("div.box_container_scommesse_quoteType").get(0)).text());
			partita.setQuotaPareggio((match.select("div.box_container_scommesse_quoteType").get(1)).text());
			partita.setQuotaVittoriaFuoriCasa((match.select("div.box_container_scommesse_quoteType").get(2)).text());
			partita.setQuotaUnder((match.select("div.box_container_scommesse_quoteType").get(3)).text());
			partita.setQuoteOver((match.select("div.box_container_scommesse_quoteType").get(4)).text());
			partita.setQuotaGoal((match.select("div.box_container_scommesse_quoteType").get(5)).text());
			partita.setQuotaNoGoal((match.select("div.box_container_scommesse_quoteType").get(6)).text());
			partiteLega.addPartita(partita);
		}

		return partiteLega;
	}

}
