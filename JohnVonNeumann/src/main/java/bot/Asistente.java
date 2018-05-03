package bot;

public class Asistente {
	
	String nombreAsistente;
	
	public Asistente(String nombreAsistente) {
		super();
		this.nombreAsistente = nombreAsistente;
	}

	public String enviar(String user, String entrada) {
		
		entrada = entrada.toLowerCase();
		entrada.replace("por favor", "");
		
		try {
			if(entrada.matches(".*hola.*")) {
				return new EcoResponse().devolverSaludo(user,nombreAsistente);
			}
			if(entrada.matches(".*gracias.*")) {
				return new EcoResponse().devolverAgradecimiento(user);
			}
			if(entrada.matches(".*chau.*")) {
				return new EcoResponse().devolverDespedida(user);
			}
			if(entrada.matches(".*clima en.*")) {
				return Weather.temperatura(entrada.split("clima en ")[1].split(",")[0]);
			}
		}
		catch (Exception e) {
			return "Error, error (robotina voice).";
		}
		
		return "No entendí lo que me dijiste "+user+".";
	}


}
