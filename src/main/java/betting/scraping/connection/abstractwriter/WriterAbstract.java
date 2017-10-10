package betting.scraping.connection.abstractwriter;

import betting.scraping.CodaElaborazione;
import betting.scraping.bean.MarkerBean;
import betting.scraping.connection.interfaces.ScrapingWriterInterface;

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