package moviesearch.models.utilities;

import java.util.ArrayList;

import moviesearch.objects.MovieObject;

public class Output {
	private static final String SEPARATOR = "====";
	public static void print(ArrayList<MovieObject> results){
		for(MovieObject movie: results){
			System.out.println(SEPARATOR);
			System.out.println("title: " + movie.title);
			System.out.println("overview: " + movie.overview);
			System.out.println("year: " + movie.year);
			System.out.println("directors: " + String.join(",", movie.directors));
		}
		System.out.println(SEPARATOR);
	}
	
}
