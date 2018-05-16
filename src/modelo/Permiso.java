package modelo;

public class Permiso {
	

	private String nombre;
	private String descripcion;
	private String codigo;
	
	public Permiso(String nombre, String descripcion, String codigo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public boolean equals(Permiso p) {
		boolean equivalente = false;
		
		if (p.getCodigo().compareTo(codigo)) {
			
			equivalente = true;
			
		}
		
		return equivalente;
	}
	
	
}
