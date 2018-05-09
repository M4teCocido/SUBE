package modelo.fichadas.tren;

import java.util.List;

public class RecorridoTren {
	
	private List<EstacionTren> estaciones;
	private LineaTren lineaTren;
	private List<ViajeTren> viajesTren;
	private List<SeccionTren> seccionTren;
	private String nombre;
	
	public List<EstacionTren> getEstaciones() {
		return estaciones;
	}
	
	public void setEstaciones(List<EstacionTren> estaciones) {
		this.estaciones = estaciones;
	}
	
	public LineaTren getLineaTren() {
		return lineaTren;
	}
	
	public void setLineaTren(LineaTren lineaTren) {
		this.lineaTren = lineaTren;
	}
	
	public List<ViajeTren> getViajesTren() {
		return viajesTren;
	}
	
	public void setViajesTren(List<ViajeTren> viajesTren) {
		this.viajesTren = viajesTren;
	}
	
	public List<SeccionTren> getSeccionTren() {
		return seccionTren;
	}
	
	public void setSeccionTren(List<SeccionTren> seccionTren) {
		this.seccionTren = seccionTren;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
