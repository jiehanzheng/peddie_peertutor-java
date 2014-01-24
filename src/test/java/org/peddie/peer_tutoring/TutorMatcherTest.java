package org.peddie.peer_tutoring;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.peddie.peer_tutoring.model.Dorm;
import org.peddie.peer_tutoring.model.DutyDay;
import org.peddie.peer_tutoring.model.Query;
import org.peddie.peer_tutoring.model.ScoredTutor;
import org.peddie.peer_tutoring.model.Subject;
import org.peddie.peer_tutoring.model.Tutor;
import org.peddie.peer_tutoring.util.CheatingDatabase;
import org.peddie.peer_tutoring.util.Database;

/**
 * @author jiehan
 *
 */
public class TutorMatcherTest {

	private static Set<Tutor> tutors = new HashSet<Tutor>();

	@BeforeClass
	public final static void setUpTutors() {
		Database database = new CheatingDatabase();
		tutors = database.getTutors();
		System.err.println(tutors);
	}

	/**
	 * Tests result structure.
	 * 
	 * <p>
	 * If an empty query was given, the entire list of tutors should be 
	 * returned.
	 * </p>
	 */
	@Test
	public final void testEmptyQuery() {
		Query query = new Query(null, null, null);

		TutorMatcher tutorMatcher = new TutorMatcher(tutors);
		assertEquals("Number of tutors returned is incorrect.", tutorMatcher.runQuery(query).size(), tutors.size());
	}

	/**
	 * Tests if subject matches.
	 * 
	 * <p>
	 * Sees if there are any extraneous output if we ask for only Chemistry 
	 * tutors.
	 * </p>
	 */
	@Test
	public final void testOnlySubject() {
		Query query = new Query(Subject.CHEMISTRY, null, null);

		TutorMatcher tutorMatcher = new TutorMatcher(tutors);
		List<ScoredTutor> scoredTutors = tutorMatcher.runQuery(query);

		// # expected tutor = # on duty on Monday
		int numberOfExpectedTutors = 0;
		for (Tutor tutor : tutors) {
			if (tutor.getSubjects().contains(Subject.CHEMISTRY))
				numberOfExpectedTutors++;
		}

		assertEquals("Method did not return the correct number of tutors.", numberOfExpectedTutors, scoredTutors.size());

		for (ScoredTutor scoredTutor : scoredTutors) {
			assertTrue("A tutor who doesn't know Chemistry was returned.", scoredTutor.getTutor().getSubjects().contains(Subject.CHEMISTRY));
		}
	}

	/**
	 * Tests if the algorithm handles sorting by dorm if subject and duty day
	 * are null.
	 * 
	 * <p>
	 * In this case your method should return all the tutors, regardless of 
	 * their dorms or duty nights, and compute score based on distance.
	 * </p>
	 */
	@Test
	public final void testOnlyDorm() {
		Query query = new Query(null, Dorm.POTTER_NORTH, null);

		TutorMatcher tutorMatcher = new TutorMatcher(tutors);
		List<ScoredTutor> scoredTutors = tutorMatcher.runQuery(query);
		Collections.sort(scoredTutors);
		Collections.reverse(scoredTutors);

		assertEquals("Method should not remove any tutors.", tutors.size(), scoredTutors.size());
		assertEquals("First tutor's dorm should be Potter South.", Dorm.POTTER_SOUTH, scoredTutors.get(0).getTutor().getDorm());
		assertTrue("Second tutor should have a score lower than the first.", scoredTutors.get(0).getScore() > scoredTutors.get(1).getScore());
	}

	/**
	 * Tests if the algorithm handles duty nights correctly.
	 * 
	 * <p>
	 * Duty nights must match exactly.
	 * </p>
	 */
	@Test
	public final void testOnlyDutyDay() {
		Query query = new Query(null, null, DutyDay.MONDAY);

		TutorMatcher tutorMatcher = new TutorMatcher(tutors);
		List<ScoredTutor> scoredTutors = tutorMatcher.runQuery(query);

		// # expected tutor = # on duty on Monday
		int numberOfExpectedTutors = 0;
		for (Tutor tutor : tutors) {
			if (tutor.getDutyDays().contains(DutyDay.MONDAY))
				numberOfExpectedTutors++;
		}

		for (ScoredTutor scoredTutor : scoredTutors) {
			assertTrue("A tutor who is not on duty on Monday was returned.", scoredTutor.getTutor().getDutyDays().contains(DutyDay.MONDAY));
		}

		assertEquals("Method did not return the correct number of tutors.", numberOfExpectedTutors, scoredTutors.size());
	}

	/**
	 * Tests if the algorithm takes into consideration of subject and physical 
	 * proximity.
	 * 
	 */
	@Test
	public final void testSubjectAndDorm() {
		Query query = new Query(Subject.CHINESE, Dorm.POTTER_NORTH, null);

		TutorMatcher tutorMatcher = new TutorMatcher(tutors);
		List<ScoredTutor> scoredTutors = tutorMatcher.runQuery(query);
		Collections.sort(scoredTutors);
		Collections.reverse(scoredTutors);

		// # expected tutor = # know chinese
		int numberOfExpectedTutors = 0;
		for (Tutor tutor : tutors) {
			if (tutor.getSubjects().contains(Subject.CHINESE))
				numberOfExpectedTutors++;
		}

		for (ScoredTutor scoredTutor : scoredTutors) {
			if (!scoredTutor.getTutor().getSubjects().contains(Subject.CHINESE))
				fail("A tutor who does not know Chinese was returned.");
		}

		assertEquals("Method did not return the correct number of tutors.", numberOfExpectedTutors, scoredTutors.size());
		assertEquals("First tutor's dorm should be Potter South.", Dorm.POTTER_SOUTH, scoredTutors.get(0).getTutor().getDorm());
		assertTrue("Second tutor should have a score lower than the first.", scoredTutors.get(0).getScore() > scoredTutors.get(1).getScore());
	}

	/**
	 * Tests subject, dorm and duty night.
	 * 
	 */
	@Test
	public final void testSubjectAndDormAndDutyNight() {
		Query query = new Query(Subject.CHINESE, Dorm.POTTER_NORTH, DutyDay.MONDAY);

		TutorMatcher tutorMatcher = new TutorMatcher(tutors);
		List<ScoredTutor> scoredTutors = tutorMatcher.runQuery(query);
		Collections.sort(scoredTutors);
		Collections.reverse(scoredTutors);

		// # expected tutor = # know chinese && on duty on monday
		int numberOfExpectedTutors = 0;
		for (Tutor tutor : tutors) {
			if (tutor.getSubjects().contains(Subject.CHINESE) && tutor.getDutyDays().contains(DutyDay.MONDAY))
				numberOfExpectedTutors++;
		}

		for (ScoredTutor scoredTutor : scoredTutors) {
			assertTrue("A tutor who does not know Chinese was returned.", scoredTutor.getTutor().getSubjects().contains(Subject.CHINESE));
			assertTrue("A tutor who is not on duty on Monday was returned.", scoredTutor.getTutor().getDutyDays().contains(DutyDay.MONDAY));
		}

		assertEquals("Method did not return the correct number of tutors.", numberOfExpectedTutors, scoredTutors.size());
		assertEquals("First tutor's dorm should be Potter South.", Dorm.POTTER_SOUTH, scoredTutors.get(0).getTutor().getDorm());
		assertTrue("Second tutor should have a score lower than the first.", scoredTutors.get(0).getScore() > scoredTutors.get(1).getScore());
	}

}
