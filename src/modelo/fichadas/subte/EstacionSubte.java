package modelo.fichadas.subte;

import java.util.ArrayList;
import java.util.List;

public class EstacionSubte {
	
	private String nombre;
	private LineaSubte lineaSubte;
	private List<EstacionSubte>estaciones;
	
	public EstacionSubte(String nombre, LineaSubte lineaSubte) {
		super();
		this.nombre = nombre;
		this.lineaSubte = lineaSubte;
		this.estaciones = new ArrayList<EstacionSubte>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public LineaSubte getLineaSubte() {
		return lineaSubte;
	}
	
	public void setLineaSubte(LineaSubte lineaSubte) {
		this.lineaSubte = lineaSubte;
	}
	
	@Override
	public String toString() {
		return "EstacionSubte [nombre=" + nombre + ", lineaSubte=" + lineaSubte + ", estaciones=" + estaciones + "]";
	}
	
}
