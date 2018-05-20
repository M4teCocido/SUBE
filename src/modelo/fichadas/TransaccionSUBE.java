package modelo.fichadas;

import java.math.BigDecimal;

public class TransaccionSUBE {
	
	private Fichada fichada;
	private BigDecimal importe;
	
	public TransaccionSUBE(Fichada fichada, BigDecimal importe) {
		super();
		this.fichada = fichada;
		this.importe = importe;
	}

	public Fichada getFichada() {
		return fichada;
	}
	
	public void setFichada(Fichada fichada) {
		this.fichada = fichada;
	}
	
	public BigDecimal getImporte() {
		return importe;
	}
	
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "TransaccionSUBE [fichada =" + fichada.toString() + ", importe=" + importe + "]";
	}
	
}
