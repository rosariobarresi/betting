package com.betting.scraping.connection.abstractwriter;

import com.betting.scraping.CodaElaborazione;
import com.betting.scraping.bean.MarkerBean;
import com.betting.scraping.connection.interfaces.ScrapingWriterInterface;

public abstract class WriterAbstract<T extends MarkerBean> implements ScrapingWriterInterface<T> {

	protected CodaElaborazione<T> codaElaborazione;
	protected String file;

	@Override
	public void setCodaElaborazione(CodaElaborazione<T> codaElaborazione) {
		this.codaElaborazione = codaElaborazione;
	}

	@Override
	public void setResult(String file) {
		this.file = file;
	}
}