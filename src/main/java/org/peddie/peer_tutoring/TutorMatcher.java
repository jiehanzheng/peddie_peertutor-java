package org.peddie.peer_tutoring;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.peddie.peer_tutoring.model.Query;
import org.peddie.peer_tutoring.model.ScoredTutor;
import org.peddie.peer_tutoring.model.Tutor;

public class TutorMatcher {
	
	private final Set<Tutor> tutors;
	
	public TutorMatcher(Set<Tutor> tutors) {
		this.tutors = tutors;
	}

	/**
	 * Runs a query.
	 * 
	 * <p>
	 * Assigns scores to some of or all the tutors, and returns top five 
	 * matches.
	 * </p>
	 * <p>
	 * Factors taken into account should include:
	 * </p>
	 * <ul>
	 * <li>Subject
	 * <li>Tutor's availability (duty nights)
	 * <li>Physical distance between dorm in query and the tutor's dorm
	 * </ul>
	 * 
	 * @param query the query to run
	 * @return top five 
	 */
	public List<ScoredTutor> runQuery(Query query) {
		List<ScoredTutor> scoredTutors = new ArrayList<ScoredTutor>();
		
		// FIXME(adam): dummy code -- implement this!
		for (Tutor tutor : tutors) {
			scoredTutors.add(new ScoredTutor(tutor, 0));
		}
		
		return scoredTutors;
	}
	
}
