package modelo.Descuentos;
import java.math.BigDecimal;

import modelo.fichadas.Fichada;

public class DescuentoRedSube extends DescuentoSube {
	
	private LapsoDescuentoRedSube lapsoDescuentoRedSube;
	
	public DescuentoRedSube(String nombre) {
		super(nombre);
		this.lapsoDescuentoRedSube = new LapsoDescuentoRedSube();
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
		return importe;
	}
		
}
