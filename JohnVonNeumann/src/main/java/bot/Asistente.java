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
			if(entrada.matches("(?s).*\\bhola\\b.*")) {
				return new EcoResponse().devolverSaludo(user,nombreAsistente);
			}
			if(entrada.matches("(?s).*\\bgracias\\b.*")) {
				return new EcoResponse().devolverAgradecimiento(user);
			}
			if(entrada.contains("chau")) {
				return new EcoResponse().devolverDespedida(user);
			}
			if(entrada.matches("(?s).*\\bclima en\\b.*")) {
				return Weather.temperatura(entrada.split("clima en ")[1]);
			}
		}
		catch (Exception e) {
			return "Error, error (robotina voice).";
		}
		
		return "No entendí lo que me dijiste "+user+".";
	}


}
