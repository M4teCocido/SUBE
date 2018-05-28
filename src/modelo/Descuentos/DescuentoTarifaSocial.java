package modelo.Descuentos;
import java.math.BigDecimal;
import java.math.RoundingMode;

import modelo.Persona;
import modelo.Descuentos.DescuentoSube;
import modelo.fichadas.Fichada;

public class DescuentoTarifaSocial extends DescuentoSube{
	
	private BigDecimal porcentajeDescuento;
	private Persona persona;
	
	public DescuentoTarifaSocial() {}
	
	public DescuentoTarifaSocial(Persona persona) {
		super("Tarifa Social");
		this.porcentajeDescuento = new BigDecimal(0.45).setScale(4, RoundingMode.HALF_UP);
		this.persona = persona;
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
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "DescuentoTarifaSocial [porcentajeDescuento=" + porcentajeDescuento.toString() + "]";
	}
	
}
