package org.peddie.peer_tutoring.model;

import java.util.Set;

public class Tutor {
	
	// TODO: implement duty nights!
	
	private String name;
	private Dorm dorm;
	private String phoneNumber;
	private String email;
	private Set<Subject> subjects;

	public Tutor(String name, Dorm dorm, String phoneNumber, String email, Set<Subject> subjects) {
		this.name = name;
		this.dorm = dorm;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.subjects = subjects;
	}

	public String toString() {
		// TODO: print all fields
		return "Tutor(name=" + name + ", dorm=" + dorm + ", phoneNumber=" + phoneNumber + 
				", email=" + email + ", subjects=" + subjects + ")";
	}
	
	public Set<Subject> getSubjects() {
		return subjects;
	}
	
	public Dorm getDorm() {
		return dorm;
	}
	
}
