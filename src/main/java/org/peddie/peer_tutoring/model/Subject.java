package org.peddie.peer_tutoring.model;

/**
 * @author jiehan
 *
 */
public enum Subject {
	
	ENGLISH          ("English"),
	ALGEBRA          ("Algebra 1/2"),
	GEOMETRY         ("Geometry"),
	PRE_CALCULUS     ("Pre-Calculus"),
	CALCULUS_AB      ("AP Calculus AB"),
	CALCULUS_BC      ("AP Calculus BC"),
	STATS            ("Statistics"),
	AP_STATS         ("AP Statistics"),
	COMPSCI          ("Computer Science"),
	CHEMISTRY        ("Chemistry"),
	BIOLOGY          ("Biology"),
	PHYSICS          ("Physics"),
	HISTORY_10       ("Modern Global History"),
	US_HISTORY       ("US History"),
	AP_USH           ("AP US History"),
	CHINESE          ("Chinese"),
	FRENCH           ("French"),
	SPANISH_2        ("Spanish 1/2"),
	SPANISH_3        ("Spanish 3"),
	SPANISH_4        ("Spanish 4"),
	AP_SPANISH       ("AP Spanish"),
	LATIN            ("Latin"),
	ECON             ("Economics"),
	PSYCHOLOGY       ("Psychology"),
	ROBOTICS         ("Robotics"),
	ENVIRONMENTAL    ("Environmental Science"),
	MUSIC_THEORY     ("Music Theory"),
	SAT              ("SAT");
	
	private String name;
	
	Subject(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
