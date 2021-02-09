package es.joaquin.planes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plane {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String tail_number;

	private String manufacturer;
	
	private String model;
	
	private Integer flight_hours;
	
	public Plane() {
		
	}

	public Plane(String tail_number, String manufacturer, String model, Integer flight_hours) {
		this.tail_number = tail_number;
		this.manufacturer = manufacturer;
		this.model = model;
		this.flight_hours = flight_hours;
	}

	public String getTail_number() {
		return tail_number;
	}

	public void setTail_number(String tail_number) {
		this.tail_number = tail_number;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getFlight_hours() {
		return flight_hours;
	}

	public void setFlight_hours(Integer flight_hours) {
		this.flight_hours = flight_hours;
	}
	
	@Override
    public String toString() {
        return  "tail_number=" + tail_number + ", manufacturer=" + manufacturer + ", model=" + model
        	+ ", flight_hours=" + flight_hours;
    }
	
}
