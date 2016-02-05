package moviesearch.models.data;

import java.util.ArrayList;

import org.json.JSONObject;

import moviesearch.objects.MovieObject;

public class MyAPIFilmsParser {
	public static ArrayList<MovieObject> fromSearchResults(JSONObject serviceResponse){
		ArrayList<MovieObject> resultList = new ArrayList<MovieObject>();
		for(Object result: serviceResponse.getJSONObject("data").getJSONArray("movies")){
			JSONObject jsonResult = (JSONObject) result;

			//create new movie
			MovieObject newMovie = new MovieObject();
			newMovie.title = jsonResult.getString("title");
			newMovie.year = jsonResult.getString("year");
			newMovie.overview = jsonResult.getString("simplePlot");
			//parse directors
			for(Object directorNode: jsonResult.getJSONArray("directors")){
				JSONObject jsonDirector = (JSONObject) directorNode;
				newMovie.directors.add(jsonDirector.getString("name"));
			}
			
			resultList.add(newMovie);
		}
		return resultList;
	}
}
