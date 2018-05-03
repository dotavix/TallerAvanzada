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

	
	public static Date sumarFecha(Date fecha, int cantidad, String dato) {
		
		Calendar calendar = new GregorianCalendar();
		
		if (cantidad == 0)
			return fecha;
		
		else if (dato.contains("días") || dato.contains("día") ||dato.contains("dias") ||dato.contains("dia")) {
		
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, cantidad);
		}
		else if(dato.contains("meses")||dato.contains("mes") || dato.contains("Meses") || dato.contains("Mes")) {
			calendar.setTime(fecha);
			calendar.add(Calendar.MONTH, cantidad);
		}
		
		else if(dato.contains("años") || dato.contains("año") || dato.contains("Años") ||dato.contains("Año")) {
			
			calendar.setTime(fecha);
			calendar.add(Calendar.YEAR, cantidad);
		}
		
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
		int dias = -3;
		String dato="qué día fue hace 3 días?";
		FECHA_MAS = sumarFecha(FECHA_MAS, dias,dato);
		
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
