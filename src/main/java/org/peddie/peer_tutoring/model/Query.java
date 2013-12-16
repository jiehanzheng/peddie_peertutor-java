package org.peddie.peer_tutoring.model;


/**
 * Container for a query from the interface.  This class includes information 
 * like the student's dorm, subject, and desired date.
 *
 * @author jiehan
 */
public class Query {

	private Subject subject;
	private Dorm dorm;
	private DutyDay dutyDay;

	public Query(Subject subject, Dorm dorm, DutyDay dutyDay) {
		this.subject = subject;
		this.dorm = dorm;
		this.dutyDay = dutyDay;
	}

	public String toString() {
		return "Query(subject=" + subject + ", dorm=" + dorm 
				+ ", dutyDay=" + dutyDay + ")";
	}

	public Subject getSubject() {
		return subject;
	}

	public Dorm getDorm() {
		return dorm;
	}

	public DutyDay getDutyDay() {
		return dutyDay;
	}

	public boolean isEmpty() {
		return subject == null && dorm == null && dutyDay == null;
	}

}
