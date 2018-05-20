package modelo.fichadas.tren;

import java.util.Set;

public class RecorridoTren {
	
	private int idRecorrido;
	private String nombre;
	private LineaTren linea;
	private Set<EstacionTren> estaciones;
	private Set<ViajeTren> viajes;
	private Set<SeccionTren> secciones;
	
	public RecorridoTren() {}
	
	public RecorridoTren(LineaTren linea, String nombre) {
		super();
		this.linea = linea;
		this.nombre = nombre;
	}

	public int getIdRecorrido() {
		return this.idRecorrido;
	}
	
	protected void setIdRecorrido(int idRecorrido) {
		this.idRecorrido = idRecorrido;
	}
	
	public Set<EstacionTren> getEstaciones() {
		return estaciones;
	}
	
	public void setEstaciones(Set<EstacionTren> estaciones) {
		this.estaciones = estaciones;
	}
	
	public LineaTren getLinea() {
		return linea;
	}
	
	public void setLinea(LineaTren linea) {
		this.linea = linea;
	}
	
	public Set<ViajeTren> getViajesTren() {
		return viajes;
	}
	
	public void setViajesTren(Set<ViajeTren> viajes) {
		this.viajes = viajes;
	}
	
	public Set<SeccionTren> getSecciones() {
		return secciones;
	}
	
	public void setSecciones(Set<SeccionTren> secciones) {
		this.secciones = secciones;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
