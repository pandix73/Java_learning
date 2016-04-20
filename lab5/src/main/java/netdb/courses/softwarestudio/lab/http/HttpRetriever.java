package netdb.courses.softwarestudio.lab.http;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpRetriever {

	public static String retrieveContent(String url) throws Exception {

		StringBuffer buff = new StringBuffer();

		CloseableHttpClient client = HttpClients.createDefault();

		HttpGet req = new HttpGet(url);
		CloseableHttpResponse res = client.execute(req);

		HttpEntity entity = res.getEntity();

		if (entity != null) {
			InputStream in = entity.getContent();
			int data;
			while ((data = in.read()) != -1) {
				buff.append((char) data);
			}
		}
		return buff.toString();
	}
}
