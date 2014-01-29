package org.peddie.peer_tutoring.model;

/**
 * @author jiehan
 *
 */
public enum Subject {
	
	// math subjects
	ALGEBRA          ("Algebra", SubjectArea.MATH),
	GEOMETRY         ("Geometry", SubjectArea.MATH),
	PRE_CALCULUS     ("Pre-Calculus", SubjectArea.MATH),
	CALCULUS         ("Calculus", SubjectArea.MATH),
	CALCULUS_AB      ("AP Calculus AB", SubjectArea.MATH),
	CALCULUS_BC      ("AP Calculus BC", SubjectArea.MATH),
	STATS            ("Statistics", SubjectArea.MATH),
	AP_STATS         ("AP Statistics", SubjectArea.MATH),
	COMPSCI          ("Computer Science", SubjectArea.MATH),
	ECON             ("Economics", SubjectArea.MATH),
	
	// science subjects
	CHEMISTRY        ("Chemistry", SubjectArea.SCIENCE),
	BIOLOGY          ("Biology", SubjectArea.SCIENCE),
	PHYSICS          ("Physics", SubjectArea.SCIENCE),
//	PSYCHOLOGY       ("Psychology", SubjectArea.SCIENCE),
	
	// history subjects
	HISTORY_10       ("Modern Global History", SubjectArea.HISTORY),
	US_HISTORY       ("US History", SubjectArea.HISTORY),
	AP_USH           ("AP US History", SubjectArea.HISTORY),
//	AP_GOV           ("AP US Government", SubjectArea.HISTORY),
	
	// language subject: in alphabetical order
	CHINESE          ("Chinese", SubjectArea.LANGUAGE),
	FRENCH_2         ("French 1/2", SubjectArea.LANGUAGE),
	FRENCH_3_4       ("French 3+", SubjectArea.LANGUAGE),
//	LATIN            ("Latin", SubjectArea.LANGUAGE),
	SPANISH_2        ("Spanish 1/2", SubjectArea.LANGUAGE),
	SPANISH_3        ("Spanish 3", SubjectArea.LANGUAGE),
	SPANISH_4        ("Spanish 4", SubjectArea.LANGUAGE),
	
	// english department
	ENGLISH          ("English", SubjectArea.ENGLISH),
	
	// standardized test
	ACT              ("ACT", SubjectArea.STD_TEST),
	SAT              ("SAT", SubjectArea.STD_TEST);
	
	private String name;
	private SubjectArea subjectArea;
	
	Subject(String name, SubjectArea subjectArea) {
		this.name = name;
		this.subjectArea = subjectArea;
	}
	
	public String getName() {
		return name;
	}
	
	public SubjectArea getSubjectArea() {
		return subjectArea;
	}
	
}
