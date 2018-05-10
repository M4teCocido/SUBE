package modelo.fichadas.colectivo;

import java.util.ArrayList;
import java.util.List;

public class LineaColectivo {
	
	private String nombre;
	private List<RamalColectivo> ramalesColectivo;

	public LineaColectivo(String nombre) {
		super();
		this.nombre = nombre;
		this.ramalesColectivo = new ArrayList<RamalColectivo>();
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<RamalColectivo> getRecorridosColectivo() {
		return this.ramalesColectivo;
	}

	public void setRecorridosColectivo(List<RamalColectivo> ramalesColectivo) {
		this.ramalesColectivo = ramalesColectivo;
	}

	@Override
	public String toString() {
		return "LineaColectivo [Nombre=" + this.nombre + "]";
	}	
	
}
