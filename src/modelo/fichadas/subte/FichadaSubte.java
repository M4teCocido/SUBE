package modelo.fichadas.subte;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import modelo.fichadas.Fichada;
import modelo.lectoras.LectoraSubte;

public class FichadaSubte extends Fichada {
	
	private EstacionSubte estacionSubte;
	
	public FichadaSubte() {}
	
	public FichadaSubte(GregorianCalendar fechaHora, LectoraSubte lectora, EstacionSubte estacionSubte) {
		super(fechaHora, lectora);
		this.setEstacionSubte(estacionSubte);
	}
	
	public EstacionSubte getEstacionSubte() {
		return estacionSubte;
	}

	public void setEstacionSubte(EstacionSubte estacionSubte) {
		this.estacionSubte = estacionSubte;
	}
	
	public BigDecimal obtenerPrecio() {
		return this.estacionSubte.getLineaSubte().getPrecioViaje();
	}
	
	@Override
	public String toString() {
		return "FichadaSubte [estacionSubte=" + estacionSubte + ", getFechaHora()=" + getFechaHora().getTime();
	} 
	
}
