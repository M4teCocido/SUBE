package modelo.Descuentos;

import java.math.BigDecimal;

public class DescuentoBoletoEstudiantil {
	
	private enum eTipoBoletoEstudiantil {TIPO_A,TIPO_B}
	
	private BigDecimal porcentajeDescuento;
	private int viajesRestantes;
	private eTipoBoletoEstudiantil tipoBoletoEstudiantil;
	
	//Los viajes no los recargamos : Le asignamos un nuevo descuento y listo.
	
	public DescuentoBoletoEstudiantil(BigDecimal porcentajeDescuento, int viajesRestantes,
			eTipoBoletoEstudiantil tipoBoletoEstudiantil) {
		super();
		this.porcentajeDescuento = porcentajeDescuento;
		this.viajesRestantes = viajesRestantes;
		this.tipoBoletoEstudiantil = tipoBoletoEstudiantil;
	}

	private void consumirViaje() {
		this.viajesRestantes--;
	}
	
	public BigDecimal aplicarDescuento (BigDecimal importe) {
		if (this.viajesRestantes > 0) {
			this.consumirViaje();
			return importe.multiply(this.porcentajeDescuento);
		} else {
			return importe;	
		}
		
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
}
