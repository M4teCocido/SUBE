package modelo.fichadas.colectivo;

import java.util.List;

public class LineaColectivo {
	private String Nombre;
	private List<RamalColectivo>recorridosColectivo;

	public LineaColectivo(String nombre) {
		super();
		Nombre = nombre;
	}

	@Override
	public String toString() {
		return "LineaColectivo [Nombre=" + Nombre + "]";
	}	
	
	
}
