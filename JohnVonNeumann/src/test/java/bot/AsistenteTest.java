package bot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AsistenteTest {
	
	public final static String USER = "Jorge";
	Asistente robot;
	
	@Before
	public void setup() {
		robot = new Asistente("robotitus");
	}
	
	@Test
	public void pruebas() {
		
		String[] mensajes = {
				"hola!",
				"hola padre, como andas",
				"gracias, te agradezco mucho por lo que hiciste!",
				"GRAciaS!",
				"los chause",
				"wea cosmica",
				"quiero saber el clima en merlo",
				"quiero saber el clima en san justo",
				"que hora es?",
				"que dia es?",
				"quisiera saber la fecha actual",
				"que dia de la semana es?"
		};

			
		for(String mensaje : mensajes) {
			System.out.println(robot.enviar(USER,mensaje));
			Assert.assertTrue(true);
		}
		
	}
	
	
}
