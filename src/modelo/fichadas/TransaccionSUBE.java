package modelo.fichadas;

import java.math.BigDecimal;

public class TransaccionSUBE {
	private Fichada fichada;
	private BigDecimal importe;
	
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
	
}
