package betting.scraping.connection.interfaces;

import betting.scraping.CodaElaborazione;
import betting.scraping.bean.MarkerBean;

public interface ScrapingWriterInterface<T extends MarkerBean> extends Runnable {

	void setCodaElaborazione(CodaElaborazione<T> codaElaborazione);

	void setResult(String result);
}
