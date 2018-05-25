package modelo.fichadas.colectivo
;
import modelo.fichadas.colectivo.LineaColectivo;

public class InternoColectivo {
	private LineaColectivo lineaColectivo ;
	private String nombre;
	public InternoColectivo(LineaColectivo lineaColectivo, String nombre) {
		super();
		this.lineaColectivo = lineaColectivo;
		this.nombre = nombre;
	}
	public LineaColectivo getLineaColectivo() {
		return lineaColectivo;
	}
	public void setLineaColectivo(LineaColectivo lineaColectivo) {
		this.lineaColectivo = lineaColectivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
