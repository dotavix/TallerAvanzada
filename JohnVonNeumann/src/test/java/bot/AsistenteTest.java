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
	public void ejercicio0(){
			System.out.println(robot.enviar(USER,"wea cosmica"));
			Assert.assertTrue(robot.enviar(USER,"wea cosmica").contains("No entendi"));
	}
	
	@Test
	public void ejercicio1() {
		
		String[] mensajes = {
				"hola!",
				"hola padre, como andas"
		};

			
		for(String mensaje : mensajes) {
			System.out.println(robot.enviar(USER,mensaje));
			Assert.assertTrue(robot.enviar(USER,mensaje).contains("Buen dia"));
		}
		
	}
	
	@Test
	public void ejercicio2() {
		
		String[] mensajes = {
				"gracias, te agradezco mucho por lo que hiciste!",
				"GRAciaS!"
		};

		for(String mensaje : mensajes) {
			System.out.println(robot.enviar(USER,mensaje));
			Assert.assertTrue(robot.enviar(USER,mensaje).contains("De nada"));
		}
		
	}
	
	@Test
	public void ejercicio2plus() {
		
		String[] mensajes = {
				"los chause"
		};

			
		for(String mensaje : mensajes) {
			System.out.println(robot.enviar(USER,mensaje));
			Assert.assertTrue(robot.enviar(USER,mensaje).contains("Goodbye"));
		}
		
	}
	
	@Test
	public void ejercicio3() {
		
		System.out.println(robot.enviar(USER,"que hora es?"));
		Assert.assertTrue(robot.enviar(USER,"que hora es?").contains("Son las"));
		
		System.out.println(robot.enviar(USER,"que dia es?"));
		Assert.assertTrue(robot.enviar(USER,"que dia es?").contains("Hoy es"));
		
		System.out.println(robot.enviar(USER,"qué día es?"));
		Assert.assertTrue(robot.enviar(USER,"qué día es?").contains("Hoy es"));
		
		System.out.println(robot.enviar(USER,"quisiera saber la fecha actual"));
		Assert.assertTrue(robot.enviar(USER,"quisiera saber la fecha actual").contains("Hoy es"));
		
		System.out.println(robot.enviar(USER,"que dia de la semana es?"));
		Assert.assertTrue(robot.enviar(USER,"que dia de la semana es?").contains("Hoy es"));
				
	}
	
	@Test
	public void ejercicio4() {
		
		System.out.println(robot.enviar(USER,"que día será en 4 dias?"));
		Assert.assertTrue(robot.enviar(USER,"que día será en 4 dias?").contains("Sera el"));
		
		System.out.println(robot.enviar(USER,"que dia sera en 27 años"));
		Assert.assertTrue(robot.enviar(USER,"que dia sera en 27 años").contains("Sera el"));
		
		System.out.println(robot.enviar(USER,"que dia fue hace 4 dias"));
		Assert.assertTrue(robot.enviar(USER,"que dia fue hace 4 dias").contains("Fue el"));
		
		System.out.println(robot.enviar(USER,"que dia fue ayer???"));
		Assert.assertTrue(robot.enviar(USER,"que dia fue ayer???").contains("Fue el"));
		
		System.out.println(robot.enviar(USER,"que dia fue anteayer"));
		Assert.assertTrue(robot.enviar(USER,"que dia fue anteayer").contains("Fue el"));
		
		System.out.println(robot.enviar(USER,"que día fué antes de ayer"));
		Assert.assertTrue(robot.enviar(USER,"que día fué antes de ayer").contains("Fue el"));
		
		System.out.println(robot.enviar(USER,"que dia sera mañana?????"));
		Assert.assertTrue(robot.enviar(USER,"que dia sera mañana?????").contains("Sera el"));
		
		System.out.println(robot.enviar(USER,"cuántos días pasaron desde el 1 de abril de 2017?"));
		Assert.assertTrue(robot.enviar(USER,"cuántos días pasaron desde el 1 de abril de 2017?").contains("Paso"));
		
		System.out.println(robot.enviar(USER,"cuantos dias faltan para el 4 de septiembre de 2018??"));
		Assert.assertTrue(robot.enviar(USER,"cuantos dias faltan para el 4 de septiembre de 2018??").contains("Falta"));
		
		System.out.println(robot.enviar(USER,"cuántos meses pasaron desde el 1 de abril de 2017?"));
		Assert.assertTrue(robot.enviar(USER,"cuántos meses pasaron desde el 1 de abril de 2017?").contains("Paso"));
		
		System.out.println(robot.enviar(USER,"cuantos meses faltan para el 4 de septiembre de 2018??"));
		Assert.assertTrue(robot.enviar(USER,"cuantos meses faltan para el 4 de septiembre de 2018??").contains("Falta"));
		
		System.out.println(robot.enviar(USER,"cuántos años pasaron desde el 1 de abril de 2017?"));
		Assert.assertTrue(robot.enviar(USER,"cuántos años pasaron desde el 1 de abril de 2017?").contains("Paso"));
		
		System.out.println(robot.enviar(USER,"cuantos años faltan para el 4 de septiembre de 2023??"));
		Assert.assertTrue(robot.enviar(USER,"cuantos años faltan para el 4 de septiembre de 2023??").contains("Falta"));
		
//		"cuantos dias faltan para el 8 de agosto??"
		
		
	}
	
	@Test
	public void ejercicio9() {
		
		System.out.println(robot.enviar(USER,"quiero saber el clima en merlo"));
		Assert.assertTrue(robot.enviar(USER,"quiero saber el clima en merlo").contains("La temperatura"));
		
		System.out.println(robot.enviar(USER,"quiero saber el clima en san justo"));
		Assert.assertTrue(robot.enviar(USER,"quiero saber el clima en san justo").contains("La temperatura"));
				
	}
	
	
}
