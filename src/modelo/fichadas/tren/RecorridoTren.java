package modelo.fichadas.tren;

import java.util.ArrayList;
import java.util.List;

public class RecorridoTren {
	
	private List<EstacionTren> estaciones;
	private LineaTren linea;
	private List<ViajeTren> viajes;
	private List<SeccionTren> secciones;
	private String nombre;
	
	public RecorridoTren( LineaTren linea, String nombre) {
		super();
		this.estaciones = new ArrayList <EstacionTren> ();
		this.linea = linea;
		this.viajes = new ArrayList<ViajeTren>();
		this.secciones = new ArrayList<SeccionTren>();
		this.nombre = nombre;
	}

	public List<EstacionTren> getEstaciones() {
		return estaciones;
	}
	
	public void setEstaciones(List<EstacionTren> estaciones) {
		this.estaciones = estaciones;
	}
	
	public LineaTren getLineaTren() {
		return linea;
	}
	
	public void setLineaTren(LineaTren linea) {
		this.linea = linea;
	}
	
	public List<ViajeTren> getViajesTren() {
		return viajes;
	}
	
	public void setViajesTren(List<ViajeTren> viajes) {
		this.viajes = viajes;
	}
	
	public List<SeccionTren> getSeccionTren() {
		return secciones;
	}
	
	public void setSeccionTren(List<SeccionTren> secciones) {
		this.secciones = secciones;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
