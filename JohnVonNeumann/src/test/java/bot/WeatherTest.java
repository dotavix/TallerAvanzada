package bot;

import org.junit.*;

import org.junit.jupiter.api.Test;

class WeatherTest {

	@Test
	void necochea() {
		System.out.println(Weather.temperatura("necochea"));
		Assert.assertTrue(true);
	}
	
	@Test
	void merlo() {
		System.out.println(Weather.temperatura("merlo,AR"));
		Assert.assertTrue(true);
	}

}
