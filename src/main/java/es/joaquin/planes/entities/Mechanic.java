package es.joaquin.planes.entities;

import javax.persistence.Entity;

@Entity
public class Mechanic extends Employee {
	
	private String company;
	
	private Integer employed_since;
	
	private String education;

	public Mechanic() {
		super();
	}

	public Mechanic(String code, String name, String surname) {
		super(code, name, surname);
	}

	public Mechanic(String code, String name, String surname, String company, Integer employed_since,
			String education) {
		super(code, name, surname);
		this.company = company;
		this.employed_since = employed_since;
		this.education = education;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getEmployed_since() {
		return employed_since;
	}

	public void setEmployed_since(Integer employed_since) {
		this.employed_since = employed_since;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}
	
	@Override
    public String toString() {
        return super.toString() + " company=" + company + ", employed_since=" + employed_since
        	+ ", education=" + education;
    }
}
