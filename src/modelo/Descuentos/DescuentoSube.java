package modelo.Descuentos;
//SuperClase de descuentos
public abstract class DescuentoSube {
	
	private String nombre;
	
	public DescuentoSube( String nombre) {
		super();
		
		this.nombre = nombre;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float aplicarDescuento (float importe) {
		
		return importe;
	}

}
