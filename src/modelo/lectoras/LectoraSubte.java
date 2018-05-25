package modelo.lectoras;

import modelo.fichadas.subte.EstacionSubte;

public class LectoraSubte extends Lectora{
	
	private EstacionSubte estacion;
	
	public LectoraSubte () {}
	
	public LectoraSubte(EstacionSubte estacion) {
		super();
		this.estacion = estacion;
	}
	
	public EstacionSubte getEstacion() {
		return estacion;
	}
	
	public void setEstacion(EstacionSubte estacion) {
		this.estacion = estacion;
	}
}
