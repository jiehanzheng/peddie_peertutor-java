package org.peddie.peer_tutoring.model;

import java.util.Set;

/**
 * @author jiehan
 *
 */
public class Tutor {

	private String name;
	private Dorm dorm;
	private Set<DutyDay> dutyDays;
	private String emailPrefix;
	private Set<Subject> subjects;

	public Tutor(String name, Dorm dorm, Set<DutyDay> dutyDays, String emailPrefix, Set<Subject> subjects) {
		this.name = name;
		this.dorm = dorm;
		this.dutyDays = dutyDays;
		this.emailPrefix = emailPrefix;
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
