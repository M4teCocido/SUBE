package modelo.lectoras;

import modelo.fichadas.tren.EstacionTren;

public class LectoraTren {

	public EstacionTren estacion;
	
	public LectoraTren() {}
	
	public LectoraTren(EstacionTren estacion) {
		super();
		this.estacion = estacion;
	}
	
	public EstacionTren getEstacion() {
		return estacion;
	}
	
	public void setEstacion(EstacionTren estacion) {
		this.estacion = estacion;
	}
}
