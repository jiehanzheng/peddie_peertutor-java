package org.peddie.peer_tutoring.model;

public class Tutor {
	
	// TODO: implement duty nights!
	
	private String name;
	private String dorm;
	private String phoneNumber;
	private String email;

	public Tutor(String name, String dorm, String phoneNumber, String email, Float score) {
		this.name = name;
		this.dorm = dorm;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String toString() {
		// TODO: print all fields
		return "Tutor(name=" + name + ")";
	}
	
}
