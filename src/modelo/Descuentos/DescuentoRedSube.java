package modelo.Descuentos;
import java.math.BigDecimal;

import modelo.Descuentos.*;

public class DescuentoRedSube extends DescuentoSube {
	private LapsoDescuentoRedSube lapsoDescuentoRedSube;
	
	
	
	public DescuentoRedSube(int prioridad, String nombre, LapsoDescuentoRedSube lapsoDescuentoRedSube) {
		super(prioridad, nombre);
		this.lapsoDescuentoRedSube = lapsoDescuentoRedSube;
	}



	public BigDecimal aplicarDescuento (BigDecimal importe) {
		
		return importe;
	}
	
	
	
}
