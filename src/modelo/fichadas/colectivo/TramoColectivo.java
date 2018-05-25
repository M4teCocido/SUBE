package modelo.fichadas.colectivo;

import java.math.BigDecimal;

public class TramoColectivo {
	
	private int idTramo;
	private String nombre;
	private BigDecimal precio;
	
	public TramoColectivo() {}
	
	public TramoColectivo(String nombre, BigDecimal precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public int getIdTramo() {
		return this.idTramo;
	}
	
	protected void setIdTramo(int idTramo) {
		this.idTramo = idTramo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public BigDecimal getPrecio() {
		return precio;
	}
	
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
}