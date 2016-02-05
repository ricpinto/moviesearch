package moviesearch.models.data;

import java.util.ArrayList;

import org.json.JSONObject;
import moviesearch.models.utilities.Conf;
import moviesearch.models.utilities.Json;
import moviesearch.objects.MovieObject;


/*
 * My API Films api integration model
 * http://www.myapifilms.com/index.do
 * token stored in the application.conf file
 */

public class MyAPIFilms extends DataAPI{
	public static ArrayList<MovieObject> search(String criteria){
		JSONObject configs = Conf.get("myapifilms");

		String endpoint = configs.getString("endpoint");
		String path = "imdb/idIMDB";
		String params = "title=" + criteria + "&token=" + configs.getString("token") + "&limit=4";
		
		String response = request(endpoint, path, params);
		return MyAPIFilmsParser.fromSearchResults(Json.parse(response));
	}
	 
	
}
