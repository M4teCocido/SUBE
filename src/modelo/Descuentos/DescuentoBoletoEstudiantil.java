package modelo.Descuentos;

import java.math.BigDecimal;

public class DescuentoBoletoEstudiantil {
	private enum eTipoBoletoEstudiantil {TIPO_A,TIPO_B}
	
	private BigDecimal porcentajeDescuento;
	private int viajesRestantes;
	private eTipoBoletoEstudiantil tipoBoletoEstudiantil;
	
	
	public BigDecimal  getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public int getViajesRestantes() {
		return viajesRestantes;
	}

	public void setViajesRestantes(int viajesRestantes) {
		this.viajesRestantes = viajesRestantes;
	}
	
	public BigDecimal aplicarDescuento (BigDecimal importe) {
		return importe;
	}
}
