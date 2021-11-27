package it.fabio.esercitazione.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import it.fabio.esercitazione.dto.DifferenceDto;
import it.fabio.esercitazione.dto.ObjectReadDto;
import it.fabio.esercitazione.interfaces.Sortable;
import it.fabio.esercitazione.interfaces.Readable;

public class WeatherService implements Sortable, Readable<ObjectReadDto>{

	public void readFile(Path path){
		List<ObjectReadDto> objectReadDtoList = createListFromFile(path);
		List<DifferenceDto> differenceList = Sortable.super.findMinDifference(objectReadDtoList);
		System.out.println("\nResult with min diff (key = Day ; diff= Difference of temperature):\n"+differenceList);
	}

	@Override
	public  List<ObjectReadDto> createListFromFile(Path path) {
		List<ObjectReadDto> objectReadDtoList= new ArrayList<ObjectReadDto>();
		 try(BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))){
		      String currentLine = null;
		      int numberOfLine= 0; 
		      while((currentLine = reader.readLine()) != null){
		    	String[] content = currentLine.split("\\s+");
		        if(numberOfLine!=0 && content.length>1) {
		        	String day = content[1];
		        	BigDecimal maxTemp = content[2].contains("*")?new BigDecimal(content[2].replace("*", "")) : new BigDecimal(content[2]);
		        	BigDecimal minTemp = content[3].contains("*")?new BigDecimal(content[3].replace("*", "")) : new BigDecimal(content[3]);
		        	ObjectReadDto weatherDto = new ObjectReadDto(day,minTemp,maxTemp);
		        	objectReadDtoList.add(weatherDto);
		        }
		        numberOfLine++;
		      }
		    }catch(IOException ex){
		      ex.printStackTrace();
		    }
		return objectReadDtoList;
	}

}
