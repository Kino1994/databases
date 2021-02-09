package es.joaquin.planes.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Overhaul {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Plane plane;
	
	private Date start_date;
	
	private Date end_date;
	
	private Double spent_hours;
	
	@OneToOne
	private Mechanic mechanic;
	
	private String type;
	
	private String description;
	
	@OneToOne
	private Airport airport;
	
	public Overhaul(Plane plane2, Date date, int i, Mechanic m1, String string, String string2, Airport airport2) {
		
	}

	public Overhaul(Plane plane, Date start_date, Date end_date, Double spent_hours, Mechanic mechanic, String type,
			String description, Airport airport) {
		this.plane = plane;
		this.start_date = start_date;
		this.end_date = end_date;
		this.spent_hours = spent_hours;
		this.mechanic = mechanic;
		this.type = type;
		this.description = description;
		this.airport = airport;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Double getSpent_hours() {
		return spent_hours;
	}

	public void setSpent_hours(Double spent_hours) {
		this.spent_hours = spent_hours;
	}

	public Mechanic getMechanic() {
		return mechanic;
	}

	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	
	@Override
    public String toString() {
        return " id=" + id+ ", plane=" + plane.getTail_number() + ", start_date=" + start_date
        	+ ", end_date=" + end_date + ", spent_hours=" + spent_hours + ", mechanic=" + mechanic.getCode()
        		+ ", type=" + type + ", description=" + description + ", airport=" + airport.getCode();     
    }
}
