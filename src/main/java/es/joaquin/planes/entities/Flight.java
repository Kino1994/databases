package es.joaquin.planes.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String code;
	
	private String company;
	
	@OneToOne
	private Plane plane;
	
	@OneToOne
	private Airport departure;
	
	@OneToOne
	private Airport arrival;
	
	private Date departure_time;	
	
	private Double duration;
	
    @OneToMany(mappedBy="flight")
	private List<Crew> crew;
    
    public Flight() {
			
	}
    

	public Flight(String code, String company, Plane plane, Airport departure, Airport arrival,
			Date departure_time, Double duration, List<Crew> crew) {
		this.code = code;
		this.company = company;
		this.plane = plane;
		this.departure = departure;
		this.arrival = arrival;
		this.departure_time = departure_time;
		this.duration = duration;
		this.crew = crew;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public Airport getDeparture() {
		return departure;
	}

	public void setDeparture(Airport departure) {
		this.departure = departure;
	}

	public Airport getArrival() {
		return arrival;
	}

	public void setArrival(Airport arrival) {
		this.arrival = arrival;
	}
	
	public Date getDeparture_date_time() {
		return departure_time;
	}

	public void setDeparture_date_time(Date departure_time) {
		this.departure_time = departure_time;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public List<Crew> getCrew() {
		return crew;
	}

	public void setCrew(List<Crew> crew) {
		this.crew = crew;
	}
	
	@Override
    public String toString() {
        return  "code=" + code + ", company=" + company + ", plane=" + plane.getTail_number()
        	+ ", departure=" + departure.getCode() + ", arrival=" + arrival.getCode()
        	+ ", departure_date_time=" + departure_time + ", departure_hour_time=" + departure_time
        	+ ", duration=" + duration;
    }
	
}