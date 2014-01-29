package org.peddie.peer_tutoring.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.peddie.peer_tutoring.model.Dorm;
import org.peddie.peer_tutoring.model.DutyDay;
import org.peddie.peer_tutoring.model.Subject;
import org.peddie.peer_tutoring.model.Tutor;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TutorSerializer implements JsonSerializer<Tutor> {

	@Override
	public JsonElement serialize(Tutor src, Type typeOfSrc,	JsonSerializationContext context) {
		JsonObject tutorJson = new JsonObject();

		// the easy ones
		tutorJson.addProperty("name", src.getName());
		tutorJson.addProperty("email_prefix", src.getEmailPrefix());
		tutorJson.addProperty("has_picture", src.hasPicture());

		Gson gson = new Gson();

		// get dorms, store it then sort it
		List<Subject> subjects = new ArrayList<Subject>(src.getSubjects());
		Collections.sort(subjects);
		tutorJson.add("subjects", gson.toJsonTree(subjects));

		// get subjects, store it then sort it
		List<Dorm> dorms = new ArrayList<Dorm>(src.getDorms());
		Collections.sort(dorms);
		tutorJson.add("dorms", gson.toJsonTree(dorms));

		// get duty days, store it then sort it
		List<DutyDay> dutyDays = new ArrayList<DutyDay>(src.getDutyDays());
		Collections.sort(dutyDays);
		tutorJson.add("duty_days", gson.toJsonTree(dutyDays));

		return tutorJson;
	}

}
