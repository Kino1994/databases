package es.joaquin.planes.dtos;

public interface CrewStats { 
	
	String getCode();

	String getName();

	String getSurname();
	
	Long getTotal_flights();

	Double getTotal_flight_hours(); 	

}