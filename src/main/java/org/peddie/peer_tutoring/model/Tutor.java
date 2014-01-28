package org.peddie.peer_tutoring.model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import com.google.gson.annotations.SerializedName;

/**
 * @author jiehan
 *
 */
@SuppressWarnings("unused")
public class Tutor {

	private String name;
	private Dorm dorm;
	private Set<DutyDay> dutyDays;
	private String emailPrefix;
	private Set<Subject> subjects;

	public Tutor(String name, String emailPrefix, Dorm dorm, Set<DutyDay> dutyDays, Set<Subject> subjects) {
		this.name = name;
		this.emailPrefix = emailPrefix;
		this.dorm = dorm;
		this.dutyDays = dutyDays;
		this.subjects = subjects;
	}

	public String toString() {
		return "Tutor(name=" + name + ", dorm=" + dorm + ", dutyDays=" + dutyDays + 
				", emailPrefix=" + emailPrefix + ", subjects=" + subjects + ")";
	}

	public String getName() {
		return name;
	}

	public Dorm getDorm() {
		return dorm;
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
		String webProjectLocation = System.getenv("PEERTUTOR_WEB_FOLDER");
		if (webProjectLocation == null)
			throw new RuntimeException("Environment variable PEERTUTOR_WEB_FOLDER was not set.");
		
		Path tutorPicturesPath = Paths.get(webProjectLocation).resolve("images").resolve("tutors");
		return Files.exists(tutorPicturesPath.resolve(getEmailPrefix() + ".jpg"));
	}

}
