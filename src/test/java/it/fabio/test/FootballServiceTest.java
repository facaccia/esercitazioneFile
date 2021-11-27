package it.fabio.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import it.fabio.esercitazione.dto.ObjectReadDto;
import it.fabio.esercitazione.service.FootballService;

public class FootballServiceTest {


	@Test
	public void testPageSize() throws Exception {
		FootballService footballService = new FootballService();
		Path currentRelativePath = Paths.get("football.dat");
		List<ObjectReadDto> list = footballService.createListFromFile(currentRelativePath);
		assertNotNull(list);
		
		//expected 20 (the record of the file), otherwise it fails
		assertEquals(20, list.size());
	}
}