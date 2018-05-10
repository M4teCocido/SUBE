package modelo.fichadas.colectivo;

import java.math.BigDecimal;

public class TramoColectivo {
	
	private String nombre;
	private BigDecimal precio;
	private RamalColectivo ramal;
	
	public TramoColectivo(String nombre, BigDecimal precio, RamalColectivo ramal) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.ramal = ramal;
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
	
	public RamalColectivo getRamal() {
		return ramal;
	}
	
	public void setRamal(RamalColectivo ramal) {
		this.ramal = ramal;
	}
	
}
