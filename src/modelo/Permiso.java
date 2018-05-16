package modelo;

public class Permiso {
	

	private int idPermiso;
	private String nombre;
	private String descripcion;
	private String codigo;
	
	public Permiso(int id, String nombre, String descripcion, String codigo) {
		this.idPermiso = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codigo = codigo;
	}
	

	public int getIdPermiso() {
		return idPermiso;
	}



	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
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

	public boolean equals(Permiso p) {
		boolean equivalente = false;
		
		if ((p.getCodigo().compareTo(codigo) == 0)) {
			
			equivalente = true;
			
		}
		
		return equivalente;
	}
	
	
}
