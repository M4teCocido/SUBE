package modelo.fichadas.tren;
import modelo.fichadas.tren.RecorridoTren;

public class EstacionTren {
	
	private int idEstacion;
	private String nombre;
	private RecorridoTren recorridoTren;

	public EstacionTren() {}
	
	public EstacionTren(String nombre, RecorridoTren recorridoTren) {
		super();
		this.nombre = nombre;
		this.recorridoTren = recorridoTren;
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
	
	public RecorridoTren getRecorridoTren() {
		return recorridoTren;
	}
	
	public void setRecorridoTren(RecorridoTren recorridoTren) {
		this.recorridoTren = recorridoTren;
	}
<<<<<<< HEAD

	@Override
	public String toString() {
		return  nombre;
	}
	
}
=======
}
>>>>>>> 48293e0c43317a421a5462e46f9cd600331bf6d5
