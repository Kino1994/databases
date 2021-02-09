package es.joaquin.planes.dtos;

import java.sql.Timestamp;
import java.util.Date;

public class CrewDeparturesDTO {
	
	private String code;
	
	private String name;
	
	private String surname;
	
	private String city;
	
	private Date departure_time;

	public CrewDeparturesDTO() {

	}

	public CrewDeparturesDTO(String code, String name, String surname, String city, Date departure_time) {
		this.code = code;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.departure_time = departure_time;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(Timestamp departure_time) {
		this.departure_time = departure_time;
	}
	
	@Override
    public String toString() {
        return "code=" + code+ ", name=" + name + ", surname=" + surname + ", city=" + city + ", departure_time=" + departure_time;
    }
	
}
