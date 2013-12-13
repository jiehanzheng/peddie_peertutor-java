package org.peddie.peer_tutoring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.peddie.peer_tutoring.model.Dorm;
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
		System.err.println("Working on query: " + query);

		List<ScoredTutor> scoredTutors = new ArrayList<ScoredTutor>();
		double score;
		double standardScore = Dorm.ROBERSON.distanceTo(Dorm.POTTER_NORTH);

		// find out tutors whose subject match
		for (Tutor tutor : tutors) {
			if (tutor.getSubjects().contains(query.getSubject())) {
				score = 100 - tutor.getDorm().distanceTo(query.getDorm())*100 / standardScore ;
				System.out.println(score);
				scoredTutors.add(new ScoredTutor(tutor, score)); //problem
			}
		}

		return scoredTutors;
	}

}
