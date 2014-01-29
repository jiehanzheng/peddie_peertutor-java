package org.peddie.peer_tutoring.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.peddie.peer_tutoring.model.Dorm;
import org.peddie.peer_tutoring.model.Query;
import org.peddie.peer_tutoring.model.ScoredTutor;
import org.peddie.peer_tutoring.model.Tutor;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

/**
 * @author jiehan
 *
 */
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

		// find out tutors whose subject match first
		for (Tutor tutor : tutors) {
			if ((query.getSubject() == null || tutor.getSubjects().contains(query.getSubject()))
					&& (query.getDutyDay() == null || tutor.getDutyDays().contains(query.getDutyDay()))) {
				double score;
				if (query.getDorm() != null) {
					final Dorm queriedDorm = query.getDorm();
					score = Collections.max(Collections2.transform(tutor.getDorms(), new Function<Dorm, Double>() {
						@Override
						public Double apply(Dorm dorm) {
							return 1 / (dorm.distanceTo(queriedDorm) + 1);
						}
					}));
				} else {
					score = 0;
				}

				scoredTutors.add(new ScoredTutor(tutor, score));
			}
		}

		return scoredTutors;
	}

}
