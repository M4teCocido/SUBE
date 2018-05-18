package modelo.fichadas.tren;

import java.util.ArrayList;
import java.util.List;

public class LineaTren {

	private String nombre;
	private List<RecorridoTren> recorridosTren;
	
	public LineaTren(String nombre) {
		super();
		this.nombre = nombre;
		this.recorridosTren = new ArrayList<RecorridoTren>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<RecorridoTren> getRecorridosTren() {
		return recorridosTren;
	}

	public void setRecorridosTren(List<RecorridoTren> recorridosTren) {
		this.recorridosTren = recorridosTren;
	}
	
}
