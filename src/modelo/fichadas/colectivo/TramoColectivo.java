package modelo.fichadas.colectivo;

import java.math.BigDecimal;

public class TramoColectivo {
<<<<<<< HEAD
=======
	
>>>>>>> a84f8f01c047347ca76e4dc77dbc95a2f946368d
	private int idTramo;
	private String nombre;
	private BigDecimal precio;
	
<<<<<<< HEAD
	public TramoColectivo(String nombre, BigDecimal precio, LineaColectivo lineaColectivo) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.lineaColectivo = lineaColectivo;
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

	public LineaColectivo getLineaColectivo() {
		return lineaColectivo;
	}

	public void setLineaColectivo(LineaColectivo lineaColectivo) {
		this.lineaColectivo = lineaColectivo;
	}

	public int getIdTramo() {
		return idTramo;
	}

	public void setIdTramo(int idTramo) {
		this.idTramo = idTramo;
	}
	
	
	
=======
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
>>>>>>> a84f8f01c047347ca76e4dc77dbc95a2f946368d
	
}