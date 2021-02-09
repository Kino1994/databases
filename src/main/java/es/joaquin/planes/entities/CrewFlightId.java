package es.joaquin.planes.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CrewFlightId implements Serializable {	
	
	private static final long serialVersionUID = 1L;

	private Long crewId;
    
	private Long flightId;

	public CrewFlightId() {
	}

	public CrewFlightId(Long crewId, Long flightId) {
		this.crewId = crewId;
		this.flightId = flightId;
	}

	public Long getCrewId() {
		return crewId;
	}

	public void setCrewId(Long crewId) {
		this.crewId = crewId;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}    
    
	
}