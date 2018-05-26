package bot;

public class LeyesRobotica {

	public static String PrimeraLey() {
		return "1- Un robot no hará daño a un ser humano,"
				+ " ni permitirá con su inacción que sufra daño.";
	}
	
	public static String SegundaLey() {
		return "2- Un robot debe cumplir las órdenes dadas por"
				+ " los seres humanos, a excepción de aquellas que "
				+ "entrasen en conflicto con la primera ley.";
	}
	
	public static String TerceraLey() {
		return "3- Un robot debe proteger su propia existencia "
				+ "en la medida en que esta protección no entre en "
				+ "conflicto con la primera o con la segunda ley.";
	}
	
	public static String LeyAll() {
		return LeyesRobotica.PrimeraLey()+ "\n" + LeyesRobotica.SegundaLey()+
				"\n"+LeyesRobotica.TerceraLey();
	}
}
