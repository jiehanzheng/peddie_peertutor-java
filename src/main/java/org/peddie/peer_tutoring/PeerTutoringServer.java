package org.peddie.peer_tutoring;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import org.peddie.peer_tutoring.model.Dorm;
import org.peddie.peer_tutoring.model.DutyDay;
import org.peddie.peer_tutoring.model.Query;
import org.peddie.peer_tutoring.model.ScoredTutor;
import org.peddie.peer_tutoring.model.Subject;
import org.peddie.peer_tutoring.model.Tutor;
import org.peddie.peer_tutoring.util.AbstractHttpHandler;
import org.peddie.peer_tutoring.util.Database;
import org.peddie.peer_tutoring.util.PlainOldJavaClassDatabase;
import org.peddie.peer_tutoring.util.TutorMatcher;
import org.peddie.peer_tutoring.util.TutorSerializer;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
				.description("A backend HTTP server for the Peddie peer tutoring website.");

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
		database = new PlainOldJavaClassDatabase();

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
		server.createContext("/api/duty_days", new DutyDaysListingHandler());

		server.setExecutor(Executors.newCachedThreadPool());
		server.start();

		System.err.println("HTTP server listening on " + port + ".");
	}


	private static class QueryHandler extends AbstractHttpHandler {
		
		public QueryHandler() {
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Tutor.class, new TutorSerializer());
			gson = gsonBuilder.create();
		}

		@Override
		protected String processQuery(Map<String, String> httpQuery) throws IllegalArgumentException {
			Subject subject = (httpQuery.get("subject") == null || httpQuery.get("subject").equals("null")) ? null : Subject.valueOf(httpQuery.get("subject"));
			Dorm dorm = (httpQuery.get("dorm") == null || httpQuery.get("dorm").equals("null")) ? null : Dorm.valueOf(httpQuery.get("dorm"));
			DutyDay dutyDay = (httpQuery.get("duty_day") == null || httpQuery.get("duty_day").equals("null")) ? null : DutyDay.valueOf(httpQuery.get("duty_day"));
			
			Query query = new Query(subject, dorm, dutyDay);

			List<ScoredTutor> scoredTutors = tutorMatcher.runQuery(query);
			Collections.shuffle(scoredTutors);
			Collections.sort(scoredTutors);
			Collections.reverse(scoredTutors);
			
			return gson.toJson(scoredTutors);
		}

	}


	private static class DormsListingHandler extends AbstractHttpHandler {

		@Override
		protected String processQuery(Map<String, String> httpQuery) throws IllegalArgumentException {
			JsonArray dormsJsonArray = new JsonArray();
			for (Dorm dorm : Dorm.values()) {
				JsonObject dormJsonObject = new JsonObject();
				dormJsonObject.addProperty("id", dorm.name());
				dormJsonObject.addProperty("name", dorm.getName());
				dormJsonObject.addProperty("type", dorm.getType().getName());

				dormsJsonArray.add(dormJsonObject);
			}

			return dormsJsonArray.toString();
		}

	}


	private static class SubjectsListingHandler extends AbstractHttpHandler {

		@Override
		protected String processQuery(Map<String, String> httpQuery) throws IllegalArgumentException {
			JsonArray subjectsJsonArray = new JsonArray();
			for (Subject subject : Subject.values()) {
				JsonObject subjectJsonObject = new JsonObject();
				subjectJsonObject.addProperty("id", subject.name());
				subjectJsonObject.addProperty("name", subject.getName());
				subjectJsonObject.addProperty("subject_area", subject.getSubjectArea().getName());

				subjectsJsonArray.add(subjectJsonObject);
			}

			return subjectsJsonArray.toString();
		}

	}
	
	
	private static class DutyDaysListingHandler extends AbstractHttpHandler {

		@Override
		protected String processQuery(Map<String, String> httpQuery) throws IllegalArgumentException {
			JsonArray dutyDaysJsonArray = new JsonArray();
			for (DutyDay dutyDay : DutyDay.values()) {
				JsonObject dutyDayJsonObject = new JsonObject();
				dutyDayJsonObject.addProperty("id", dutyDay.name());
				dutyDayJsonObject.addProperty("name", dutyDay.getName());
				
				dutyDaysJsonArray.add(dutyDayJsonObject);
			}

			return dutyDaysJsonArray.toString();
		}

	}

}
