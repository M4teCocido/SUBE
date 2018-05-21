package modelo.Descuentos;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import modelo.fichadas.Fichada;

public class DescuentoRedSube extends DescuentoSube {
	
	private LapsoDescuentoRedSube lapsoDescuentoRedSube;
		
	public DescuentoRedSube(String nombre) {
		super(nombre);
		this.lapsoDescuentoRedSube = this.crearNuevoLapso();
	}

	private LapsoDescuentoRedSube crearNuevoLapso() {
		GregorianCalendar post2Horas = (GregorianCalendar) new GregorianCalendar();
		post2Horas.add(Calendar.HOUR_OF_DAY, 2);
		return new LapsoDescuentoRedSube(post2Horas);
	}
	
	public LapsoDescuentoRedSube getLapsoDescuentoRedSube() {
		return lapsoDescuentoRedSube;
	}
	
	public void setLapsoDescuentoRedSube(LapsoDescuentoRedSube lapsoDescuentoRedSube) {
		this.lapsoDescuentoRedSube = lapsoDescuentoRedSube;
	}

	public DescuentoRedSube(int prioridad, String nombre, LapsoDescuentoRedSube lapsoDescuentoRedSube) {
		super(nombre);
		this.lapsoDescuentoRedSube = lapsoDescuentoRedSube;
	}

	public BigDecimal aplicarDescuento (BigDecimal importe, Fichada fichada) {
		//Falta chequear el caso de fichada tren.
		if (this.lapsoDescuentoRedSube == null || this.lapsoDescuentoRedSube.yaTermino()) {
			this.lapsoDescuentoRedSube = this.crearNuevoLapso();
		}
		return this.lapsoDescuentoRedSube.aplicarDescuento(importe, fichada);
	}
		
}
