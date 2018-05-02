package bot;

import org.junit.Assert;
import org.junit.Test;

public class AsistenteTest {
	
	@Test
	public void devuelveElAgradecimiento() {
		
		String[] mensajes = {
				"�Muchas gracias!!",
				"te agradezco mucho por lo que hiciste!",
				"GRAciaS!",
				"Simplemente gracias por todo lo que haces cada dia.",
				"En fin. Muchisimas Gracias por todo."
		};

		Asistente xerox = new Asistente();
		
		for(String mensaje : mensajes) {
			
			Assert.assertEquals("De nada!", xerox.devolverAgradecimiento(mensaje));
		}
		
	}
}
