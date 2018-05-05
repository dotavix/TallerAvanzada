package bot;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.*;

import bot.Fecha;

public class FechaTest {

	public Date f1 = new GregorianCalendar().getTime();
	public Date f2 = new GregorianCalendar(2018, 4, 3, 12, 0, 0).getTime();
	public Date f3 = new GregorianCalendar(2018, 4, 2, 12, 0, 0).getTime();

	@Test
	public void fechaActual() {

		SimpleDateFormat sdf = new SimpleDateFormat(" dd-MMMM-yyyy-hh:mma-EEEE ");
		Assert.assertEquals(sdf.format(f1), Fecha.fechaHoy());

	}

	@Test
	public void sumarFecha() {

		Assert.assertEquals("Sera el domingo 06 de mayo de 2018", Fecha.sumarFecha(f2, 3, "dia"));
		Assert.assertEquals("Sera el viernes 03 de agosto de 2018", Fecha.sumarFecha(f2, 3, "mes"));
		Assert.assertEquals("Sera el lunes 03 de mayo de 2021", Fecha.sumarFecha(f2, 3, "ani"));

		Assert.assertEquals("Fue el lunes 23 de abril de 2018", Fecha.sumarFecha(f2, -10, "dia"));
		Assert.assertEquals("Fue el martes 03 de abril de 2018", Fecha.sumarFecha(f2, -1, "mes"));
		Assert.assertEquals("Fue el miércoles 03 de mayo de 2017", Fecha.sumarFecha(f2, -1, "ani"));
	}

	@Test
	public void diferenciaFechas() {

		Assert.assertEquals("1 dia.", Fecha.diasTranscurridos(f3, f2));

		Assert.assertEquals("2 dias.", Fecha.diasTranscurridos(f3, f1));
	}

}
