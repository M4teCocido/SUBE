package modelo.fichadas.subte;
import modelo.fichadas.subte.LineaSubte;

public class EstacionSubte {
	
	private String nombre;
	private LineaSubte lineaSubte;
	
	public EstacionSubte(String nombre, LineaSubte lineaSubte) {
		super();
		this.nombre = nombre;
		this.lineaSubte = lineaSubte;
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
		return "EstacionSubte [nombre=" + nombre + ", lineaSubte=" + lineaSubte + "]";
	}
	
}
