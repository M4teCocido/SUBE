package modelo.Descuentos;
import java.math.BigDecimal;

import modelo.Descuentos.DescuentoSube;

public class DescuentoTarifaSocial extends DescuentoSube{
	
	private BigDecimal porcentajeDescuento;
	
	public DescuentoTarifaSocial(String nombre, BigDecimal porcentajeDescuento) {
		super(nombre);
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	public BigDecimal getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	
	public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public BigDecimal aplicarDescuento (BigDecimal importe) {
		 importe.multiply(this.porcentajeDescuento);
		 importe.divide(new BigDecimal (100));
		 return importe;
	}

	@Override
	public String toString() {
		return "DescuentoTarifaSocial [porcentajeDescuento=" + porcentajeDescuento + "]";
	}
	
}
