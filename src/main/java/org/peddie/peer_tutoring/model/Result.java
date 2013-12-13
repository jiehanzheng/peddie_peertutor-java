package org.peddie.peer_tutoring.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Result object that is going to be passed to the adapter.
 * 
 * @author jiehan
 *
 */
public class Result {

	private List<ScoredTutor> tutors = new ArrayList<ScoredTutor>();
	
	public Result() {}
	
	public Result(List<ScoredTutor> tutors) {
		addTutors(tutors);
	}
	
	/**
	 * Adds tutor.
	 * 
	 * This method should be called multiple times in order to add multiple 
	 * tutors.
	 * 
	 * @param tutor
	 */
	public void addTutor(ScoredTutor tutor) {
		this.tutors.add(tutor);
	}
	
	public void addTutors(List<ScoredTutor> tutors) {
		this.tutors.addAll(tutors);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (ScoredTutor tutor : tutors) {
			sb.append(tutor.toString() + "\n");
		}

		return sb.toString();        
	}

}
