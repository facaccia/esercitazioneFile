package it.fabio.esercitazione.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportService  {

	WeatherService weatherService = new WeatherService();
	FootballService footballService= new FootballService();
	
	public void chooseFile(){
		Scanner sc = new Scanner(System.in);
		Path currentRelativePath = Paths.get("");
		String completePath = currentRelativePath.toAbsolutePath().toString();
		if(currentRelativePath.toAbsolutePath().toString().contains("target")) {
			completePath= currentRelativePath.toAbsolutePath().getParent().toAbsolutePath().toString();
		};
		File directoryPath = new File(completePath);
		String contents[] = directoryPath.list();
		List<String> allDatFile = new ArrayList<>();
		
		//looking for file ".dat" to analyze
		for(int i=0; i<contents.length; i++) {
			if(contents[i].contains(".dat")) {
				allDatFile.add(contents[i]);
			}
		}
		
		//give the possibility to see wich file is present and ready to be analyze
	    System.out.println("Wich file do you want to analyze (write the entire name, no space in beetween): ");
	    for(int i=0; i<allDatFile.size(); i++) {
	    	  System.out.println(allDatFile.get(i));
	    }
	    String selezione = sc.next();
		if (selezione.equals("football.dat")) {
			Path path = Paths.get(completePath, "/football.dat");
			footballService.readFile(path);
		} else if (selezione.equals("weather.dat")){
			Path path = Paths.get(completePath, "/weather.dat");
			weatherService.readFile(path);
		} else if(allDatFile.contains(selezione) && !selezione.equals("weather.dat") && !selezione.equals("football.dat")) {
			System.out.println("File found but unable to analyze");
		}
		else {
			System.out.println("File not found");
		}
		System.out.println("\nEnd of the program");
	}

}
