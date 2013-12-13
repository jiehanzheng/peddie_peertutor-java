package org.peddie.peer_tutoring.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.peddie.peer_tutoring.model.Dorm;
import org.peddie.peer_tutoring.model.Subject;
import org.peddie.peer_tutoring.model.Tutor;

public class CheatingDatabase implements Database {

	@Override
	public Set<Tutor> getTutors() {
		Set<Tutor> tutors = new HashSet<Tutor>();
		tutors.add(new Tutor("Math guy", Dorm.POTTER_SOUTH, "", "", new HashSet<Subject>(Arrays.asList(Subject.CHINESE, Subject.MATHS))));
		tutors.add(new Tutor("CompSci guy", Dorm.POTTER_SOUTH, "", "", new HashSet<Subject>(Arrays.asList(Subject.COMPSCI, Subject.CHINESE))));
		tutors.add(new Tutor("Chemistry guy", Dorm.POTTER_SOUTH, "", "", new HashSet<Subject>(Arrays.asList(Subject.CHINESE, Subject.CHEMISTRY))));
		
		return tutors;
	}

}
