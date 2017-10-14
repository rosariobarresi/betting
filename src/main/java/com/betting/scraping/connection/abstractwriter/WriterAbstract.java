package com.betting.scraping.connection.abstractwriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.betting.scraping.CodaElaborazione;
import com.betting.scraping.bean.MarkerBean;
import com.betting.scraping.connection.interfaces.ScrapingWriterInterface;

public abstract class WriterAbstract<T extends MarkerBean> implements ScrapingWriterInterface<T> {

	@Autowired
	protected CodaElaborazione<T> codaElaborazione;
	protected String file;


	@Override
	public void setResult(String file) {
		this.file = file;
	}
}