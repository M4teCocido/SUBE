package modelo.fichadas.tren;

import java.math.BigDecimal;

public class SeccionTren {
	
	private int idSeccion;
	private String nombre;
	private BigDecimal importe;
	private RecorridoTren recorrido;
	
	public SeccionTren() {}
	
	public SeccionTren(String nombre, BigDecimal importe, RecorridoTren recorrido) {
		super();
		this.nombre = nombre;
		this.importe = importe;
		this.recorrido = recorrido;
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
	
	public RecorridoTren getRecorrido() {
		return this.recorrido;
	}

	public void setRecorrido(RecorridoTren recorrido) {
		this.recorrido = recorrido;
	}
}