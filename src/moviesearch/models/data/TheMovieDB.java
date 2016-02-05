package moviesearch.models.data;

import java.util.ArrayList;

import org.json.JSONObject;
import moviesearch.models.utilities.Conf;
import moviesearch.models.utilities.Json;
import moviesearch.objects.MovieObject;


/*
 * The Movie Database (TMDb) api integration model
 * https://www.themoviedb.org/
 * api_key stored in the application.conf file
 */

public class TheMovieDB extends DataAPI{
	public static ArrayList<MovieObject> search(String criteria){
		JSONObject configs = Conf.get("themoviedb");

		String endpoint = configs.getString("endpoint");
		String path = "search/movie";
		String params = "query=" + criteria + "&api_key=" + configs.getString("api_key");
		
		String response = request(endpoint, path, params);
		return TheMovieDBParser.fromSearchResults(Json.parse(response));
	}
	 
	
}
