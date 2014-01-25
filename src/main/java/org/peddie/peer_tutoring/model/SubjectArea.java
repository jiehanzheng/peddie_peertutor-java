package org.peddie.peer_tutoring.model;

public enum SubjectArea {
	
	MATH     ("Mathematics"),
	HISTORY  ("History"),
	SCIENCE  ("Science"),
	LANGUAGE ("Language"),
	ENGLISH  ("English"),
	STD_TEST ("Standardized Testing");
	
	private String name;
	
	SubjectArea(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
