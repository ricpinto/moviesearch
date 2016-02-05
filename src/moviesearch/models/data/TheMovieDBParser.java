package moviesearch.models.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONObject;

import moviesearch.objects.MovieObject;

public class TheMovieDBParser {
	public static ArrayList<MovieObject> fromSearchResults(JSONObject serviceResponse){
		ArrayList<MovieObject> resultList = new ArrayList<MovieObject>();
		for(Object result: serviceResponse.getJSONArray("results")){
			JSONObject jsonResult = (JSONObject) result;

			//create new movie
			MovieObject newMovie = new MovieObject();
			newMovie.title = jsonResult.getString("title");
			newMovie.year = getYearFromDate(jsonResult.getString("release_date"));
			newMovie.overview = jsonResult.getString("overview");
			resultList.add(newMovie);
		}
		return resultList;
	}
	
	private static String getYearFromDate(String date){
		if(date ==  null || date.length() == 0) return date;
		try{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		    Date parsedDate = format.parse(date);
		    SimpleDateFormat newFormat = new SimpleDateFormat("yyyy");
		    return newFormat.format(parsedDate);
		}catch(Exception ex){
			System.err.println("problem converting date to year");
			return null;
		}
	}
}
