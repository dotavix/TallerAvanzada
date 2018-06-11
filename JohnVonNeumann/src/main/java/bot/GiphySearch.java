package bot;

import at.mukprojects.giphy4j.Giphy;
import at.mukprojects.giphy4j.entity.search.SearchFeed;
import at.mukprojects.giphy4j.exception.GiphyException;

public class GiphySearch {
	
	private static String API_KEY = "dc6zaTOxFJmzC";
	
	public void buscarGIF() throws GiphyException {
		
		 Giphy g = new Giphy(API_KEY);
		 SearchFeed f = g.search("messi", 1, 0);
		 String url = f.getDataList().get(0).getImages().getOriginal().getUrl();
		 System.out.println(url);
	}
	
	public static void main(String[] args) throws GiphyException {
		GiphySearch gs = new GiphySearch();
		gs.buscarGIF();
	}
	
}
