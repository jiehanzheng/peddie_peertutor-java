package org.peddie.peer_tutoring.model;

/**
 * @author jiehan
 *
 */
public enum DutyDay {
	
	MONDAY    ("Monday"),
	TUESDAY   ("Tuesday"),
	WEDNESDAY ("Wednesday"),
	THURSDAY  ("Thursday"),
	FRIDAY    ("Friday"),
	SUNDAY    ("Sunday");
	
	
	private String name;
	
	DutyDay(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
