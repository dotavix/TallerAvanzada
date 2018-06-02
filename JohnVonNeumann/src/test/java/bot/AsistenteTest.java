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
	public void ejercicio00() throws Exception{
			System.out.println(robot.enviar(USER,"wea cosmica"));
			Assert.assertTrue(robot.enviar(USER,"wea cosmica").contains("No entendi"));
	}
	
	@Test
	public void ejercicio01() throws Exception {
		
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
	public void ejercicio02() throws Exception {
		
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
	public void ejercicio02plus() throws Exception {
		
		String[] mensajes = {
				"los chause"
		};

			
		for(String mensaje : mensajes) {
			System.out.println(robot.enviar(USER,mensaje));
			Assert.assertTrue(robot.enviar(USER,mensaje).contains("Goodbye"));
		}
		
	}
	
	@Test
	public void ejercicio03() throws Exception {
		
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
	public void ejercicio04() throws Exception {
		
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
		
		
		
	}
	
	@Test
	public void ejercicio09() throws Exception {
		
		System.out.println(robot.enviar(USER,"quiero saber el clima en merlo"));
		Assert.assertTrue(robot.enviar(USER,"quiero saber el clima en merlo").contains("La temperatura"));
		
		System.out.println(robot.enviar(USER,"quiero saber el clima en san justo"));
		Assert.assertTrue(robot.enviar(USER,"quiero saber el clima en san justo").contains("La temperatura"));
		
		System.out.println(robot.enviar(USER,"quiero saber el clima"));
		Assert.assertTrue(robot.enviar(USER,"quiero saber el clima").contains("La temperatura"));
				
	}
	
	@Test
	public void ejercicio13() throws Exception {
		
		System.out.println(robot.enviar(USER,"quiero un chuck norris fact"));
		Assert.assertTrue(robot.enviar(USER,"quiero un chuck norris fact").contains("Chuck Norris"));
		
		System.out.println(robot.enviar(USER,"quiero un chuck norris fact"));
		Assert.assertTrue(robot.enviar(USER,"quiero un chuck norris fact").contains("Chuck Norris"));
		
		System.out.println(robot.enviar(USER,"quiero un chuck norris fact"));
		Assert.assertTrue(robot.enviar(USER,"quiero un chuck norris fact").contains("Chuck Norris"));
				
	}
	
	@Test
	public void ejercicio12() throws Exception {
		
		System.out.println(robot.enviar(USER,"quiero la primera ley de la robotica please"));
		Assert.assertTrue(robot.enviar(USER,"quiero la primera ley de la robotica please").contains("1- Un robot"));
		
		System.out.println(robot.enviar(USER,"quiero la 2da ley de la robotica please"));
		Assert.assertTrue(robot.enviar(USER,"quiero la 2da ley de la robotica please").contains("2- Un robot"));
		
		System.out.println(robot.enviar(USER,"quiero la tercera ley de la robotica please"));
		Assert.assertTrue(robot.enviar(USER,"quiero la tercera ley de la robotica please").contains("3- Un robot"));
		
		System.out.println(robot.enviar(USER,"quiero todas las leyes de la robotica please"));
		Assert.assertTrue(robot.enviar(USER,"quiero todas las leyes de la robotica please").contains("1- Un robot"));
				
	}
	
	@Test
	public void ejercicio15() throws Exception {
		
		System.out.println(robot.enviar(USER,"quiero encriptar el siguiente mensaje: sarasa cosmica"));
		Assert.assertTrue(robot.enviar(USER,"quiero encriptar el siguiente mensaje: sarasa cosmica").contains("hQEMA5J1TA"));
		
		System.out.println(robot.enviar(USER,"quiero desencriptar el siguiente mensaje: hQEMA5J1TAqWL8k1AQf/Z22fGbPQMGFFVQDUI7x2X0AuLVhNbBnQb1fOkZB5/Il0CraHG5C3qOOqvfYmrp0+vqlAw65BWZMwB2Pv5scjfkBh71tQPKzmIXKY2bvt4W89WkxwFQ4jtfVFiot1/MWJSgqP8g4e4w8QznYpOP/sjnxJMYhfIxv/g47T9ueu82m+OUHUQyFHxNPNv+twmEErK5VEk2p1xsqK6RbcxcnuQoxFWjn5GHyyqzsZNL6vQE2oSXDEBEFF1SuvgZ273M8NL9+m0IfUGna3LGd2uuWLYd4c2xAmZZkpWHWi0FffgSb6/Y/A+7AqyBQosIoYm0ZsCMo+WYwCsQGystCSy0d9XckvrgnYuQl3rBgtIX5iEdIpGg/9qqjt2hbz7lp+HAMUKqF+OTIbKVtUHn5ssMmn0xw==lSue"));
		Assert.assertTrue(robot.enviar(USER,"quiero desencriptar el siguiente mensaje: hQEMA5J1TAqWL8k1AQf/Z22fGbPQMGFFVQDUI7x2X0AuLVhNbBnQb1fOkZB5/Il0CraHG5C3qOOqvfYmrp0+vqlAw65BWZMwB2Pv5scjfkBh71tQPKzmIXKY2bvt4W89WkxwFQ4jtfVFiot1/MWJSgqP8g4e4w8QznYpOP/sjnxJMYhfIxv/g47T9ueu82m+OUHUQyFHxNPNv+twmEErK5VEk2p1xsqK6RbcxcnuQoxFWjn5GHyyqzsZNL6vQE2oSXDEBEFF1SuvgZ273M8NL9+m0IfUGna3LGd2uuWLYd4c2xAmZZkpWHWi0FffgSb6/Y/A+7AqyBQosIoYm0ZsCMo+WYwCsQGystCSy0d9XckvrgnYuQl3rBgtIX5iEdIpGg/9qqjt2hbz7lp+HAMUKqF+OTIbKVtUHn5ssMmn0xw==lSue").contains("sarasa cosmica"));
		
	}
	
	@Test
	public void ejercicio17() throws Exception {
		
		System.out.println(robot.enviar(USER,"quiero las noticias actuales porque soy muy intelectual"));
		Assert.assertTrue(robot.enviar(USER,"quiero las noticias actuales porque soy muy intelectual").contains("---NOTICIAS---"));
		
	}
	
	
}
