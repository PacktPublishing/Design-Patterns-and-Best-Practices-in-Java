package com.packt.java9.chapter6;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class SensorController {
	
	@Value("${sensor.name}")
	private String sensorName;
    
    @RequestMapping(value="/sensor", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SensorData> sensor() throws Exception {
    	SensorData data = new SensorData(sensorName);
    	HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_LENGTH, String.valueOf(new ObjectMapper().writeValueAsString(data).length()));
        return new ResponseEntity<SensorData>(data, headers, HttpStatus.CREATED);
    }
}