package modelo.fichadas.tren;

import java.math.BigDecimal;
import java.util.Set;
import util.IndexableSet;
<<<<<<< HEAD
=======
import modelo.fichadas.tren.ViajeTren;
import modelo.fichadas.tren.SeccionTren;
import modelo.fichadas.tren.EstacionTren;
>>>>>>> a0ad04b77d95dd37b9f0962239a2814e13dd3ad9

public class LineaTren {

	private int idLinea;
	private String nombre;
<<<<<<< HEAD
	private IndexableSet<SeccionTren> secciones;
	private IndexableSet<EstacionTren> estaciones;
	private IndexableSet<ViajeTren> viajes;
	
=======
	private Set<EstacionTren> estaciones;
	private Set<ViajeTren> viajes;
	private Set<SeccionTren> secciones;
>>>>>>> a0ad04b77d95dd37b9f0962239a2814e13dd3ad9
	
	public LineaTren() {}
	
	public LineaTren(String nombre) {
		super();
		this.nombre = nombre;
<<<<<<< HEAD
		this.secciones = new IndexableSet<SeccionTren>();
		this.estaciones = new IndexableSet<EstacionTren>();
		this.viajes = new IndexableSet<ViajeTren>();
=======
		this.estaciones = new IndexableSet<EstacionTren>();
		this.viajes = new IndexableSet<ViajeTren>();
		this.secciones = new IndexableSet<SeccionTren>();
>>>>>>> a0ad04b77d95dd37b9f0962239a2814e13dd3ad9
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

<<<<<<< HEAD

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
=======
	public Set<EstacionTren> getEstaciones() {
		return estaciones;
	}
	
	public void setEstaciones(Set<EstacionTren> estaciones) {
		this.estaciones = estaciones;
	}
	
	public Set<ViajeTren> getViajes() {
		return viajes;
	}
	
	public void setViajes(Set<ViajeTren> viajes) {
		this.viajes = viajes;
	}
	
	public Set<SeccionTren> getSecciones() {
		return secciones;
	}
	
	public void setSecciones(Set<SeccionTren> secciones) {
		this.secciones = secciones;
>>>>>>> a0ad04b77d95dd37b9f0962239a2814e13dd3ad9
	}
}
