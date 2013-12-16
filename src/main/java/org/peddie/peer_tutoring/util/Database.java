package org.peddie.peer_tutoring.util;

import java.util.Set;

import org.peddie.peer_tutoring.model.Tutor;

/**
 * @author jiehan
 *
 */
public interface Database {
	
	public Set<Tutor> getTutors();

}
