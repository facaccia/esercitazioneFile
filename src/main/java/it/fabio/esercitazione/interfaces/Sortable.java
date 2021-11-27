package it.fabio.esercitazione.interfaces;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import it.fabio.esercitazione.dto.DifferenceDto;
import it.fabio.esercitazione.dto.ObjectReadDto;

public interface Sortable {

	default List<DifferenceDto> findMinDifference(List<ObjectReadDto> listObjectRead) {
		
		List<DifferenceDto> differenceList= new ArrayList<DifferenceDto>();
		//create array with key and difference
		for (ObjectReadDto objectRead : listObjectRead) {
			BigDecimal diff=  objectRead.getMaxValue().subtract(objectRead.getMinValue());
			differenceList.add(new DifferenceDto(objectRead.getKey(), diff));
		}
		
		//find value with min difference
		DifferenceDto minDifference = differenceList
			      .stream()
			      .min(Comparator.comparing(DifferenceDto::getDiff))
			      .orElseThrow(NoSuchElementException::new);
		
		//find if there is multiple value with the same difference
		List<DifferenceDto> minDifferenceList = differenceList
				.stream()
				.filter(x->x.getDiff()==minDifference.getDiff())
				 .collect(Collectors.toList());
		
		return minDifferenceList;
	}
}
