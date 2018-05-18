package modelo.fichadas.subte;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LineaSubte {
	
	private int idLinea;
	private String nombre;
	private Set<EstacionSubte> recorridoSubte;
	private BigDecimal precioViaje;
	
	public LineaSubte() {}
	
	public LineaSubte(String nombre, BigDecimal precioViaje) {
		super();
		this.nombre = nombre;
		//this.recorridoSubte = new ArrayList<EstacionSubte>();
		this.precioViaje = precioViaje;
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
	
	public Set<EstacionSubte> getRecorridoSubte() {
		return recorridoSubte;
	}
	
	public void setRecorridoSubte(Set<EstacionSubte> recorridoSubte) {
		this.recorridoSubte = recorridoSubte;
	}
	
	public BigDecimal getPrecioViaje() {
		return precioViaje;
	}
	
	public void setPrecioViaje(BigDecimal precioViaje) {
		this.precioViaje = precioViaje;
	}

}
