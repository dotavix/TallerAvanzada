package bot;

import java.util.Date;

import fecha.Fecha;

public class Asistente {
	
	String nombreAsistente;
	
	public Asistente(String nombreAsistente) {
		super();
		this.nombreAsistente = nombreAsistente;
	}

	public String enviar(String user, String entrada) {
		
		entrada = entrada.toLowerCase();
		entrada = entrada.replace("por favor", "");
		entrada = entrada.replace("?", "");
		entrada = entrada.replace("á", "a");
		entrada = entrada.replace("é", "e");
		entrada = entrada.replace("í", "i");
		entrada = entrada.replace("ó", "o");
		entrada = entrada.replace("ú", "u");
		entrada = entrada.replace("ñ", "ni");
		
		try {
			if(entrada.matches(".*hola.*")) {
				return EcoResponse.devolverSaludo(user,nombreAsistente);
			}
			if(entrada.matches(".*gracias.*")) {
				return EcoResponse.devolverAgradecimiento(user);
			}
			if(entrada.matches(".*chau.*")) {
				return EcoResponse.devolverDespedida(user);
			}
			if(entrada.matches(".*clima en.*")) {
				return Weather.temperatura(entrada.split("clima en ")[1].split(",")[0]);
			}
			if(entrada.matches(".*hora es.*")) {
				return Fecha.hora();
			}
			if(entrada.matches(".*(dia es|fecha actual).*")) {
				return Fecha.fechaActual();
			}
			if(entrada.matches(".*dia de la semana.*")) {
				return Fecha.diaDeLaSemana();
			}
			if(entrada.matches(".*dia sera en.*")) {
				String[] input = entrada.split("dia sera en ")[1].replace("s","").split(" ");
				return Fecha.sumarFecha(new Date(), Integer.parseInt(input[0]), input[1]);
			}
		}
		catch (Exception e) {
			return "Error, error (robotina voice).";
		}
		
		return "No entendí lo que me dijiste "+user+".";
	}


}
