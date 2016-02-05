package moviesearch;

import moviesearch.models.data.MyAPIFilms;
import moviesearch.models.data.TheMovieDB;
import moviesearch.models.utilities.Output;

public class Main {

	public static void main(String[] args){
		
		//basic routing
		String api = System.getProperty("api");
		if(api != null && api.length() > 0){
			String movie = System.getProperty("movie");
			if(movie != null && movie.length() > 0){
				processSearch(api, movie);
			}else{
				System.err.println("# invalid movie specified");
				System.exit(1);
			}
		}else{
			System.err.println("# you must specify the api and movie title to search");
			System.out.println("example: -Dapi=[themoviedb | myapifilms] -Dmovie=[movie title]");
			System.exit(0);
		}
	}
	
	private static void processSearch(String api, String movie){
		//print some feedback
		System.out.println("> searching...\n");
		switch(api){
		case "themoviedb":
			Output.print(TheMovieDB.search(movie));
			break;
		case "myapifilms":
			Output.print(MyAPIFilms.search(movie));
			break;
		default:
		System.err.println("# invalid api specified");
		System.exit(1);
	}
	}

}
