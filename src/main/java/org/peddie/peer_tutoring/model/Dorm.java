package org.peddie.peer_tutoring.model;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

/**
 * @author jiehan
 *
 */
public enum Dorm {
	
	AUSTIN_COLGATE ("Austin-Colgate", new LatLng(40.264906, -74.524107)),
	AVERY          ("Avery",          new LatLng(40.265440, -74.523863)),
	CASPERSEN      ("Caspersen",      new LatLng(40.263403, -74.523788)),
	COLEMAN        ("Coleman",        new LatLng(40.265313, -74.523136)),
	KERR_NORTH     ("Kerr North",     new LatLng(40.266529, -74.523826)),
	KERR_SOUTH     ("Kerr South",     new LatLng(40.266258, -74.523890)),
	MARIBOE        ("Mariboe",        new LatLng(40.263514, -74.524435)),
	MASTERS_NORTH  ("Masters North",  new LatLng(40.264656, -74.524185)),
	MASTERS_SOUTH  ("Masters South",  new LatLng(40.264373, -74.524276)),
	MASTERS_THREE  ("Masters Three",  new LatLng(40.264513, -74.524223)),
	POTTER_NORTH   ("Potter North",   new LatLng(40.266985, -74.523783)),
	POTTER_SOUTH   ("Potter South",   new LatLng(40.266813, -74.524276)),
	ROBERSON       ("Roberson",       new LatLng(40.263053, -74.523536)),
	TRASK          ("Trask",          new LatLng(40.265016, -74.523238));
	
	private final String name;
	private final LatLng location;
	
	Dorm(String name, LatLng location) {
		this.name = name;
		this.location = location;
	}
	
	/**
	 * Calculates the distance between this dorm and another dorm.
	 * 
	 * @param o another dorm to compare against
	 * @return distance between the two given dorms in kilometers
	 */
	
	public double distanceTo(Dorm o) {
		return LatLngTool.distance(this.location, o.getLocation(), LengthUnit.KILOMETER);
	}
	
	public String getName() {
		return name;
	}
	
	public LatLng getLocation() {
		return location;
	}
	
}
