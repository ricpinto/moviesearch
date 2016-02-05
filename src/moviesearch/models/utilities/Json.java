package moviesearch.models.utilities;

import java.io.InputStream;
import org.json.*;
import moviesearch.Main;

public class Json {
	public static JSONObject parse(String text){
		JSONObject obj = new JSONObject(text);
		return obj;
	}
	
	public static JSONObject parse(InputStream inputStream){
		JSONObject obj = new JSONObject(inputStream);
		return obj;
	}
	
	public static JSONObject loadFromFile(String path){
		InputStream fileContentStream = Main.class.getResourceAsStream(path);
		try{
			String stringContent = StringParser.fromInputStream(fileContentStream);
			return Json.parse(stringContent);
		}catch(Exception ex){
			System.err.println("problem reading configs");
			return null;
		}
	}
}
