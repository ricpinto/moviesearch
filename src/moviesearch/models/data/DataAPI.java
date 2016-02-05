package moviesearch.models.data;

import moviesearch.models.utilities.WebRequest;

public abstract class DataAPI {
	
	public static String request(String endpoint, String path, String params){
		String response = WebRequest.url(endpoint + path + "?" + params);
		return response;
	}
}
