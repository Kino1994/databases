package es.joaquin.planes.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Crew extends Employee {
	
	private String position;
	
	private String company;	
	    
    @OneToMany(mappedBy = "crew", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CrewFlight> crewFlights = new ArrayList<>();
    	
	public Crew() {
		
	}

	public Crew(String code, String name, String surname) {
		super(code, name, surname);
	}
		
	public Crew(String code, String name, String surname, String position, String company) {
		super(code, name, surname);
		this.position = position;
		this.company = company;
	}
	
	public Long getId() {
		return super.getId();
	}

	public void setId(Long id) {
		super.setId(id);
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

	public List<CrewFlight> getCrewFlights() {
		return crewFlights;
	}

	public void setCrewFlights(List<CrewFlight> crewFlights) {
		this.crewFlights = crewFlights;
	}

	@Override
    public String toString() {
        return super.toString() + " position=" + position + ", company=" + company;
    }

}
