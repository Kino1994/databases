package es.joaquin.planes.entities;

import java.sql.Timestamp;
import java.util.List;

public class Flight {
	
	private String code;
	
	private String company;
	
	private Plane plane;
	
	private Airport departure_airport;
	
	private Airport arrival_airport;
	
	private Timestamp departure_time;
	
	private double duration;
	
	private List<Crew> crew;
	
}