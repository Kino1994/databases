package es.joaquin.planes.entities;

public class ProvinciaDemoData {
	
	private Integer anyo;
	
	private Integer valor;

	public ProvinciaDemoData() {

	}

	public ProvinciaDemoData(Integer anyo, Integer valor) {
		this.anyo = anyo;
		this.valor = valor;
	}

	public Integer getAnyo() {
		return anyo;
	}

	public void setAnyo(Integer anyo) {
		this.anyo = anyo;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	@Override
    public String toString() {
        return "anyo=" + anyo+ ", valor=" + valor;
    }

}