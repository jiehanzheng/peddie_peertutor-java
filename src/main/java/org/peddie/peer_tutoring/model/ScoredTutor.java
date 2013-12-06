package org.peddie.peer_tutoring.model;

/**
 * A wrapper for {@link Tutor} that allows for the inclusion of meta info
 * like a score for a give tutor.
 * 
 * <p>
 * Score should be a number between 0 and 1 inclusive, indicating how well
 * a given tutor matches a given {@link Query}.
 * </p>
 * 
 * @author jiehan
 *
 */
public class ScoredTutor {

	private Tutor tutor;
	private double score;
	
	public ScoredTutor(Tutor tutor, double score) {
		this.tutor = tutor;
		this.score = score;
	}
	
	public double getScore() {
		return score;
	}
	
}
