package es.joaquin.planes.entities;

import java.sql.Timestamp;
import java.util.List;

public class Flight {
	
	private String id;
	
	private String company;
	
	private Plane plane;
	
	private Airport departure;
	
	private Airport arrival;
	
	private Timestamp departure_time;
	
	private Double duration;
	
	private List<Crew> crew;
	
}