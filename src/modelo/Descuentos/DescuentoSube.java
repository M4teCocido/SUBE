package modelo.Descuentos;

import java.math.BigDecimal;

import modelo.fichadas.Fichada;

//SuperClase de descuentos
public abstract class DescuentoSube {
	
	private String nombre;
	
	public DescuentoSube(String nombre) {
		super();
		this.nombre = nombre;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal aplicarDescuento (BigDecimal importe, Fichada fichada) {
		return importe;
	}

}
