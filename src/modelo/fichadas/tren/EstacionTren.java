package modelo.fichadas.tren;
import modelo.fichadas.tren.RecorridoTren;

public class EstacionTren {
	
	private String nombre;
	private RecorridoTren recorridoTren;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public RecorridoTren getRecorridoTren() {
		return recorridoTren;
	}
	
	public void setRecorridoTren(RecorridoTren recorridoTren) {
		this.recorridoTren = recorridoTren;
	}

}
