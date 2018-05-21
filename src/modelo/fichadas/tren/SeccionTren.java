package modelo.fichadas.tren;

import java.math.BigDecimal;

import util.IndexableSet;

public class SeccionTren {
	
	private int idSeccion;
	private String nombre;
	private BigDecimal importe;
<<<<<<< HEAD
	private RecorridoTren recorrido;
	private IndexableSet<ViajeTren> viajesTren;
=======
	private LineaTren linea;
	
>>>>>>> a0ad04b77d95dd37b9f0962239a2814e13dd3ad9
	public SeccionTren() {}
	
	public SeccionTren(String nombre, BigDecimal importe, LineaTren linea) {
		super();
		this.nombre = nombre;
		this.importe = importe;
<<<<<<< HEAD
		this.recorrido = recorrido;
		this.viajesTren = new IndexableSet<ViajeTren>();
=======
		this.linea = linea;
>>>>>>> a0ad04b77d95dd37b9f0962239a2814e13dd3ad9
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

	public IndexableSet<ViajeTren> getViajesTren() {
		return viajesTren;
	}

	public void setViajesTren(IndexableSet<ViajeTren> viajesTren) {
		this.viajesTren = viajesTren;
	}

	
}