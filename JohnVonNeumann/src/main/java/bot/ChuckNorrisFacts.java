package bot;

import java.util.ArrayList;

import bdd.Data;

public class ChuckNorrisFacts {

	public static String mostrar(String user) {
		
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Chuck Norris threw a grenade and killed 50 people, then it exploded.");
		lista.add("When Chuck Norris left for college he looked to his father and said \"You're the man of the house now\".\r\n");
		lista.add("Chuck Norris counted to infinity. Twice.\r\n");
		lista.add("Chuck Norris can kill two stones with one bird.\r\n");
		lista.add("Chuck Norris can pick oranges from an apple tree and make the best lemonade youve ever tasted.\r\n");
		lista.add("Chuck Norris can hear sign language.\r\n");
		lista.add("Once a cobra bit Chuck Norris' leg. After five days of excruciating pain, the cobra died.\r\n");
		lista.add("Chuck Norris doesn't cheat death. He wins fair and square.\r\n");
		lista.add("There is no theory of evolution, just a list of creatures Chuck Norris allows to live.\r\n");
		lista.add("Chuck Norris will never have a heart attack... even a heart isnt foolish enough to attack Chuck Norris.\r\n");
		
		Data d = new Data(user);
		d.obtain();
		Integer chuck = d.getChuck();
		d.setChuck((chuck+1)%lista.size());
		d.save();
		return lista.get(chuck);
	}
	
}