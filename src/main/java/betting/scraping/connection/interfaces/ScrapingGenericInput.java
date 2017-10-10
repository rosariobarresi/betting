package betting.scraping.connection.interfaces;

import java.util.Map;

public class ScrapingGenericInput {

	private Map<String, String> cookieMap;

	public Map<String, String> getCookieMap() {
		return cookieMap;
	}

	public void setCookieMap(Map<String, String> cookieMap) {
		this.cookieMap = cookieMap;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScrapingGenericInput [cookieMap=");
		builder.append(cookieMap);
		builder.append("]");
		return builder.toString();
	}

}
