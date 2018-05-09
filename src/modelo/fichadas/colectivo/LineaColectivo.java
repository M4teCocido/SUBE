package modelo.fichadas.colectivo;

import java.util.List;

public class LineaColectivo {
	
	private String Nombre;
	private List<RamalColectivo>recorridosColectivo;

	public LineaColectivo(String nombre) {
		super();
		Nombre = nombre;
	}

	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public List<RamalColectivo> getRecorridosColectivo() {
		return recorridosColectivo;
	}

	public void setRecorridosColectivo(List<RamalColectivo> recorridosColectivo) {
		this.recorridosColectivo = recorridosColectivo;
	}

	@Override
	public String toString() {
		return "LineaColectivo [Nombre=" + Nombre + "]";
	}	
	
}
