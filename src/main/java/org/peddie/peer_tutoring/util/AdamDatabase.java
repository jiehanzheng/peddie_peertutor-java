package org.peddie.peer_tutoring.util;

import java.nio.file.Path;
import java.util.Set;

import org.peddie.peer_tutoring.model.Tutor;

/**
 * @author adam
 *
 */
public class AdamDatabase {
	
	private static final String TUTORS_FOLDER = "tutors";
	private Path dataDirectory;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public AdamDatabase(Path dataDirectory) {
		this.dataDirectory = dataDirectory;
	}
	
	public Set<Tutor> getTutors() {
		// TODO(adam)
		throw new UnsupportedOperationException("Adam has not implemented this yet");
	}

}
