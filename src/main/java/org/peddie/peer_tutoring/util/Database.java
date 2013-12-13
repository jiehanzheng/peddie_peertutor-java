package org.peddie.peer_tutoring.util;

import java.nio.file.Path;
import java.util.List;

import org.peddie.peer_tutoring.model.Tutor;

public class Database {
	
	private static final String TUTORS_FILE = "tutors.json";
	
	private Path dataDirectory;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public Database(Path dataDirectory) {
		this.dataDirectory = dataDirectory;
	}
	
	public List<Tutor> getTutors() {
		// TODO(adam)
		// java nio read directory (list files in a directory)
		// read file to string
		// deserialize using Gson (JSON format)
		// return List<Tutor>
		
		throw new UnsupportedOperationException("Adam has not implemented this yet");
	}

}
