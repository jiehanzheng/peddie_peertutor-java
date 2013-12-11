package org.peddie.peer_tutoring;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.peddie.peer_tutoring.model.Dorm;
import org.peddie.peer_tutoring.model.Query;
import org.peddie.peer_tutoring.model.ScoredTutor;
import org.peddie.peer_tutoring.model.Subject;
import org.peddie.peer_tutoring.model.Tutor;

public class TutorMatcherTest {

	/**
	 * Test result structure.
	 * 
	 * <p>
	 * Given three tutors who all know Chinese and live in Potter South, if we 
	 * ask for tutors in Potter South who know Chinese, we should get exactly 
	 * three tutors in the result list.
	 * </p>
	 */
	@Test
	public final void testStructure() {
		Set<Tutor> tutors = new HashSet<Tutor>();
		tutors.add(new Tutor("Math guy", Dorm.POTTER_SOUTH, "", "", new HashSet<Subject>(Arrays.asList(Subject.CHINESE, Subject.MATHS))));
		tutors.add(new Tutor("CompSci guy", Dorm.POTTER_SOUTH, "", "", new HashSet<Subject>(Arrays.asList(Subject.COMPSCI, Subject.CHINESE))));
		tutors.add(new Tutor("Chemistry guy", Dorm.POTTER_SOUTH, "", "", new HashSet<Subject>(Arrays.asList(Subject.CHINESE, Subject.CHEMISTRY))));
		
		Query query = new Query(Subject.CHINESE, Dorm.POTTER_SOUTH);
		
		TutorMatcher tutorMatcher = new TutorMatcher(tutors);
		if (tutorMatcher.runQuery(query).size() != 3)
			fail("Number of tutors returned is incorrect");
	}
	
	/**
	 * Test if subject matches.
	 * 
	 * <p>
	 * Given a list of tutors in which only one tutor knows Chemistry, we 
	 * should not get anyone else if a Chemistry tutor is requested.
	 * </p>
	 */
	@Test
	public final void testSubject() {
		Set<Tutor> tutors = new HashSet<Tutor>();
		tutors.add(new Tutor("Math guy", Dorm.POTTER_SOUTH, "", "", new HashSet<Subject>(Arrays.asList(Subject.CHINESE, Subject.MATHS))));
		tutors.add(new Tutor("CompSci guy", Dorm.POTTER_SOUTH, "", "", new HashSet<Subject>(Arrays.asList(Subject.COMPSCI, Subject.CHINESE))));
		tutors.add(new Tutor("Chemistry guy", Dorm.POTTER_SOUTH, "", "", new HashSet<Subject>(Arrays.asList(Subject.CHINESE, Subject.CHEMISTRY))));
		
		Query query = new Query(Subject.CHEMISTRY, Dorm.POTTER_SOUTH);
		
		TutorMatcher tutorMatcher = new TutorMatcher(tutors);
		List<ScoredTutor> returnedTutors = tutorMatcher.runQuery(query);
		
		if (returnedTutors.size() == 0)
			fail("No tutors were returned.");
		
		for (ScoredTutor scoredTutor : tutorMatcher.runQuery(query)) {
			if (!scoredTutor.getTutor().getSubjects().contains(Subject.CHEMISTRY))
				fail("A tutor who doesn't know Chemistry is returned");
		}
	}
	
	/**
	 * Test if the algorithm takes into consideration of physical proximity.
	 * 
	 * <p>
	 * Given three tutors who all know the same subjects, a request from 
	 * Potter North should receive a list of tutors with a Potter South tutor
	 * on top of the list, since the two dorms are the closest.
	 * </p>
	 */
	@Test
	public final void testPhysicalProximity() {
		Set<Tutor> tutors = new HashSet<Tutor>();
		tutors.add(new Tutor("Math guy", Dorm.CASPERSEN, "", "", new HashSet<Subject>(Arrays.asList(Subject.CHINESE))));
		tutors.add(new Tutor("CompSci guy", Dorm.POTTER_SOUTH, "", "", new HashSet<Subject>(Arrays.asList(Subject.CHINESE))));
		tutors.add(new Tutor("Chemistry guy", Dorm.MARIBOE, "", "", new HashSet<Subject>(Arrays.asList(Subject.CHINESE))));
		
		Query query = new Query(Subject.CHINESE, Dorm.POTTER_NORTH);
		
		TutorMatcher tutorMatcher = new TutorMatcher(tutors);
		List<ScoredTutor> scoredTutors = tutorMatcher.runQuery(query);
		Collections.sort(scoredTutors);
		
		assertEquals("First tutor's dorm should be Potter South", Dorm.POTTER_SOUTH, scoredTutors.get(0).getTutor().getDorm());
		assertTrue("Second tutor should have a score lower than the first", scoredTutors.get(0).getScore() > scoredTutors.get(1).getScore());
	}

}
