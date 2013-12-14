package org.peddie.peer_tutoring.model;


/**
 * Container for a query from the interface.  This class includes information 
 * like the student's dorm, subject, and desired date.
 *
 * @author jiehan
 */
public class Query {

	// TODO(jiehan): implement duty nights
	
	private Subject subject;
	private Dorm dorm;

	public Query(Subject subject, Dorm dorm) {
		this.subject = subject;
		this.dorm = dorm;
	}

	public String toString() {
		return "Query(subject=" + subject + ", dorm=" + dorm + ")";
	}

	public Subject getSubject() {
		return subject;
	}

	public Dorm getDorm() {
		return dorm;
	}
	
	public boolean isEmpty() {
		return subject == null && dorm == null;
	}

}
