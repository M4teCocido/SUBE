package modelo.fichadas.subte;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import modelo.fichadas.Fichada;

public class FichadaSubte extends Fichada {
	
	private EstacionSubte estacionSubte;

	public FichadaSubte(GregorianCalendar fechaHora, BigDecimal monto, EstacionSubte estacionSubte) {
		super(fechaHora, monto);
		this.estacionSubte = estacionSubte;
		
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
	
}
