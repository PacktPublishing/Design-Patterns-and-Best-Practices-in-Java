package com.packt.java9.chapter6;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SensorData {
	@JsonProperty
	Double humidity;
	
	@JsonProperty
	Double temperature;
	
	@JsonProperty
	String sensorName;
	
	public SensorData(String sensorName) {
		this.sensorName = sensorName;
		humidity = Double.valueOf(20 + 80 * Math.random());
		temperature = Double.valueOf(80 + 20 * Math.random());
	}
}
