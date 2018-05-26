package modelo.lectoras;

import modelo.fichadas.tren.EstacionTren;

public class LectoraTren extends Lectora{

	public EstacionTren estacion;
	
	public LectoraTren() {}
	
	public LectoraTren(int nroSerie, EstacionTren estacion) {
		super(nroSerie);
		this.estacion = estacion;
	}
	
	public EstacionTren getEstacion() {
		return estacion;
	}
	
	public void setEstacion(EstacionTren estacion) {
		this.estacion = estacion;
	}
}
