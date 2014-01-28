package org.peddie.peer_tutoring.model;

public enum LocationType {
	
	DORM  ("Dormitories"),
	OTHER ("Other");
	
	private String name;
	
	LocationType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
