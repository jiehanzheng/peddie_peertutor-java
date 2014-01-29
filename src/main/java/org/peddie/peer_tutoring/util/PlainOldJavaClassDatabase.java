package org.peddie.peer_tutoring.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.peddie.peer_tutoring.model.Dorm;
import org.peddie.peer_tutoring.model.DutyDay;
import org.peddie.peer_tutoring.model.Subject;
import org.peddie.peer_tutoring.model.Tutor;

/**
 * A database just for debugging purposes.
 * 
 * @author jiehan
 *
 */
public class PlainOldJavaClassDatabase implements Database {

	@Override
	public Set<Tutor> getTutors() {
		Set<Tutor> tutors = new HashSet<Tutor>();
		
		tutors.add(new Tutor("Alyssa Lee", "alee-14", Dorm.AVERY, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.FRIDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.ALGEBRA, Subject.CALCULUS_AB, Subject.CALCULUS_BC))));
		
		// updated
		tutors.add(new Tutor("Tomo Cho", "tcho-14", Dorm.COLEMAN, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.MONDAY, DutyDay.WEDNESDAY, DutyDay.THURSDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.ACT, Subject.BIOLOGY, Subject.CALCULUS_AB))));
		
		// updated
		tutors.add(new Tutor("Brett Clancy", "bclancy-14", Dorm.LIBRARY, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.TUESDAY, DutyDay.FRIDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.ALGEBRA, Subject.PRE_CALCULUS, Subject.CALCULUS, Subject.CALCULUS_AB, Subject.COMPSCI, Subject.CHEMISTRY, Subject.PHYSICS, Subject.SPANISH_2, Subject.SPANISH_3, Subject.ACT))));
		
		tutors.add(new Tutor("Chuanzhe Meng", "cmeng-15", Dorm.MARIBOE, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.THURSDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.ALGEBRA, Subject.CALCULUS_AB, Subject.CALCULUS_BC, Subject.COMPSCI, Subject.CHINESE))));
		
		tutors.add(new Tutor("Danielle Blick", "dblick-14", Dorm.LIBRARY, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.TUESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.ALGEBRA, Subject.AP_USH, Subject.SPANISH_2, Subject.SPANISH_3, Subject.HISTORY_10))));
		
		tutors.add(new Tutor("Isabella Perera", "iperera-15", Dorm.MASTERS_NORTH, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.MONDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.BIOLOGY, Subject.SPANISH_2, Subject.HISTORY_10))));
		
		tutors.add(new Tutor("Jiehan Zheng", "jzheng-14", Dorm.POTTER_SOUTH, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.MONDAY, DutyDay.THURSDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.CHINESE, Subject.COMPSCI))));
		
		// updated
		tutors.add(new Tutor("Colton Karch", "jkarch-14", Dorm.AUSTIN_COLGATE, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.MONDAY, DutyDay.WEDNESDAY, DutyDay.SUNDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.HISTORY_10, Subject.US_HISTORY, Subject.AP_USH, Subject.ENGLISH, Subject.ALGEBRA, Subject.GEOMETRY, Subject.PRE_CALCULUS, Subject.SPANISH_2, Subject.SPANISH_3))));
		
		// updated
		tutors.add(new Tutor("Kai Perryman", "kperryman-15", Dorm.POTTER_NORTH, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.MONDAY, DutyDay.FRIDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.SPANISH_2, Subject.SPANISH_3))));
		
		tutors.add(new Tutor("Lauren Donato", "ldonato-15", Dorm.LIBRARY, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.TUESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.BIOLOGY, Subject.ENGLISH))));
		
		tutors.add(new Tutor("Michael King", "mking-15", Dorm.COLEMAN, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.FRIDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.CHEMISTRY, Subject.PRE_CALCULUS, Subject.CHINESE))));
		
		// updated
		tutors.add(new Tutor("Michelle Hung", "mhung-14", Dorm.AVERY, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.WEDNESDAY, DutyDay.FRIDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.BIOLOGY, Subject.AP_USH, Subject.FRENCH_2, Subject.FRENCH_3_4))));
		
		// updated, pic perm ok
		tutors.add(new Tutor("Brabeeba Mien Wang", "mwang-14", Dorm.POTTER_SOUTH, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.THURSDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.ALGEBRA, Subject.GEOMETRY, Subject.PRE_CALCULUS, Subject.CALCULUS, Subject.CALCULUS_AB, Subject.CALCULUS_BC, Subject.STATS, Subject.AP_STATS, Subject.COMPSCI, Subject.ECON, Subject.CHEMISTRY, Subject.BIOLOGY, Subject.PHYSICS, Subject.CHINESE))));
		
		tutors.add(new Tutor("Richard Jin", "rjin-14", Dorm.LIBRARY, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.TUESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.SAT, Subject.FRENCH_2, Subject.FRENCH_3_4))));
		
		// updated
		tutors.add(new Tutor("Scout Sabo", "ssabo-14", Dorm.AVERY, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.THURSDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.FRENCH_2, Subject.FRENCH_3_4, Subject.PRE_CALCULUS, Subject.CALCULUS, Subject.ENGLISH))));
		
		// updated
		tutors.add(new Tutor("Shivani Gupta", "sgupta-15", Dorm.LIBRARY, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.TUESDAY, DutyDay.THURSDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.ALGEBRA, Subject.GEOMETRY, Subject.PRE_CALCULUS, Subject.FRENCH_2, Subject.CHEMISTRY))));
		
		tutors.add(new Tutor("Blink Sirawit Woramongkhon", "sworamongkhon-14", Dorm.POTTER_SOUTH, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.WEDNESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.ALGEBRA, Subject.GEOMETRY, Subject.PRE_CALCULUS, Subject.CALCULUS_AB, Subject.CALCULUS_BC, Subject.PHYSICS, Subject.CHEMISTRY))));
		
		tutors.add(new Tutor("Sophie Spears", "sspears-14", Dorm.POTTER_NORTH, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.THURSDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.STATS, Subject.AP_STATS, Subject.AP_USH, Subject.ENGLISH))));
		
		tutors.add(new Tutor("Yuhuan Zhou", "yzhou-15", Dorm.AVERY, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.WEDNESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.CHEMISTRY, Subject.ALGEBRA, Subject.GEOMETRY, Subject.PRE_CALCULUS, Subject.CALCULUS_AB, Subject.CALCULUS_BC, Subject.CHINESE))));
		
		// updated
		tutors.add(new Tutor("Jacky Ziwen Jiang", "zjiang-14", Dorm.POTTER_SOUTH, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.MONDAY, DutyDay.TUESDAY, DutyDay.THURSDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.CHEMISTRY, Subject.BIOLOGY, Subject.PHYSICS, Subject.ALGEBRA, Subject.GEOMETRY, Subject.PRE_CALCULUS, Subject.CALCULUS, Subject.CALCULUS_AB, Subject.CALCULUS_BC, Subject.CHINESE, Subject.ACT))));
		
		// updated, pic perm ok
		tutors.add(new Tutor("Zui Dighe", "zdighe-15", new HashSet<Dorm>(Arrays.asList(Dorm.LIBRARY, Dorm.MASTERS_NORTH, Dorm.MASTERS_SOUTH)), 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.TUESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.ALGEBRA, Subject.GEOMETRY, Subject.PRE_CALCULUS, Subject.CALCULUS, Subject.CALCULUS_AB, Subject.BIOLOGY, Subject.ENGLISH, Subject.SPANISH_2, Subject.SPANISH_3, Subject.SPANISH_4))));

		
		return tutors;
	}

}
