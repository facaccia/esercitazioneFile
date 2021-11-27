package it.fabio.esercitazione.dto;

import java.math.BigDecimal;

public class ObjectReadDto {
	
	String key;
	BigDecimal minValue, maxValue;
	
	public ObjectReadDto(String key, BigDecimal minValue, BigDecimal maxValue) {
		this.key = key;
		this.minValue = minValue;
		this.maxValue = maxValue;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public BigDecimal getMinValue() {
		return minValue;
	}
	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}
	public BigDecimal getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}
	
	@Override
	public String toString() {
		return "ObjectReadDto [key=" + key + ", minValue=" + minValue + ", maxValue=" + maxValue + "]";
	}
	
	
}
