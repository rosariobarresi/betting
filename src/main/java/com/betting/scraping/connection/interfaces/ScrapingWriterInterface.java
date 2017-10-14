package com.betting.scraping.connection.interfaces;

import com.betting.scraping.CodaElaborazione;
import com.betting.scraping.bean.MarkerBean;

public interface ScrapingWriterInterface<T extends MarkerBean> extends Runnable {


	void setResult(String result);
}
