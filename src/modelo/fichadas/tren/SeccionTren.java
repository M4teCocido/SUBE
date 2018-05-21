package modelo.fichadas.tren;

import java.math.BigDecimal;

public class SeccionTren {
	
	private int idSeccion;
	private String nombre;
	private BigDecimal importe;
	private LineaTren linea;
	
	public SeccionTren() {}
	
	public SeccionTren(String nombre, BigDecimal importe, LineaTren linea) {
		super();
		this.nombre = nombre;
		this.importe = importe;
		this.linea = linea;
	}

	public int getIdSeccion() {
		return this.idSeccion;
	}
	
	protected void setIdSeccion(int idSeccion) {
		this.idSeccion = idSeccion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public BigDecimal getImporte() {
		return importe;
	}
	
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	
	public LineaTren getLinea() {
		return this.linea;
	}

	public void setLinea(LineaTren linea) {
		this.linea = linea;
	}
}