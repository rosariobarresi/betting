package betting.scraping.connection.outputconverter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import betting.scraping.connection.bean.response.PartiteLega;
import betting.scraping.connection.interfaces.HttpGenericOutputConverter;

public class HttpOutputConverterPartiteLega implements HttpGenericOutputConverter<PartiteLega> {

	@Override
	public PartiteLega convertObject(String outputData) {
		PartiteLega partiteLega = new PartiteLega();
		Document doc = Jsoup.parse(outputData);
		Elements elementsByTag = doc.getElementsByClass("box_container_scommesse_evento PBEvent");
		for (int i = 0; i < elementsByTag.size(); i++) {
			Element partita = elementsByTag.get(i);
			System.out.println(partita);
		}
		return partiteLega;
	}

}
