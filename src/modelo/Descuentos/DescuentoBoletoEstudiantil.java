package modelo.Descuentos;

import java.math.BigDecimal;

public class DescuentoBoletoEstudiantil {
	
	private enum eTipoBoletoEstudiantil {TIPO_A,TIPO_B}
	
	private BigDecimal porcentajeDescuento;
	private int viajesRestantes;
	private eTipoBoletoEstudiantil tipoBoletoEstudiantil;
	
	public DescuentoBoletoEstudiantil(BigDecimal porcentajeDescuento, int viajesRestantes,
			eTipoBoletoEstudiantil tipoBoletoEstudiantil) {
		super();
		this.porcentajeDescuento = porcentajeDescuento;
		this.viajesRestantes = viajesRestantes;
		this.tipoBoletoEstudiantil = tipoBoletoEstudiantil;
	}

	public BigDecimal getPorcentajeDescuento() {
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
	
	public eTipoBoletoEstudiantil getTipoBoletoEstudiantil() {
		return tipoBoletoEstudiantil;
	}

	public void setTipoBoletoEstudiantil(eTipoBoletoEstudiantil tipoBoletoEstudiantil) {
		this.tipoBoletoEstudiantil = tipoBoletoEstudiantil;
	}

	public BigDecimal aplicarDescuento (BigDecimal importe) {
		return importe;
	}
}
