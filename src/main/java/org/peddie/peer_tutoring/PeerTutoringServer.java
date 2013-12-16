package org.peddie.peer_tutoring;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.peddie.peer_tutoring.model.Dorm;
import org.peddie.peer_tutoring.model.DutyDay;
import org.peddie.peer_tutoring.model.Query;
import org.peddie.peer_tutoring.model.Result;
import org.peddie.peer_tutoring.model.ScoredTutor;
import org.peddie.peer_tutoring.model.Subject;
import org.peddie.peer_tutoring.model.Tutor;
import org.peddie.peer_tutoring.util.CheatingDatabase;
import org.peddie.peer_tutoring.util.Database;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * @author jiehan
 *
 */
public class PeerTutoringServer {

	private static Database database;
	private static TutorMatcher tutorMatcher;

	public static void main(String[] args) throws IOException {
		// parse cmdline options
		ArgumentParser parser = ArgumentParsers.newArgumentParser("PeerTutoringServer")
				.defaultHelp(true)
				.description("A backend TCP socket server for the Peddie peer tutoring website.");

		parser.addArgument("dbpath").help("directory for datafiles");
		parser.addArgument("-p", "--port").help("TCP port to bind to").setDefault(12130);

		Namespace ns = null;
		try {
			ns = parser.parseArgs(args);
		} catch (ArgumentParserException e) {
			parser.handleError(e);
			System.exit(1);
		}

		Path databasePath = Paths.get(ns.getString("dbpath"));
		if (!Files.exists(databasePath))
			throw new IllegalArgumentException("dbpath " + databasePath + " don't exist.");

		// read database
		database = new CheatingDatabase();

		// read tutors from database
		Set<Tutor> tutors = database.getTutors();

		// create a TutorMatcher
		tutorMatcher = new TutorMatcher(tutors);

		// listen on socket
		InetSocketAddress addr;
		int port = ns.getInt("port");
		try {
			addr = new InetSocketAddress(port);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("port " + port + " is not valid.");
		}
		HttpServer server = HttpServer.create(addr, 0);

		server.createContext("/api/tutors", new QueryHandler());
		server.createContext("/api/dorms", new DormsListingHandler());
		server.createContext("/api/subjects", new SubjectsListingHandler());

		server.setExecutor(Executors.newCachedThreadPool());
		server.start();

		System.err.println("HTTP server listening on " + port + ".");

	}


	private static abstract class AbstractHttpHandler implements HttpHandler {

		Gson gson = new Gson();

		@Override
		public void handle(HttpExchange exchange) throws IOException {
			List<NameValuePair> httpQuery = URLEncodedUtils.parse(exchange.getRequestURI(), "UTF-8");
			System.err.println(this.getClass().getName() + ": " + httpQuery);

			Map<String, String> queryKeyToValue = new HashMap<String, String>();
			for (NameValuePair pair : httpQuery) {
				queryKeyToValue.put(pair.getName(), pair.getValue());
			}

			try {
				String result = processQuery(queryKeyToValue);
				Headers responseHeaders = exchange.getResponseHeaders();
				responseHeaders.add("Access-Control-Allow-Origin", "*");
				exchange.sendResponseHeaders(HttpStatus.SC_OK, 0);
				OutputStream responseBody = exchange.getResponseBody();
				responseBody.write(result.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpStatus.SC_NOT_ACCEPTABLE, -1);
			}

			exchange.close();
		}

		protected abstract String processQuery(Map<String, String> httpQuery) throws IllegalArgumentException;

	}


	private static class QueryHandler extends AbstractHttpHandler {

		@Override
		protected String processQuery(Map<String, String> httpQuery) throws IllegalArgumentException {
			Subject subject = httpQuery.get("subject") != null ? Subject.valueOf(httpQuery.get("subject")) : null;
			Dorm dorm = httpQuery.get("dorm") != null ? Dorm.valueOf(httpQuery.get("dorm")) : null;
			DutyDay dutyDay = httpQuery.get("duty_day") != null ? DutyDay.valueOf(httpQuery.get("duty_day")) : null;
			
			Query query = new Query(subject, dorm, dutyDay);

			List<ScoredTutor> scoredTutors = tutorMatcher.runQuery(query);
			Collections.sort(scoredTutors);
			Collections.reverse(scoredTutors);
			
			Result result = new Result(scoredTutors);
			return gson.toJson(result);
		}

	}


	private static class DormsListingHandler extends AbstractHttpHandler {

		@Override
		protected String processQuery(Map<String, String> httpQuery) throws IllegalArgumentException {
			JsonArray dormsJsonArray = new JsonArray();
			for (Dorm dorm : Dorm.values()) {
				JsonObject dormJsonObject = new JsonObject();
				dormJsonObject.addProperty("name", dorm.getName());
				dormJsonObject.addProperty("lat", dorm.getLocation().getLatitude());
				dormJsonObject.addProperty("lng", dorm.getLocation().getLongitude());

				JsonObject namedDormJsonObject = new JsonObject();
				namedDormJsonObject.add(dorm.name(), dormJsonObject);
				dormsJsonArray.add(namedDormJsonObject);
			}

			JsonObject jsonObject = new JsonObject();
			jsonObject.add("dorms", dormsJsonArray);

			return jsonObject.toString();
		}

	}


	private static class SubjectsListingHandler extends AbstractHttpHandler {

		@Override
		protected String processQuery(Map<String, String> httpQuery) throws IllegalArgumentException {
			JsonArray dormsJsonArray = new JsonArray();
			for (Subject subject : Subject.values()) {
				JsonObject dormJsonObject = new JsonObject();
				dormJsonObject.addProperty("name", subject.getName());

				JsonObject namedSubjectJsonObject = new JsonObject();
				namedSubjectJsonObject.add(subject.name(), dormJsonObject);
				dormsJsonArray.add(namedSubjectJsonObject);
			}

			JsonObject jsonObject = new JsonObject();
			jsonObject.add("subjects", dormsJsonArray);

			return jsonObject.toString();
		}

	}

}
