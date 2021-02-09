package es.joaquin.planes.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Crew extends Employee {
	
	private String position;
	
	private String company;	
	
    @ManyToOne
	private Flight flight;
    	
	public Crew() {
		super();
	}

	public Crew(String code, String name, String surname) {
		super(code, name, surname);
	}

	public Crew(String code, String name, String surname, String position, String company, Flight flight) {
		super(code, name, surname);
		this.position = position;
		this.company = company;
		this.flight = flight;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	@Override
    public String toString() {
        return super.toString() + " position=" + position + ", company=" + company;
    }

}
