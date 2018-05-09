package modelo.Descuentos;

import java.math.BigDecimal;

public class DescuentoBoletoEstudiantil {
	private float porcentajeDescuento;
	private int viajesRestantes;
	private enum eTipoBoletoEstudiantil {tipoA,TipoB}// que carajo ??
	
	//tipo voleto en uml es un atributo??
	
	public float getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(float porcentajeDescuento) {
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
