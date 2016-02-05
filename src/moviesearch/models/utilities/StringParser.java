package moviesearch.models.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StringParser {
	public static String fromInputStream(InputStream input) throws IOException{
		StringBuilder builder = new StringBuilder();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
		String stringContent;
		while((stringContent = buffer.readLine()) != null) {
			builder.append(stringContent);   
		}	
		buffer.close();
		return builder.toString();
	}
}
