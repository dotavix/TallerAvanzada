package bot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Asistente {
	
	String nombreAsistente;
	
	public Asistente(String nombreAsistente) {
		super();
		this.nombreAsistente = nombreAsistente;
	}

	public String enviar(String user, String entrada) throws Exception {
				
		
		try {
			if(entrada.matches(".*desencriptar.*mensaje.*")) {
				return "@"+user+" tu mensaje desencriptado es: "+PGP.decrypt(entrada.split(": ")[1],user);
			}
			if(entrada.matches(".* encriptar.*mensaje.*")) {
				return "@"+user+" tu mensaje encriptado es:\n"+PGP.encrypt(entrada.split(": ")[1],user);
			}
			
			entrada = entrada.toLowerCase();
			entrada = entrada.replace("por favor", "");
			entrada = entrada.replace("?", "");
			entrada = entrada.replace("�", "a");
			entrada = entrada.replace("�", "e");
			entrada = entrada.replace("�", "i");
			entrada = entrada.replace("�", "o");
			entrada = entrada.replace("�", "u");
			entrada = entrada.replace("�", "ni");
			
			if(entrada.matches(".*(hola|(buen.*(dia|tarde|noche))).*")) {
				return EcoResponse.devolverSaludo(user,nombreAsistente);
			}
			if(entrada.matches(".*gracias.*")) {
				return EcoResponse.devolverAgradecimiento(user);
			}
			if(entrada.matches(".*chau.*")) {
				return EcoResponse.devolverDespedida(user);
			}
			if(entrada.matches(".*chuck.*fact.*")) {
				return "@"+user+" "+ChuckNorrisFacts.mostrar(user);
			}
			if(entrada.matches(".*noticias.*")) {
				return "@"+user+"\n"+Noticias.noticiasGeneral();
			}
			if(entrada.matches(".*(primera|1ra).*ley.*robotica.*")) {
				return "@"+user+" "+LeyesRobotica.PrimeraLey();
			}
			if(entrada.matches(".*(segunda|2da).*ley.*robotica.*")) {
				return "@"+user+" "+LeyesRobotica.SegundaLey();
			}
			if(entrada.matches(".*(tercera|3ra).*ley.*robotica.*")) {
				return "@"+user+" "+LeyesRobotica.TerceraLey();
			}
			if(entrada.matches(".*(toda).*ley.*robotica.*")) {
				return "@"+user+" "+LeyesRobotica.LeyAll();
			}
			if(entrada.matches(".*clima")) {
				return "@"+user+" "+Weather.temperatura(Jsonapis.obtenerCiudad());
			}
			if(entrada.matches(".*clima en.*")) {
				return "@"+user+" "+Weather.temperatura(entrada.split("clima en ")[1].split(",")[0]);
			}
			if(entrada.matches(".*temperatura en.*")) {
				return "@"+user+" "+Weather.temperatura(entrada.split("temperatura en ")[1].split(",")[0]);
			}
			if(entrada.matches(".*hora es.*")) {
				return "@"+user+" "+Fecha.hora();
			}
			if(entrada.matches(".*(dia es|fecha actual).*")) {
				return "@"+user+" "+Fecha.fechaActual();
			}
			if(entrada.matches(".*dia de la semana.*")) {
				return "@"+user+" "+Fecha.diaDeLaSemana();
			}
			if(entrada.matches(".*dia sera en.*")) {
				String[] input = entrada.split("dia sera en ")[1].split(" ");
				return "@"+user+" "+Fecha.sumarFecha(new Date(), Integer.parseInt(input[0]), input[1].substring(0, 3));
			}
			if(entrada.matches(".*dia sera dentro de.*")) {
				String[] input = entrada.split("dia sera dentro de ")[1].split(" ");
				return "@"+user+" "+Fecha.sumarFecha(new Date(), Integer.parseInt(input[0]), input[1].substring(0, 3));
			}
			if(entrada.matches(".*dia (sera|va a ser) maniana.*")) {
				return "@"+user+" "+Fecha.sumarFecha(new Date(), 1, "dia");
			}
			if(entrada.matches(".*dia fue hace.*")) {
				String[] input = entrada.split("dia fue hace ")[1].split(" ");
				return "@"+user+" "+Fecha.sumarFecha(new Date(), Integer.parseInt("-"+input[0]), input[1].substring(0, 3));
			}
			if(entrada.matches(".*dia fue ayer.*")) {
				return "@"+user+" "+Fecha.sumarFecha(new Date(), -1, "dia");
			}
			if(entrada.matches(".*dia fue (anteayer|antes de ayer).*")) {
				return "@"+user+" "+Fecha.sumarFecha(new Date(), -2, "dia");
			}
			if(entrada.matches(".*dias pasaron desde el.*")) {
				String input = entrada.split("dias pasaron desde el ")[1];
				DateFormat format = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
				return "@"+user+" "+"Paso "+Fecha.diasTranscurridos(new Date(), format.parse(input));
			}
			if(entrada.matches(".*dias faltan para el.*")) {
				String input = entrada.split("dias faltan para el ")[1];
				DateFormat format = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
				return "@"+user+" "+"Falta "+Fecha.diasTranscurridos(format.parse(input),new Date());
			}
			if(entrada.matches(".*meses pasaron desde el.*")) {
				String input = entrada.split("meses pasaron desde el ")[1];
				DateFormat format = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
				return "@"+user+" "+"Paso "+Fecha.mesesTranscurridos(new Date(), format.parse(input));
			}
			if(entrada.matches(".*meses faltan para el.*")) {
				String input = entrada.split("meses faltan para el ")[1];
				DateFormat format = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
				return "@"+user+" "+"Falta "+Fecha.mesesTranscurridos(format.parse(input),new Date());
			}
			if(entrada.matches(".*anios pasaron desde el.*")) {
				String input = entrada.split("anios pasaron desde el ")[1];
				DateFormat format = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
				return "@"+user+" "+"Paso "+Fecha.aniosTranscurridos(new Date(), format.parse(input));
			}
			if(entrada.matches(".*anios faltan para el.*")) {
				String input = entrada.split("anios faltan para el ")[1];
				DateFormat format = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
				return "@"+user+" "+"Falta "+Fecha.aniosTranscurridos(format.parse(input),new Date());
			}
			if(entrada.matches(".*quiero un (gif|GIF) de.*")) {
				String input = entrada.split("quiero un gif de ")[1];
				String url = GiphySearch.buscarGIF(input);
				GiphySearch.mostrarGif(url);
				return "@"+user+" " +"Disfruta este tremendo gif padre"; 
				
			}
			if(entrada.matches(".*quiero un (gag|GAG).*")){
				NineGAG.buscarGAG();
				return "@"+user+" "+"Disfruta este tremendo GAG padre"; 
			}
		}
		catch (Exception e) {
//			e.printStackTrace();
			return "Error, error (robotina voice).";
		}
		
		return "No entendi lo que me dijiste @"+user+", podrias repetirlo?";
	}


}
