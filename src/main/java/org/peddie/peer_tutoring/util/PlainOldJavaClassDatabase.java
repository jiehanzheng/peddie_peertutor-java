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

		tutors.add(new Tutor("Brett Clancy", "bclancy-14", Dorm.AVERY /* FIXME */, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.FRIDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.ALGEBRA, Subject.CALCULUS_AB, Subject.SPANISH_2))));
		
		tutors.add(new Tutor("Chuanzhe Meng", "cmeng-15", Dorm.MARIBOE, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.THURSDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.ALGEBRA, Subject.CALCULUS_AB, Subject.CALCULUS_BC, Subject.COMPSCI, Subject.CHINESE))));
		
		tutors.add(new Tutor("Danielle Blick", "dblick-14", Dorm.AVERY /* FIXME */, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.TUESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.ALGEBRA, Subject.AP_USH, Subject.SPANISH_2, Subject.SPANISH_3, Subject.HISTORY_10))));
		
		tutors.add(new Tutor("Isabella Perera", "iperera-15", Dorm.MASTERS_NORTH, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.MONDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.BIOLOGY, Subject.SPANISH_2, Subject.HISTORY_10))));
		
		tutors.add(new Tutor("Jiehan Zheng", "jzheng-14", Dorm.POTTER_SOUTH, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.WEDNESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.CHINESE, Subject.COMPSCI))));
		
		tutors.add(new Tutor("Jonathan Karch", "jkarch-14", Dorm.AUSTIN_COLGATE, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.WEDNESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.HISTORY_10, Subject.US_HISTORY, Subject.AP_USH, Subject.ENGLISH, Subject.PRE_CALCULUS))));
		
		tutors.add(new Tutor("Katcia Perryman", "kperryman-15", Dorm.POTTER_NORTH, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.MONDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.BIOLOGY, Subject.SPANISH_2, Subject.SPANISH_3))));
		
		tutors.add(new Tutor("Lauren Donato", "ldonato-15", Dorm.AVERY /* FIXME */, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.TUESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.BIOLOGY, Subject.ENGLISH))));
		
		tutors.add(new Tutor("Michael King", "mking-15", Dorm.COLEMAN, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.FRIDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.CHEMISTRY, Subject.PRE_CALCULUS, Subject.CHINESE))));
		
		tutors.add(new Tutor("Michelle Hung", "mhung-14", Dorm.AVERY, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.WEDNESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.BIOLOGY, Subject.AP_USH, Subject.FRENCH))));
		
		tutors.add(new Tutor("Brabeeba Mien Wang", "mwang-14", Dorm.POTTER_SOUTH, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.THURSDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.PHYSICS, Subject.BIOLOGY, Subject.ALGEBRA, Subject.GEOMETRY, Subject.PRE_CALCULUS, Subject.CALCULUS_AB, Subject.CALCULUS_BC))));
		
		tutors.add(new Tutor("Richard Jin", "rjin-14", Dorm.AVERY /* FIXME */, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.TUESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.SAT, Subject.FRENCH))));
		
		tutors.add(new Tutor("Scout Sabo", "ssabo-14", Dorm.AVERY, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.THURSDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.FRENCH, Subject.PHYSICS, Subject.ALGEBRA, Subject.GEOMETRY, Subject.PRE_CALCULUS, Subject.ENGLISH))));
		
		tutors.add(new Tutor("Shivani Gupta", "sgupta-15", Dorm.AVERY /* FIXME */, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.FRIDAY)), 
				new HashSet<Subject>()));
		
		tutors.add(new Tutor("Blink Sirawit Woramongkhon", "sworamongkhon-14", Dorm.POTTER_SOUTH, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.WEDNESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.ALGEBRA, Subject.GEOMETRY, Subject.PRE_CALCULUS, Subject.CALCULUS_AB, Subject.CALCULUS_BC, Subject.PHYSICS, Subject.CHEMISTRY))));
		
		tutors.add(new Tutor("Sophie Spears", "sspears-14", Dorm.POTTER_NORTH, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.THURSDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.STATS, Subject.AP_STATS, Subject.AP_USH, Subject.ENGLISH))));
		
		tutors.add(new Tutor("Yuhuan Zhou", "yzhou-15", Dorm.AVERY, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.WEDNESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.CHEMISTRY, Subject.ALGEBRA, Subject.GEOMETRY, Subject.PRE_CALCULUS, Subject.CALCULUS_AB, Subject.CALCULUS_BC, Subject.CHINESE))));
		
		tutors.add(new Tutor("Jacky Ziwen Jiang", "zjiang-14", Dorm.POTTER_SOUTH, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.WEDNESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.CHEMISTRY, Subject.BIOLOGY, Subject.PHYSICS, Subject.ALGEBRA, Subject.GEOMETRY, Subject.PRE_CALCULUS, Subject.CALCULUS_AB, Subject.CALCULUS_BC, Subject.CHINESE))));
		
		tutors.add(new Tutor("Zui Dighe", "zdighe-15", Dorm.AVERY /* FIXME */, 
				new HashSet<DutyDay>(Arrays.asList(DutyDay.TUESDAY)), 
				new HashSet<Subject>(Arrays.asList(Subject.BIOLOGY, Subject.ALGEBRA, Subject.GEOMETRY, Subject.PRE_CALCULUS, Subject.CALCULUS_AB, Subject.CALCULUS_BC, Subject.SPANISH_2, Subject.SPANISH_3, Subject.SPANISH_4, Subject.AP_SPANISH))));

		
		return tutors;
	}

}
