package modelo.fichadas.colectivo;

import java.util.Set;
import java.util.HashSet;

public class LineaColectivo {
	
	private int idLinea;
	private String nombre;
	private Set<RamalColectivo> ramalesColectivo;

	public LineaColectivo() {}
	
	public LineaColectivo(String nombre) {
		super();
		this.nombre = nombre;
		this.ramalesColectivo = new HashSet<RamalColectivo>();
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

	public Set<RamalColectivo> getRamalesColectivo() {
		return this.ramalesColectivo;
	}

	public void setRamalesColectivo(Set<RamalColectivo> ramalesColectivo) {
		this.ramalesColectivo = ramalesColectivo;
	}

	@Override
	public String toString() {
		return "LineaColectivo [Nombre=" + this.nombre + "]";
	}	
	
}
