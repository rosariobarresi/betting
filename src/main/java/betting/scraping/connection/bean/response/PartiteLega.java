package betting.scraping.connection.bean.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import betting.scraping.bean.MarkerBean;
import betting.scraping.connection.interfaces.ScrapingGenericOutputResponse;

@XmlRootElement(name = "PartiteLega")
@XmlType(propOrder = { "listaPartite" })
public class PartiteLega extends ScrapingGenericOutputResponse implements MarkerBean {
	private List<Partita> listaPartite;

	public void addPartita(Partita partita) {
		if (listaPartite == null) {
			listaPartite = new ArrayList<>();
		}
		listaPartite.add(partita);
	}

	public List<Partita> getListaPartite() {
		return listaPartite;
	}

	public void setListaPartite(List<Partita> listaPartite) {
		this.listaPartite = listaPartite;
	}
}
