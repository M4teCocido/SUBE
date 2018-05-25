package modelo.Descuentos;
import java.math.BigDecimal;

import modelo.Descuentos.DescuentoSube;
import modelo.fichadas.Fichada;

public class DescuentoTarifaSocial extends DescuentoSube{
	
	private BigDecimal porcentajeDescuento;

	public DescuentoTarifaSocial() {}
	
	public DescuentoTarifaSocial(String nombre, float porcentajeDescuento) {
		super(nombre);
		if (porcentajeDescuento > 1)
			porcentajeDescuento = 1 - (porcentajeDescuento / 100);
		this.porcentajeDescuento = new BigDecimal(porcentajeDescuento);
		//this.porcentajeDescuento = porcentajeDescuento;
	}
	
	public BigDecimal getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	
	public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	@Override
	public BigDecimal aplicarDescuento (BigDecimal importe, Fichada fichada) {//Toma el importe de la fichada y devuelve el importe aplicado el descuento
		/* 
		BigDecimal auxImporte = new BigDecimal (0);
		 auxImporte = importe;
		 
		 //importe=importe.multiply(this.porcentajeDescuento);
		 //importe=importe.divide(new BigDecimal (100));
		 //auxImporte = auxImporte.subtract(importe);
		 return auxImporte;
		 */
		return importe.multiply(this.porcentajeDescuento);
	}

	@Override
	public String toString() {
		return "DescuentoTarifaSocial [porcentajeDescuento=" + porcentajeDescuento.toString() + "]";
	}
	
}
