package modelo.fichadas.tren;
import modelo.fichadas.tren.LineaTren;

public class EstacionTren {
	
	private int idEstacion;
	private String nombre;
	private LineaTren linea;

	public EstacionTren() {}
	
	public EstacionTren(String nombre, LineaTren linea) {
		super();
		this.nombre = nombre;
		this.linea = linea;
	}

	public int getIdEstacion() {
		return this.idEstacion;
	}
	
	protected void setIdEstacion(int idEstacion) {
		this.idEstacion = idEstacion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public LineaTren getLinea() {
		return linea;
	}
	
	public void setLinea(LineaTren linea) {
		this.linea = linea;
	}

	@Override
	public String toString() {
		return  nombre;
	}
	
}

