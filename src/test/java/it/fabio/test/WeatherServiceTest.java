package it.fabio.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import it.fabio.esercitazione.dto.ObjectReadDto;
import it.fabio.esercitazione.service.WeatherService;

public class WeatherServiceTest {


	@Test
	public void testPageSize() throws Exception {
		WeatherService weatherService = new WeatherService();
		Path currentRelativePath = Paths.get("weather.dat");
		List<ObjectReadDto> list = weatherService.createListFromFile(currentRelativePath);
		assertNotNull(list);
		
		//expected 31 (the record of the file), otherwise it fails
		assertEquals(31, list.size());
	}
}