package org.peddie.peer_tutoring.model;

/**
 * A wrapper for {@link Tutor} that allows for the inclusion of meta info
 * like a score for a give tutor.
 * 
 * <p>
 * Score should be greater than zero, and indicate how well a given tutor matches a given {@link Query}.
 * 
 * </p>
 * 
 * @author jiehan
 *
 */
public class ScoredTutor implements Comparable<ScoredTutor> {

	private Tutor tutor;
	private Double score;
	
	public ScoredTutor(Tutor tutor, double score) {
		this.tutor = tutor;
		this.score = score;
	}
	
	public Double getScore() {
		return score;
	}
	
	public Tutor getTutor() {
		return tutor;
	}

	public int compareTo(ScoredTutor o) {
		return getScore().compareTo(o.getScore());
	}
	
	public String toString() {
		return tutor.toString() + " (" + score + ")";
	}
	
}
