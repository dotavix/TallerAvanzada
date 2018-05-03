package fecha;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {

	private Date fecha;

	public Fecha(Date fecha) {
		this.fecha = fecha;
	}

	public static Date sumarDiasAFecha(Date fecha, int dias) {
		if (dias == 0)
			return fecha;
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, dias); // MONTH - YEAR aca hay que definir si vamos a hacer la misma funcion 3 veces para dia mes o año, o tener 1 solo para todos los casos, PD: si le pasas numeros negativos te hace la resta asi que va bien
		return calendar.getTime();
	}

	public static int diasTranscurridos(Date fechaInicial, Date fechaFinal) {

		int dias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);
		return dias;
	}
	
	public static String fechaHoy() {
		
		return new SimpleDateFormat(" dd-MMMM-yyyy-hh:mma-EEEE ").format(Calendar.getInstance().getTime());
		
	}

	public static String hora() {
		String[] part = fechaHoy().split("-");
		return "Son las "+part[3];
	}
	
	public static String diaDeLaSemana() {
		String[] part = fechaHoy().split("-");
		return "Hoy es "+part[4];
	}
	
	public static String fechaActual() {
		String[] part = fechaHoy().split("-");
		return "Hoy es el"+part[0]+" de "+part[1]+" del "+part[2]+"";
	}
	
	public static void main(String[] args) {

		/*Date FECHA1 = new GregorianCalendar(2018, 3,30,15,15,0).getTime();
		Date FECHA2 = new GregorianCalendar(2018, 5, 23, 15, 15, 0).getTime();
		Date FECHA_MAS = new GregorianCalendar().getTime();
		int resu = 0;
		int dias = 3;
		FECHA_MAS = sumarDiasAFecha(FECHA_MAS, dias)
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE-dd-MMMM-yyyy");
		
		System.out.println(sdf.format(FECHA_MAS));
	
		resu = diasTranscurridos(FECHA1, FECHA2);
		System.out.println(resu);*/
		
		
		//System.out.println(Fecha.fechaDeHoy());
		
		System.out.println(Fecha.hora());
		System.out.println(Fecha.fechaActual());
		System.out.println(Fecha.diaDeLaSemana());
		
	
	}
	
	
	

}
