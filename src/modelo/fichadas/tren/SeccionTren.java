package modelo.fichadas.tren;

import java.math.BigDecimal;

import util.IndexableSet;

public class SeccionTren {
	
	private int idSeccion;
	private String nombre;
	private BigDecimal importe;
	private RecorridoTren recorrido;
	private IndexableSet<ViajeTren> viajesTren;
	public SeccionTren() {}
	
	public SeccionTren(String nombre, BigDecimal importe, RecorridoTren recorrido) {
		super();
		this.nombre = nombre;
		this.importe = importe;
		this.recorrido = recorrido;
		this.viajesTren = new IndexableSet<ViajeTren>();
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

	public IndexableSet<ViajeTren> getViajesTren() {
		return viajesTren;
	}

	public void setViajesTren(IndexableSet<ViajeTren> viajesTren) {
		this.viajesTren = viajesTren;
	}

	
}