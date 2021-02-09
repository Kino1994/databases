package es.joaquin.planes.dtos;

public class MechanicOverhaulDTO {
	
	private String tail_numer;
	
	private String name;
	
	private String surname;	
	
	public MechanicOverhaulDTO(String tail_numer, String name, String surname) {
		this.tail_numer = tail_numer;
		this.name = name;
		this.surname = surname;
	}

	public String getTail_numer() {
		return tail_numer;
	}

	public void setTail_numer(String tail_numer) {
		this.tail_numer = tail_numer;
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

	@Override
    public String toString() {
        return "tail_numer=" + tail_numer + ", name=" + name + ", surname=" + surname;
    }

}
