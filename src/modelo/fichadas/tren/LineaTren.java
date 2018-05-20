package modelo.fichadas.tren;

import java.util.Set;

public class LineaTren {

	private int idLinea;
	private String nombre;
	private Set<RecorridoTren> recorridosTren;
	
	public LineaTren() {}
	
	public LineaTren(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getIdLinea() {
		return this.idLinea;
	}
	
	protected void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<RecorridoTren> getRecorridosTren() {
		return recorridosTren;
	}

	public void setRecorridosTren(Set<RecorridoTren> recorridosTren) {
		this.recorridosTren = recorridosTren;
	}
	
}
