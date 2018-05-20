package modelo.fichadas.colectivo;

import java.util.Set;

public class RamalColectivo {
	
	private int idRamal;
	private Set<TramoColectivo> tramos;
	private LineaColectivo linea;
	private String nombre;
	
	public RamalColectivo() {}
	
	public RamalColectivo(LineaColectivo linea, String nombre) {
		super();
		this.linea = linea;
		this.nombre = nombre;
	}
	
	public int getIdRamal() {
		return this.idRamal;
	}
	
	protected void setIdRamal(int idRamal) {
		this.idRamal = idRamal;
	}
	
	public Set<TramoColectivo> getTramos() {
		return tramos;
	}
	public void setTramos(Set<TramoColectivo> tramos) {
		this.tramos = tramos;
	}
	public LineaColectivo getLinea() {
		return linea;
	}
	public void setLinea(LineaColectivo linea) {
		this.linea = linea;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
