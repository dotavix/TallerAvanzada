package bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Jsonapis {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public static String obtenerNoticias() throws IOException, JSONException {
		JSONObject json = readJsonFromUrl(
				"https://newsapi.org/v2/top-headlines?country=AR&apiKey=9809cff3440c4a3f9639bcae70899c50");
		JSONArray jsonArray = (JSONArray) json.get("articles");
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < Math.min(5, jsonArray.length()); i++) {
			JSONObject object = jsonArray.getJSONObject(i);

			sb.append("Titulo: " + object.getString("title") + "\n");
			if (!object.getString("description").equals("") && !object.getString("description").equals("null"))
				sb.append("Descripcion: " + object.getString("description") + "\n");
			sb.append("Link: " + object.getString("url") + "\n");
			sb.append("\n");
		}

		return sb.toString();
	}
	
	public static String obtenerDolar() throws IOException, JSONException {
		
		JSONObject json = readJsonFromUrl("http://ws.geeklab.com.ar/dolar/get-dolar-json.php");
		
		StringBuilder sb = new StringBuilder();
		sb.append("Dolar oficial: " + json.getString("libre") + "\n");
		sb.append("Dolar blue: " + json.getString("blue") + "\n");
		
		return sb.toString();
	}
	
	public static String obtenerCiudad() throws IOException, JSONException {
		
		JSONObject json = readJsonFromUrl("http://ip-api.com/json/");
		
		return json.getString("regionName");
		
	}

	public static void main(String[] args) throws IOException, JSONException {
		
		System.out.println(Jsonapis.obtenerNoticias());
		System.out.println(Jsonapis.obtenerDolar());
		System.out.println(Jsonapis.obtenerCiudad());
	}
}
