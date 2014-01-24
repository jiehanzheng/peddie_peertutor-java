package org.peddie.peer_tutoring.util;

import java.nio.file.Path;
import java.util.Set;

import org.peddie.peer_tutoring.model.Tutor;

public class JsonDatabase implements Database {
	
	private Path dataDirectory;
	
	public JsonDatabase(Path dataDirectory) {
		this.dataDirectory = dataDirectory;
	}

	@Override
	public Set<Tutor> getTutors() {
		
		return null;
	}

}
