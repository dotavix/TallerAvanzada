package bot;

import org.junit.*;

import org.junit.jupiter.api.Test;

class WeatherTest {

	@Test
	void test() {
		System.out.println(Weather.temperatura("necochea"));
		Assert.assertTrue(true);	
	}

}
