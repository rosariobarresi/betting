package com.betting.scraping.connection.interfaces;

import com.betting.scraping.CodaElaborazione;
import com.betting.scraping.bean.MarkerBean;

public interface ScrapingReaderInterface<T extends MarkerBean> extends Runnable {


	void setCodaElaborazione(CodaElaborazione<T> codaElaborazione);

}
