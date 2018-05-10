package modelo.fichadas.colectivo;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

import modelo.fichadas.Fichada;
import modelo.fichadas.colectivo.TramoColectivo;

public class FichadaColectivo extends Fichada {
	
	private TramoColectivo tramo;

	public FichadaColectivo(TramoColectivo tramo, GregorianCalendar fechaHora) {
		super(fechaHora);
		this.tramo = tramo;
	}
	
	public TramoColectivo getTramo() {
		return tramo;
	}

	public void setTramo(TramoColectivo tramo) {
		this.tramo = tramo;
	}

	public BigDecimal obtenerPrecio() {
		return this.tramo.getPrecio();
	}
}
