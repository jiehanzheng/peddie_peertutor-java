package org.peddie.peer_tutoring.model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.gson.annotations.SerializedName;

/**
 * @author jiehan
 *
 */
@SuppressWarnings("unused")
public class Tutor {
	
	private static transient Map<Tutor, Boolean> pictureExistence = new HashMap<Tutor, Boolean>(); 

	private String name;
	private Set<Dorm> dorms;
	private Set<DutyDay> dutyDays;
	private String emailPrefix;
	private Set<Subject> subjects;
	
	public Tutor(String name, String emailPrefix, Dorm dorm, Set<DutyDay> dutyDays, Set<Subject> subjects) {
		this(name, emailPrefix, new HashSet<Dorm>(Arrays.asList(dorm)), dutyDays, subjects);
	}

	public Tutor(String name, String emailPrefix, Set<Dorm> dorms, Set<DutyDay> dutyDays, Set<Subject> subjects) {
		this.name = name;
		this.emailPrefix = emailPrefix;
		this.dorms = dorms;
		this.dutyDays = dutyDays;
		this.subjects = subjects;
	}

	public String toString() {
		return "Tutor(name=" + name + ", dorms=" + dorms + ", dutyDays=" + dutyDays + 
				", emailPrefix=" + emailPrefix + ", subjects=" + subjects + ")";
	}

	public String getName() {
		return name;
	}

	public Set<Dorm> getDorms() {
		return dorms;
	}

	public Set<DutyDay> getDutyDays() {
		return dutyDays;
	}
	
	public String getEmailPrefix() {
		return emailPrefix;
	}

	public String getEmail() {
		return emailPrefix == null ? null : emailPrefix + "@peddie.org";
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}
	
	public boolean hasPicture() {
		// look at cached results first, in order to prevent disk IO
		if (!pictureExistence.containsKey(this)) {
			System.err.println(getEmailPrefix() + "'s picture status was not cached.  Checking...");
			
			String webProjectLocation = System.getenv("PEERTUTOR_WEB_FOLDER");
			if (webProjectLocation == null)
				throw new RuntimeException("Environment variable PEERTUTOR_WEB_FOLDER was not set.");
			
			Path tutorPicturesPath = Paths.get(webProjectLocation).resolve("images").resolve("tutors");
			Boolean pictureExists = Files.exists(tutorPicturesPath.resolve(getEmailPrefix() + ".jpg"));
			pictureExistence.put(this, pictureExists);
		}
		
		return pictureExistence.get(this);
	}

}
