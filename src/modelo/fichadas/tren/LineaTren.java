package modelo.fichadas.tren;

import java.util.List;

public class LineaTren {

	private String nombre;
	private List<RecorridoTren> recorridosTren;
	
	public LineaTren(String nombre, List<RecorridoTren> recorridosTren) {
		super();
		this.nombre = nombre;
		this.recorridosTren = recorridosTren;
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
