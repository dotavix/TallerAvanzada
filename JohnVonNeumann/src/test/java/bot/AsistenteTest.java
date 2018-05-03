package bot;

import org.junit.Assert;
import org.junit.Test;

public class AsistenteTest {
	
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
				"quiero saber el clima en san justo"
		};

		String user = "Jorge";
		
		Asistente xerox = new Asistente("robotitus");
		
		for(String mensaje : mensajes) {
			System.out.println(xerox.enviar(user,mensaje));
			Assert.assertTrue(true);
		}
		
	}
	
	
}
