package org.peddie.peer_tutoring.model;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

public enum Dorm {
	
	// FIXME: fill in the real lat/lng
	AUSTIN_COLGATE ("Austin-Colgate", new LatLng(39, 116)),
	AVERY          ("Avery",          new LatLng(39, 116)),
	CASPERSEN      ("Caspersen",      new LatLng(39, 116)),
	COLEMAN        ("Coleman",        new LatLng(39, 116)),
	KERR_NORTH     ("Kerr North",     new LatLng(39, 116)),
	KERR_SOUTH     ("Kerr South",     new LatLng(39, 116)),
	MARIBOE        ("Mariboe",        new LatLng(39, 116)),
	MASTERS_NORTH  ("Masters North",  new LatLng(39, 116)),
	MASTERS_SOUTH  ("Masters South",  new LatLng(39, 116)),
	MASTERS_THREE  ("Masters Three",  new LatLng(39, 116)),
	POTTER_NORTH   ("Potter North",   new LatLng(40, 116)),
	POTTER_SOUTH   ("Potter South",   new LatLng(40, 116)),
	ROBERSON       ("Roberson",       new LatLng(39, 116)),
	TRASK          ("Trask",          new LatLng(39, 116));
	
	
	private final String name;
	private final LatLng location;
	
	Dorm(String name, LatLng location) {
		this.name = name;
		this.location = location;
	}
	
	/**
	 * Calculates the distance between this dorm and the other dorm.
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
