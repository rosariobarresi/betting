package betting.scraping.connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import betting.scraping.connection.interfaces.HttpGenericOutputConverter;
import betting.scraping.connection.interfaces.ScrapingConnectionInterface;
import betting.scraping.connection.interfaces.ScrapingGenericInput;
import betting.scraping.connection.interfaces.ScrapingGenericOutputResponse;
import betting.scraping.exception.BadResponseException;

public class ScrapingConnection<T extends ScrapingGenericOutputResponse, Z extends ScrapingGenericInput> implements ScrapingConnectionInterface<T, Z> {

	private String proxyType;
	private Integer proxyPort;
	private HTTPMethod httpMethod;
	private String url;
	private HttpGenericOutputConverter<T> outputConverter;

	@Override
	public T invokeService(Z input) throws IOException, IllegalAccessException, InvocationTargetException {
		HttpURLConnection oHttpURLConnection = openConnection(input);
		// setHeaderConnectionDetails(oHttpURLConnection);
		setCookie(oHttpURLConnection, input);
		String data = buildData(input);
		int responseCode;
		if (HTTPMethod.POST.getValue().equalsIgnoreCase(this.httpMethod.getValue())) {
			setPostData(data, oHttpURLConnection);
		} else if (HTTPMethod.GET.getValue().equalsIgnoreCase(this.httpMethod.getValue())) {
			// Do nothing
		} else {
			throw new UnsupportedOperationException("Method not implemented yet " + this.httpMethod);
		}
		responseCode = oHttpURLConnection.getResponseCode();
		if (!(responseCode == HttpsURLConnection.HTTP_OK)) {
			throw new BadResponseException("KO Connessione url:" + url + "\npostData:" + data + "\ncookie" + input.getCookieMap());
		}
		String response = "";
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(oHttpURLConnection.getInputStream(), "iso-8859-1"));
		while ((line = br.readLine()) != null) {
			response += line;
		}
		T result = outputConverter.convertObject(response);
		if (result != null) {
			result.setCookieMap(parserCookies(oHttpURLConnection));
		}
		return result;
	}

	private HttpURLConnection openConnection(Z input) throws IOException {
		URL urlToRequest = new URL(this.url);
//		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.cervedgroup.com", 8080));
//		Authenticator.setDefault(new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				if (getRequestorType() == RequestorType.PROXY) {
//					String prot = getRequestingProtocol().toLowerCase();
//					String host = "proxy.cervedgroup.com";
//					String port = "8080";
//					String user = "cge01609";
//					String password = "JMetro1989";
//
//					if (getRequestingHost().equalsIgnoreCase(host)) {
//						if (Integer.parseInt(port) == getRequestingPort()) {
//							// Seems to be OK.
//							return new PasswordAuthentication(user, password.toCharArray());
//						}
//					}
//				}
//				return null;
//			}
//		});
//		 Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyType,
//		 proxyPort));
		HttpURLConnection oHttpURLConnection = (HttpURLConnection) urlToRequest.openConnection();
		oHttpURLConnection.setReadTimeout(1000000);
		oHttpURLConnection.setConnectTimeout(1000000);
		oHttpURLConnection.setRequestMethod(httpMethod.getValue());
		oHttpURLConnection.setDoInput(true);
		oHttpURLConnection.setDoOutput(true);
		return oHttpURLConnection;
	}

	public void setHeaderConnectionDetails(HttpURLConnection oHttpURLConnection) {
		oHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		oHttpURLConnection.setRequestProperty("Cache-Control", "max-age=0");
	}

	private void setPostData(String postData, HttpURLConnection oHttpURLConnection) throws IOException, UnsupportedEncodingException {
		OutputStream os = oHttpURLConnection.getOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
		writer.write(postData);
		writer.flush();
		writer.close();
		os.close();
	}

	public void setProxyType(String proxyType) {
		this.proxyType = proxyType;
	}

	public void setProxyPort(Integer proxyPort) {
		this.proxyPort = proxyPort;
	}

	public void setCookie(HttpURLConnection oHttpURLConnection, Z input) {
		if (oHttpURLConnection == null) {
		}
		String cookie = "";
		if (input.getCookieMap() != null) {
			for (String cookieKey : input.getCookieMap().keySet()) {
				cookie += cookieKey + "=" + input.getCookieMap().get(cookieKey) + ";";
			}
		}
		oHttpURLConnection.setRequestProperty("Cookie", cookie);

	}

	public Map<String, String> parserCookies(HttpURLConnection oHttpURLConnection) {
		Map<String, String> retMap = new HashMap<String, String>();
		Map<String, List<String>> headerFields = oHttpURLConnection.getHeaderFields();
		List<String> cookiesHeader = headerFields.get("Set-Cookie");
		if (cookiesHeader != null) {
			for (String cookies : cookiesHeader) {
				if (cookies != null) {
					String[] cookie = cookies.split(";");
					for (String cookieValue : cookie) {
						String[] parsedCookie = cookieValue.split("=");
						retMap.put(parsedCookie[0], parsedCookie[1]);
					}

				}
			}
		}
		return retMap;
	}

	private String buildData(Z input) throws IllegalAccessException, InvocationTargetException {
		String postData = "";
		Field[] elencoField = input.getClass().getDeclaredFields();
		Method[] methods = input.getClass().getDeclaredMethods();
		try {
			for (int i = 0; i < elencoField.length; i++) {

				if (elencoField[i].getDeclaredAnnotations() != null) {
					for (Method m : methods) {
						if (m.getName().contains("get" + elencoField[i].getName().substring(0, 1).toUpperCase() + elencoField[i].getName().substring(1))) {
							postData += elencoField[i].getAnnotation(HttpParameterKey.class).value();
							if (m.invoke(input) != null) {
								postData += "=" + m.invoke(input);
							}
							postData += "&";
						}
					}
				}
			}

		} catch (IllegalAccessException e) {
			throw e;
		} catch (SecurityException e) {
			throw e;
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (InvocationTargetException e) {
			throw e;
		}

		// rimuovo ultimo &
		return postData.length() > 0 ? postData.substring(0, postData.length() - 1) : postData;
	}

	@Override
	public void setHttpMethod(HTTPMethod httpMethod) {
		this.httpMethod = httpMethod;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setOutputConverter(HttpGenericOutputConverter<T> outputConverter) {
		this.outputConverter = outputConverter;
	}

}
