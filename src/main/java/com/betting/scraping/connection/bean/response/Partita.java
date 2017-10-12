package com.betting.scraping.connection.bean.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.betting.scraping.bean.MarkerBean;
import com.betting.scraping.connection.interfaces.ScrapingGenericOutputResponse;

@XmlRootElement(name = "Partita")
@XmlType(propOrder = { "partita", "quotaVittoriaCasa", "quotaPareggio", "quotaVittoriaFuoriCasa", "quotaUnder",
		"quoteOver", "quotaGoal", "quotaNoGoal" })
public class Partita {
	private String partita;
	private Double quotaVittoriaCasa;
	private Double quotaPareggio;
	private Double quotaVittoriaFuoriCasa;
	private Double quotaUnder;
	private Double quoteOver;
	private Double quotaGoal;
	private Double quotaNoGoal;

	public String getPartita() {
		return partita;
	}

	public void setPartita(String partita) {
		this.partita = partita;
	}

	public Double getQuotaVittoriaCasa() {
		return quotaVittoriaCasa;
	}

	public void setQuotaVittoriaCasa(Double quotaVittoriaCasa) {
		this.quotaVittoriaCasa = quotaVittoriaCasa;
	}

	public void setQuotaVittoriaCasa(String quotaVittoriaCasa) {
		Double quota = new Double(quotaVittoriaCasa);
		this.quotaVittoriaCasa = quota;
	}

	public Double getQuotaPareggio() {
		return quotaPareggio;
	}

	public void setQuotaPareggio(Double quotaPareggio) {
		this.quotaPareggio = quotaPareggio;
	}

	public void setQuotaPareggio(String quotaPareggio) {
		Double quota = new Double(quotaPareggio);
		this.quotaPareggio = quota;
	}

	public Double getQuotaVittoriaFuoriCasa() {
		return quotaVittoriaFuoriCasa;
	}

	public void setQuotaVittoriaFuoriCasa(Double quotaVittoriaFuoriCasa) {
		this.quotaVittoriaFuoriCasa = quotaVittoriaFuoriCasa;
	}

	public void setQuotaVittoriaFuoriCasa(String quotaVittoriaFuoriCasa) {
		Double quota = new Double(quotaVittoriaFuoriCasa);
		this.quotaVittoriaFuoriCasa = quota;
	}

	public Double getQuotaUnder() {
		return quotaUnder;
	}

	public void setQuotaUnder(Double quotaUnder) {
		this.quotaUnder = quotaUnder;
	}

	public void setQuotaUnder(String quotaUnder) {
		Double quota = new Double(quotaUnder);
		this.quotaUnder = quota;
	}

	public Double getQuoteOver() {
		return quoteOver;
	}

	public void setQuoteOver(Double quoteOver) {
		this.quoteOver = quoteOver;
	}

	public void setQuoteOver(String quoteOver) {
		Double quota = new Double(quoteOver);
		this.quoteOver = quota;
	}

	public Double getQuotaGoal() {
		return quotaGoal;
	}

	public void setQuotaGoal(Double quotaGoal) {
		this.quotaGoal = quotaGoal;
	}

	public void setQuotaGoal(String quotaGoal) {
		Double quota = new Double(quotaGoal);
		this.quotaGoal = quota;
	}

	public Double getQuotaNoGoal() {
		return quotaNoGoal;
	}

	public void setQuotaNoGoal(Double quotaNoGoal) {
		this.quotaNoGoal = quotaNoGoal;
	}

	public void setQuotaNoGoal(String quotaNoGoal) {
		Double quota = new Double(quotaNoGoal);
		this.quotaNoGoal = quota;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Partita [partita=");
		builder.append(partita);
		builder.append(", quotaVittoriaCasa=");
		builder.append(quotaVittoriaCasa);
		builder.append(", quotaPareggio=");
		builder.append(quotaPareggio);
		builder.append(", quotaVittoriaFuoriCasa=");
		builder.append(quotaVittoriaFuoriCasa);
		builder.append(", quotaUnder=");
		builder.append(quotaUnder);
		builder.append(", quoteOver=");
		builder.append(quoteOver);
		builder.append(", quotaGoal=");
		builder.append(quotaGoal);
		builder.append(", quotaNoGoal=");
		builder.append(quotaNoGoal);
		builder.append("]");
		return builder.toString();
	}

}
