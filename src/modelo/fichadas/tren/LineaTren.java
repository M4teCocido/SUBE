package modelo.fichadas.tren;

import java.util.Set;
import util.IndexableSet;
import modelo.fichadas.tren.ViajeTren;
import modelo.fichadas.tren.SeccionTren;
import modelo.fichadas.tren.EstacionTren;

public class LineaTren {

	private int idLinea;
	private String nombre;
	private Set<EstacionTren> estaciones;
	private Set<ViajeTren> viajes;
	private Set<SeccionTren> secciones;
	
	public LineaTren() {}
	
	public LineaTren(String nombre) {
		super();
		this.nombre = nombre;
		this.estaciones = new IndexableSet<EstacionTren>();
		this.viajes = new IndexableSet<ViajeTren>();
		this.secciones = new IndexableSet<SeccionTren>();
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

	public Set<EstacionTren> getEstaciones() {
		return estaciones;
	}
	
	public void setEstaciones(Set<EstacionTren> estaciones) {
		this.estaciones = estaciones;
	}
	
	public Set<ViajeTren> getViajes() {
		return viajes;
	}
	
	public void setViajes(Set<ViajeTren> viajes) {
		this.viajes = viajes;
	}
	
	public Set<SeccionTren> getSecciones() {
		return secciones;
	}
	
	public void setSecciones(Set<SeccionTren> secciones) {
		this.secciones = secciones;
	}
	
}
