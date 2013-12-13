package org.peddie.peer_tutoring;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.peddie.peer_tutoring.model.Dorm;
import org.peddie.peer_tutoring.model.Query;
import org.peddie.peer_tutoring.model.Result;
import org.peddie.peer_tutoring.model.Subject;
import org.peddie.peer_tutoring.model.Tutor;
import org.peddie.peer_tutoring.util.CheatingDatabase;
import org.peddie.peer_tutoring.util.Database;

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

		server.createContext("/api/query", new QueryHandler());
		
		// TODO(jiehan): implement the following
//		server.createContext("/api/tutors", new TutorsListingHandler());
//		server.createContext("/api/dorm", new DormsListingHandler());
		
		server.setExecutor(Executors.newCachedThreadPool());
		server.start();

		System.err.println("HTTP server listening on " + port + ".");

	}

	
	private static class QueryHandler implements HttpHandler {

		Gson gson = new Gson();
		
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			List<NameValuePair> httpQuery = URLEncodedUtils.parse(exchange.getRequestURI(), "UTF-8");
			System.err.println(httpQuery);

			Map<String, String> queryKeyToValue = new HashMap<String, String>();
			for (NameValuePair pair : httpQuery) {
				queryKeyToValue.put(pair.getName(), pair.getValue());
			}

			Query query;
			try {
				query = new Query(Subject.valueOf(queryKeyToValue.get("subject")),
						Dorm.valueOf(queryKeyToValue.get("dorm")));
				
				Result result = new Result(tutorMatcher.runQuery(query));
				System.err.println(result);
				exchange.sendResponseHeaders(HttpStatus.SC_ACCEPTED, 0);
				OutputStream responseBody = exchange.getResponseBody();
				responseBody.write(gson.toJson(result).getBytes());
				
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpStatus.SC_NOT_ACCEPTABLE, -1);
			}
			
			exchange.close();
		}

	}

}
