package es.joaquin.planes.dtos;

public class MechanicOverhaulDTO {
	
	private String tail_number;
	
	private String name;
	
	private String surname;	
	
	public MechanicOverhaulDTO() {
		
	}

	public MechanicOverhaulDTO(String tail_number, String name, String surname) {
		this.tail_number = tail_number;
		this.name = name;
		this.surname = surname;
	}

	public String getTail_number() {
		return tail_number;
	}

	public void setTail_number(String tail_number) {
		this.tail_number = tail_number;
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
        return "tail_number=" + tail_number + ", name=" + name + ", surname=" + surname;
    }

}
