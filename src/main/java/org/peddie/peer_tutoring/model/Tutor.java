package org.peddie.peer_tutoring.model;

import java.util.Set;

import com.google.gson.annotations.SerializedName;

/**
 * @author jiehan
 *
 */
public class Tutor {

	private String name;
	private Dorm dorm;
	@SerializedName("duty_days") private Set<DutyDay> dutyDays;
	@SerializedName("email_prefix") private String emailPrefix;
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

	public String getEmail() {
		return emailPrefix == null ? null : emailPrefix + "@peddie.org";
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

}
