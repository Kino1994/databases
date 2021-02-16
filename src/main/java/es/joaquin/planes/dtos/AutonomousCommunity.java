package es.joaquin.planes.dtos;

public class AutonomousCommunity {
	
	private String autonomousCommunity;
    private Integer totalProvinces;
    
	public AutonomousCommunity() {
		
	}

	public AutonomousCommunity(String autonomousCommunity, Integer totalProvinces) {
		this.autonomousCommunity = autonomousCommunity;
		this.totalProvinces = totalProvinces;
	}


	public String getAutonomousCommunity() {
		return autonomousCommunity;
	}

	public void setAutonomousCommunity(String autonomousCommunity) {
		this.autonomousCommunity = autonomousCommunity;
	}

	public Integer getTotalProvinces() {
		return totalProvinces;
	}

	public void setTotalProvinces(Integer totalProvinces) {
		this.totalProvinces = totalProvinces;
	}

	@Override
	public String toString() {
		 return  "autonomousCommunity=" + autonomousCommunity + ", totalProvinces=" + totalProvinces;
	}

}