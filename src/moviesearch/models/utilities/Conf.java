package moviesearch.models.utilities;

import org.json.JSONObject;

/*
 * Configuration file loader
 */
public class Conf {
	
	public static String get(String domain, String property){
		JSONObject configs = loadConfigs();
		return configs.getJSONObject(domain).getString(property);
	}
	
	public static JSONObject get(String domain){
		JSONObject configs = loadConfigs();
		return configs.getJSONObject(domain);
	}

	private static JSONObject loadConfigs(){
		return Json.loadFromFile("conf/application.conf");
	}
}
