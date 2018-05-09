package modelo.Descuentos;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.List;

import modelo.fichadas.Fichada;

public class LapsoDescuentoRedSube {
	
	private GregorianCalendar fechaHoraVencimiento;
	private List<Fichada> viajesRealizados;

	public GregorianCalendar getFechaHoraVencimiento() {
		return fechaHoraVencimiento;
	}

	public void setFechaHoraVencimiento(GregorianCalendar fechaHoraVencimiento) {
		this.fechaHoraVencimiento = fechaHoraVencimiento;
	}

	public List<Fichada> getViajesRealizados() {
		return viajesRealizados;
	}

	public void setViajesRealizados(List<Fichada> viajesRealizados) {
		this.viajesRealizados = viajesRealizados;
	}

	public BigDecimal aplicarDescuento(BigDecimal importe ) {
		return importe;
	}
}
