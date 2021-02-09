package es.joaquin.planes.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class CrewFlight {

	@EmbeddedId
    private CrewFlightId id;

    @ManyToOne
    @MapsId("crewId")
    private Crew crew;

    @ManyToOne
    @MapsId("flightId")
    private Flight flight;    

	public CrewFlight() {
		
	}

	public CrewFlight(Crew crew, Flight flight) {
		this.crew = crew;
		this.flight = flight;
		this.id = new CrewFlightId(crew.getId(), flight.getId());
	}

	public CrewFlightId getId() {
		return id;
	}

	public void setId(CrewFlightId id) {
		this.id = id;
	}

	public Crew getCrew() {
		return crew;
	}

	public void setCrew(Crew crew) {
		this.crew = crew;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}