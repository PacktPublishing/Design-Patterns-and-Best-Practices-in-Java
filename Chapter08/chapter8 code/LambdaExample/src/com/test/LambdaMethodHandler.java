package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

/**
 * Class to implement simple hello world example 
 *
 */
public class LambdaMethodHandler implements RequestStreamHandler {

	public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        JSONObject responseJson = new JSONObject();
        String name = "Guest";
       
        String responseCode = "200";

        try {
        	// First parse the request 
        	JSONParser parser = new JSONParser();
            JSONObject event = (JSONObject)parser.parse(reader);
            
            if (event.get("queryStringParameters") != null) {
                JSONObject queryStringParameters = (JSONObject)event.get("queryStringParameters");
                if ( queryStringParameters.get("name") != null) {
                    name = (String)queryStringParameters.get("name");
                }
            }

            // Prepare the response. If name was provided use that else use default.
            String greeting = "Hello "+ name;

            JSONObject responseBody = new JSONObject();
            responseBody.put("message", greeting);

            JSONObject headerJson = new JSONObject();
            responseJson.put("isBase64Encoded", false);
            responseJson.put("statusCode", responseCode);
            responseJson.put("headers", headerJson);
            responseJson.put("body", responseBody.toString());  

        } catch(ParseException parseException) {
            responseJson.put("statusCode", "400");
            responseJson.put("exception", parseException);
        }

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseJson.toJSONString());  
        writer.close();
    }


        
}