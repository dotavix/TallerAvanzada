package bot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
				String[] input = entrada.split("dia sera en ")[1].split(" ");
				return Fecha.sumarFecha(new Date(), Integer.parseInt(input[0]), input[1].substring(0, 3));
			}
			if(entrada.matches(".*dia sera dentro de.*")) {
				String[] input = entrada.split("dia sera dentro de ")[1].split(" ");
				return Fecha.sumarFecha(new Date(), Integer.parseInt(input[0]), input[1].substring(0, 3));
			}
			if(entrada.matches(".*dia (sera|va a ser) maniana.*")) {
				return Fecha.sumarFecha(new Date(), 1, "dia");
			}
			if(entrada.matches(".*dia fue hace.*")) {
				String[] input = entrada.split("dia fue hace ")[1].split(" ");
				return Fecha.sumarFecha(new Date(), Integer.parseInt("-"+input[0]), input[1].substring(0, 3));
			}
			if(entrada.matches(".*dia fue ayer.*")) {
				return Fecha.sumarFecha(new Date(), -1, "dia");
			}
			if(entrada.matches(".*dia fue (anteayer|antes de ayer).*")) {
				return Fecha.sumarFecha(new Date(), -2, "dia");
			}
			if(entrada.matches(".*dias pasaron desde el.*")) {
				String input = entrada.split("dias pasaron desde el ")[1];
				DateFormat format = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
				return Fecha.diasTranscurridos(new Date(), format.parse(input));
			}
//			falta este --->
//			"@delucas faltan 9 días",
//			jenkins.escuchar("@jenkins cuántos días faltan para el 10 de abril?")
		}
		catch (Exception e) {
//			e.printStackTrace();
			return "Error, error (robotina voice).";
		}
		
		return "No entendí lo que me dijiste "+user+".";
	}


}
