package org.peddie.peer_tutoring.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.peddie.peer_tutoring.model.Dorm;
import org.peddie.peer_tutoring.model.DutyDay;
import org.peddie.peer_tutoring.model.Subject;
import org.peddie.peer_tutoring.model.Tutor;

/**
 * A database just for debugging purposes.
 * 
 * @author jiehan
 *
 */
public class CheatingDatabase implements Database {

	@Override
	public Set<Tutor> getTutors() {
		Set<Tutor> tutors = new HashSet<Tutor>();
		
		tutors.add(new Tutor("Tutor1", "t1", Dorm.CASPERSEN, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.MONDAY, DutyDay.TUESDAY)),
				new HashSet<Subject>(Arrays.asList(Subject.CHINESE, Subject.COMPSCI))));

		tutors.add(new Tutor("Tutor2", "t2", Dorm.POTTER_SOUTH, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.MONDAY, DutyDay.WEDNESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.CHINESE, Subject.CHEMISTRY))));

		tutors.add(new Tutor("Tutor3", "t3", Dorm.COLEMAN, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.MONDAY, DutyDay.THURSDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.CHINESE, Subject.COMPSCI))));

		tutors.add(new Tutor("Tutor4", "t4", Dorm.COLEMAN, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.MONDAY, DutyDay.THURSDAY)),  
				new HashSet<Subject>(Arrays.asList(Subject.COMPSCI))));

		tutors.add(new Tutor("Tutor5", "t5", Dorm.COLEMAN, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.THURSDAY)),  
				new HashSet<Subject>(Arrays.asList(Subject.CHINESE, Subject.COMPSCI))));
		
		return tutors;
	}

}
