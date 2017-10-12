package com.betting.scraping.connection.bean.request;

import com.betting.scraping.connection.HttpParameterKey;
import com.betting.scraping.connection.interfaces.ScrapingGenericInput;

public class EmptyRequest extends ScrapingGenericInput {

	@HttpParameterKey("action")
	private String action;
	@HttpParameterKey("meetingsParam")
	private String meetingsParam;
	@HttpParameterKey("chooseSport")
	private String chooseSport;
	@HttpParameterKey("showSplash")
	private String showSplash;
	@HttpParameterKey("ts")
	private String ts;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMeetingsParam() {
		return meetingsParam;
	}

	public void setMeetingsParam(String meetingsParam) {
		this.meetingsParam = meetingsParam;
	}

	public String getChooseSport() {
		return chooseSport;
	}

	public void setChooseSport(String chooseSport) {
		this.chooseSport = chooseSport;
	}

	public String getShowSplash() {
		return showSplash;
	}

	public void setShowSplash(String showSplash) {
		this.showSplash = showSplash;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmptyRequest [action=");
		builder.append(action);
		builder.append(", meetingsParam=");
		builder.append(meetingsParam);
		builder.append(", chooseSport=");
		builder.append(chooseSport);
		builder.append(", showSplash=");
		builder.append(showSplash);
		builder.append(", ts=");
		builder.append(ts);
		builder.append("]");
		return builder.toString();
	}

}
