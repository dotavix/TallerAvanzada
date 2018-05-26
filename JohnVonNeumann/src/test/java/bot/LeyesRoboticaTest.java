package bot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;


public class LeyesRoboticaTest {

	@Test
	public void respuestaLeyes() {
		
		assertTrue(LeyesRobotica.PrimeraLey().equals("1- Un robot no hará daño a un ser humano, ni permitirá con su inacción que sufra daño."));
		assertTrue(LeyesRobotica.SegundaLey().equals("2- Un robot debe cumplir las órdenes dadas por los seres humanos, a excepción de aquellas que entrasen en conflicto con la primera ley."));
		assertTrue(LeyesRobotica.TerceraLey().equals("3- Un robot debe proteger su propia existencia en la medida en que esta protección no entre en conflicto con la primera o con la segunda ley."));
		
		assertTrue(LeyesRobotica.LeyAll().equals("1- Un robot no hará daño a un ser humano, ni permitirá con su inacción que sufra daño.\n" +
				"2- Un robot debe cumplir las órdenes dadas por los seres humanos, a excepción de aquellas que entrasen en conflicto con la primera ley.\n" + 
				"3- Un robot debe proteger su propia existencia en la medida en que esta protección no entre en conflicto con la primera o con la segunda ley."));
	}
	
}
