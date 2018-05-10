package modelo.fichadas.subte;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import modelo.fichadas.Fichada;

public class FichadaSubte extends Fichada {
	
	private EstacionSubte estacionSubte;

	

	public FichadaSubte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FichadaSubte(GregorianCalendar fechaHora, EstacionSubte estacion ) {
		super(fechaHora);
		// TODO Auto-generated constructor stub
		this.estacionSubte = estacion;
	}

	public EstacionSubte getEstacionSubte() {
		return estacionSubte;
	}

	public void setEstacionSubte(EstacionSubte estacionSubte) {
		this.estacionSubte = estacionSubte;
	}
	
	public BigDecimal getMonto() {
		return super.getMonto();
	}
	
	@Override
	public String toString() {
		return "FichadaSubte [estacionSubte=" + estacionSubte + ", getFechaHora()=" + getFechaHora().getTime() + ", getMonto()="
				+ getMonto() + "]";
	}
	
	public BigDecimal traerMontoLinea() {
		return this.estacionSubte.getLineaSubte().getPrecioViaje(); //  trae el costo del viaje en subte
	}
}
