package modelo.fichadas.tren;

import java.util.Set;
import util.IndexableSet;

public class RecorridoTren {
	
	private int idRecorrido;
	private String nombre;
	private LineaTren linea;
	private IndexableSet<EstacionTren> estaciones;
	private IndexableSet<ViajeTren> viajes;
	private IndexableSet<SeccionTren> secciones;
	
	public RecorridoTren() {}
	
	public RecorridoTren(LineaTren linea, String nombre) {
		super();
		this.linea = linea;
		this.nombre = nombre;
		this.estaciones = new IndexableSet<EstacionTren>();
		this.viajes = new IndexableSet<ViajeTren>();
		this.secciones = new IndexableSet<SeccionTren>();
	}

	public int getIdRecorrido() {
		return this.idRecorrido;
	}
	
	protected void setIdRecorrido(int idRecorrido) {
		this.idRecorrido = idRecorrido;
	}
	
	public IndexableSet<EstacionTren> getEstaciones() {
		return estaciones;
	}
	

	
	public LineaTren getLinea() {
		return linea;
	}
	
	public void setLinea(LineaTren linea) {
		this.linea = linea;
	}
	
	public IndexableSet<ViajeTren> getViajes() {
		return viajes;
	}
	

	public void setEstaciones(IndexableSet<EstacionTren> estaciones) {
		this.estaciones = estaciones;
	}

	public void setViajes(IndexableSet<ViajeTren> viajes) {
		this.viajes = viajes;
	}

	public void setSecciones(IndexableSet<SeccionTren> secciones) {
		this.secciones = secciones;
	}

	public IndexableSet<SeccionTren> getSecciones() {
		return secciones;
	}

	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



}
