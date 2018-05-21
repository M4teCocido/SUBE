package modelo.fichadas.tren;

import java.math.BigDecimal;
import java.util.Set;
import util.IndexableSet;

public class LineaTren {

	private int idLinea;
	private String nombre;
	private IndexableSet<SeccionTren> secciones;
	private IndexableSet<EstacionTren> estaciones;
	private IndexableSet<ViajeTren> viajes;
	
	
	public LineaTren() {}
	
	public LineaTren(String nombre) {
		super();
		this.nombre = nombre;
		this.secciones = new IndexableSet<SeccionTren>();
		this.estaciones = new IndexableSet<EstacionTren>();
		this.viajes = new IndexableSet<ViajeTren>();
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

	public IndexableSet<SeccionTren> getSecciones() {
		return secciones;
	}

	public void setSecciones(IndexableSet<SeccionTren> secciones) {
		this.secciones = secciones;
	}

	public IndexableSet<EstacionTren> getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(IndexableSet<EstacionTren> estaciones) {
		this.estaciones = estaciones;
	}

	public IndexableSet<ViajeTren> getViajes() {
		return viajes;
	}

	public void setViajes(IndexableSet<ViajeTren> viajes) {
		this.viajes = viajes;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public IndexableSet<SeccionTren> getSeccionesTren() {
		return secciones;
	}

	public void setSeccionesTren(IndexableSet<SeccionTren> seccionesTren) {
		this.secciones = seccionesTren;
	}

	public BigDecimal obtenerMayorSeccion() {
		BigDecimal montoMayor = new BigDecimal (0);
		
		for (int i=0; i<this.secciones.size()-1; i++) {
			if (montoMayor.compareTo(this.secciones.get(i).getImporte())==-1){
				montoMayor = this.secciones.get(i).getImporte();
			}
		}
		return montoMayor;
	}
}
