package org.peddie.peer_tutoring.model;

/**
 * @author jiehan
 *
 */
public enum Subject {
	
	CHEMISTRY        ("Chemistry"),
	MATHS            ("Maths (Alg/Geo)"),
	STATS            ("Statistics"),
	PRE_CALCULUS     ("Pre-Calculus"),
	CALCULUS         ("Calculus"),
	COMPSCI          ("Computer Science"),
	HISTORY          ("History"),
	CHINESE          ("Chinese"),
	FRENCH           ("French"),
	LATIN            ("Latin"),
	SPANISH          ("Spanish"),
	ECON             ("Economics"),
	BIOLOGY          ("Biology"),
	PSYCHOLOGY       ("Psychology"),
	PHYSICS          ("Physics"),
	ENVIRONMENTAL    ("Environmental Science"),
	ENGLISH          ("English");

	
	private String name;
	
	Subject(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
