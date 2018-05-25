package modelo.fichadas.colectivo;

import java.util.Set;
import java.util.HashSet;


public class LineaColectivo {
	
	private int idLinea;
	private String nombre;
	
	private Set<InternoColectivo> internoColectivo;

	public LineaColectivo() {}
	
	public LineaColectivo(String nombre) {
		super();
		this.nombre = nombre;
		this.internoColectivo = new HashSet<InternoColectivo>();
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
	
	@Override
	public String toString() {
		return "LineaColectivo [Nombre=" + this.nombre + "]";
	}	
	
}
