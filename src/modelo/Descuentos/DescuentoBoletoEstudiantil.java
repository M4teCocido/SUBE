package modelo.Descuentos;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DescuentoBoletoEstudiantil {
	
	// 5.00h y las 23.00h.
	
	public enum eTipoBoletoEstudiantil {ESCOLAR, UNIVERSITARIO}
	
	private static int horaInicio = 5;
	private static int horaFin = 23;
	
	private BigDecimal porcentajeDescuento;
	private int viajesRestantes;
	private eTipoBoletoEstudiantil tipoBoletoEstudiantil;
	
	//Los viajes no los recargamos : Le asignamos un nuevo descuento y listo.
	
	public DescuentoBoletoEstudiantil(eTipoBoletoEstudiantil tipoBoletoEstudiantil) {
		super();
		if (tipoBoletoEstudiantil == eTipoBoletoEstudiantil.ESCOLAR) {
			this.porcentajeDescuento = new BigDecimal(0);
			this.viajesRestantes = 50;	
		} else {
			this.porcentajeDescuento = new BigDecimal(0);
			this.viajesRestantes = 45;	
		}
		
		this.tipoBoletoEstudiantil = tipoBoletoEstudiantil;
	}

	private void consumirViaje() {
		this.viajesRestantes--;
	}
	
	public BigDecimal aplicarDescuento (BigDecimal importe) {
		BigDecimal importeFinal = new BigDecimal(importe.doubleValue());
		if (this.viajesRestantes > 0) {
			GregorianCalendar fechaActual = new GregorianCalendar();
			if (fechaActual.get(Calendar.HOUR_OF_DAY) >= horaInicio && fechaActual.get(Calendar.HOUR_OF_DAY) <= horaFin) {
				this.consumirViaje();
				importeFinal = importeFinal.multiply(this.porcentajeDescuento);
			}
		}
		return importeFinal;
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
