package modelo.fichadas.colectivo;

import java.util.Set;

public class LineaColectivo {
	
	private int idLinea;
	private String nombre;
	private Set<RamalColectivo> ramalesColectivo;

	public LineaColectivo() {}
	
	public LineaColectivo(String nombre) {
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
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<RamalColectivo> getRecorridosColectivo() {
		return this.ramalesColectivo;
	}

	public void setRecorridosColectivo(Set<RamalColectivo> ramalesColectivo) {
		this.ramalesColectivo = ramalesColectivo;
	}

	@Override
	public String toString() {
		return "LineaColectivo [Nombre=" + this.nombre + "]";
	}	
	
}
