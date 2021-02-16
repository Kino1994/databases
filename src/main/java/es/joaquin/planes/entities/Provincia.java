package es.joaquin.planes.entities;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Provincia {

	@Id
	private String id;
	private String Nombre;
	private String CA;
	private String Superficie;
	private List<ProvinciaDemoData> Datos;
	
	public Provincia() {

	}

	public Provincia(String id, String nombre, String cA, String superficie, List<ProvinciaDemoData> datos) {
		this.id = id;
		this.Nombre = nombre;
		this.CA = cA;
		this.Superficie = superficie;
		this.Datos = datos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCA() {
		return CA;
	}

	public void setCA(String cA) {
		CA = cA;
	}

	public String getSuperficie() {
		return Superficie;
	}

	public void setSuperficie(String superficie) {
		Superficie = superficie;
	}

	public List<ProvinciaDemoData> getDatos() {
		return Datos;
	}

	public void setDatos(List<ProvinciaDemoData> datos) {
		Datos = datos;
	}

	@Override
	public String toString() {
		 return  "id=" + id + ", Nombre=" + Nombre+ ", CA=" + CA + ", Superficie=" + Superficie;
	}

}
