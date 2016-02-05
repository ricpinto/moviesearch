package moviesearch.models.utilities;

import java.net.HttpURLConnection;
import java.net.URL;

public class WebRequest {
	public static String url(String url){
		String response = null;
		try{
			URL urlPath = new URL(url);
			HttpURLConnection request = (HttpURLConnection)urlPath.openConnection();
			response = StringParser.fromInputStream(request.getInputStream());
		}catch(Exception ex){
			System.err.println("problem processing the web request");
			System.err.println(ex.getMessage());
		}
		return response;
	}
}
