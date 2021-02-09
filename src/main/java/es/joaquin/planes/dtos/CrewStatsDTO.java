package es.joaquin.planes.dtos;

public class CrewStatsDTO {
	
	private String code;
	
	private String name;
	
	private String surname;
	
	private Long total_flights;
	
	private Double total_flight_hours;
	
	public CrewStatsDTO() {
		super();
	}

	public CrewStatsDTO(String code, String name, String surname, Long total_flights, Double total_flight_hours) {
		this.code = code;
		this.name = name;
		this.surname = surname;
		this.total_flights = total_flights;
		this.total_flight_hours = total_flight_hours;
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

	public Long getTotal_flights() {
		return total_flights;
	}

	public void setTotal_flights(Long total_flights) {
		this.total_flights = total_flights;
	}

	public Double getTotal_flight_hours() {
		return total_flight_hours;
	}

	public void setTotal_flight_hours(Double total_flight_hours) {
		this.total_flight_hours = total_flight_hours;
	}

	@Override
    public String toString() {
        return "code=" + code+ ", name=" + name + ", surname=" + surname + ", total_flights=" + total_flights
        	+ ", total_flights_hours=" + total_flight_hours;
    }
	
}
