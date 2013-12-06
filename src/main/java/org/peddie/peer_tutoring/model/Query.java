package org.peddie.peer_tutoring.model;

/**
 * Container for a query from the interface.  This class includes information 
 * like the student's dorm, subject, and desired date.
 *
 */
public class Query {

	// TODO: implement duty nights
	
	private String subject;
	private Dorm dorm;

	public Query(String subject, Dorm dorm) {
		this.subject = subject;
		this.dorm = dorm;
	}
	
	/**
	 * Runs the query.
	 * 
	 * Read tutor information from 
	 * {@link org.peddie.peer_tutoring.util.Database} class and assign score to 
	 * some or all of the tutors, and return top five matches.
	 * 
	 * <p>
	 * Factors taken into account must include:
	 * </p>
	 * 
	 * <ul>
	 * <li>Subject
	 * <li>Tutor's availability (duty nights)
	 * <li>Physical distance between dorm in this query and tutor's dorm
	 * </ul>
	 * 
	 * @return a Result object that contains a list of 5 tutors in order of relevance
	 */
	public Result run() {
		// TODO(adam): return a Result that contains a list of tutors
		return null;
	}

	public String toString() {
		return "Query(subject=" + subject + ", dorm=" + dorm + ")";
	}
	
}
