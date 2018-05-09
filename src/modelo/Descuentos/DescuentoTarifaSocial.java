package modelo.Descuentos;
import modelo.Descuentos.DescuentoSube;

public class DescuentoTarifaSocial extends DescuentoSube{
	
	private float porcentajeDescuento;
	
	public DescuentoTarifaSocial(int prioridad, String nombre, float porcentajeDescuento) {
		super(prioridad, nombre);
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	
}
