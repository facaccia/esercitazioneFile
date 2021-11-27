package it.fabio.esercitazione.dto;

import java.math.BigDecimal;

public class DifferenceDto {
	
	public String key;
	public BigDecimal diff;
	

	public DifferenceDto(String key, BigDecimal diff) {
		this.key = key;
		this.diff = diff;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public BigDecimal getDiff() {
		return diff;
	}


	public void setDiff(BigDecimal diff) {
		this.diff = diff;
	}


	@Override
	public String toString() {
		return "DifferenceDto [key=" + key + ", diff=" + diff + "]";
	}

	
	
}
