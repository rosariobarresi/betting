package betting.scraping.writer;

import java.io.IOException;

import javax.swing.text.AbstractWriter;
import javax.swing.text.BadLocationException;

import betting.scraping.connection.abstractwriter.WriterAbstract;
import betting.scraping.connection.bean.response.PartiteLega;

public class WriterMongo extends WriterAbstract<PartiteLega> {

	@Override
	public void run() {
		init();
		while (!codaElaborazione.isFinishReader() || !codaElaborazione.isEmpty()) {
			PartiteLega element = codaElaborazione.dequeue();
		}
	}

	public void init() {
		// inizializza mongo
	}
}