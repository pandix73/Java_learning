package netdb.courses.softwarestudio.lab.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpRetriever {

	private static final String DEFAULT_ENCODING = "utf8";
	private static final int DEFAULT_BUFFER_SIZE = 8192;

	/**
	 * Fetch the given URL and return its content as a String
	 * 
	 * @param url
	 *            the URL of the resource
	 * 
	 * @return the String of content
	 * 
	 * */
	public static String retrieveContent(String url) {

		StringBuffer stringBuff = new StringBuffer();

		CloseableHttpClient client = HttpClients.createDefault();

		HttpGet req = new HttpGet(url);
		CloseableHttpResponse res;

		try {

			res = client.execute(req);

			HttpEntity entity = res.getEntity();

			if (entity != null) {
				InputStreamReader inReader = new InputStreamReader(
						entity.getContent(), DEFAULT_ENCODING);
				BufferedReader buffReader = new BufferedReader(inReader,
						DEFAULT_BUFFER_SIZE);

				String temp;
				while ((temp = buffReader.readLine()) != null) {
					stringBuff.append(temp);
				}
			}

			res.close();

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return stringBuff.toString();

	}
}
