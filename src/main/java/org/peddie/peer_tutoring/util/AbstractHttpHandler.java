package org.peddie.peer_tutoring.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public abstract class AbstractHttpHandler implements HttpHandler {

	protected Gson gson = new Gson();

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		List<NameValuePair> httpQuery = URLEncodedUtils.parse(exchange.getRequestURI(), "UTF-8");
		System.err.println(this.getClass().getName() + ": " + httpQuery);

		Map<String, String> queryKeyToValue = new HashMap<String, String>();
		for (NameValuePair pair : httpQuery) {
			queryKeyToValue.put(pair.getName(), pair.getValue());
		}

		JsonObject defaultResultObject = new JsonObject();
		defaultResultObject.addProperty("error", "Unknown error.");

		String result = defaultResultObject.toString();
		int rCode = HttpStatus.SC_NOT_ACCEPTABLE;
		long responseLength = 0;
		try {
			result = processQuery(queryKeyToValue);
			rCode = HttpStatus.SC_OK;
			responseLength = 0;
		} catch (Exception e) {
			e.printStackTrace();
			JsonObject errorResultObject = new JsonObject();
			errorResultObject.addProperty("error", e.getLocalizedMessage());
			result = errorResultObject.toString();
		} finally {
			Headers responseHeaders = exchange.getResponseHeaders();
			responseHeaders.add("Access-Control-Allow-Origin", "*");
			responseHeaders.add("Content-Type", "application/json");
			exchange.sendResponseHeaders(rCode, responseLength);
			OutputStream responseBody = exchange.getResponseBody();
			responseBody.write(result.getBytes());
			exchange.close();
		}
	}

	protected abstract String processQuery(Map<String, String> httpQuery) throws IllegalArgumentException;

}