package modelo.fichadas.colectivo;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

import modelo.fichadas.Fichada;
import modelo.fichadas.colectivo.TramoColectivo;

public class FichadaColectivo extends Fichada {
	
	private TramoColectivo tramo;

	
	
	public FichadaColectivo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FichadaColectivo(GregorianCalendar fechaHora, TramoColectivo tramo) {
		super(fechaHora);
		this.tramo = tramo;
		// TODO Auto-generated constructor stub
	}

	public TramoColectivo getTramo() {
		return tramo;
	}

	public void setTramo(TramoColectivo tramo) {
		this.tramo = tramo;
	}
	public BigDecimal obtenerPrecioColectivo() {
		return this.tramo.getPrecio();
	}
	public BigDecimal obtenerPrecio() {
		return this.tramo.getPrecio();
	}

	@Override
	public String toString() {
		return "FichadaColectivo [tramo=" + tramo + "]";
	}
	
	
}
