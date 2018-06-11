package bot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import at.neonartworks.ninesearch.core.GagPost;
import at.neonartworks.ninesearch.core.GagSearchV2;
import at.neonartworks.ninesearch.utils.GagSection;

public class GAG {

	private static List<GagPost> posts = new ArrayList<GagPost>();

	public static void main(String[] args) {
		GagSearchV2 gs = new GagSearchV2(); // create a new instance of
		// GagSearch.

try {
// use the getFromSectoin command to retrieve the posts.
posts = gs.getFromSection(GagSection.DARK_HUMOR);

} catch (IOException e) {
e.printStackTrace();
}

// check the retrieved posts by printing everyone to the console.
for (GagPost p : posts) {
System.out.println(p.toString());

}

}
}

/*
 * public static void main(String[] args) { GAG g = new GAG(); g.buscar9GAG(); }
 */

