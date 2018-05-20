package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Usuario {

	private Set<Permiso> permisos;
	private String nombreUsuario;
	private String password;
	private Persona persona;
	
	public Usuario(String nombreUsuario, String password, Persona persona) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.persona = persona;
	}
	
	public Usuario() {}

	public void getPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}
	
	public Set<Permiso> getPermisos() {
		return this.permisos;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public boolean tienePermiso(Permiso permiso) {
		boolean encontrado = false;
		int i = 0;
		
		while ((encontrado == false)&&(i < permisos.size())){
			if (permisos.get(i).equals(permiso)) {
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}
	
	public boolean agregarPermiso (Permiso permiso) throws Exception{
		boolean agregado = false;
		
		if (this.tienePermiso(permiso) == true) {
			
			throw new Exception (" no se puede agregar porque ya posee este permiso. ");
			
		}
		
		agregado = permisos.add(permiso);	
		
		return agregado;
	}
		
	public boolean removerPermiso(Permiso permiso) throws Exception {
		boolean eliminado = false;
		int i = 0;
		
		if (this.tienePermiso(permiso) != true) {
			throw new Exception (" No se puede remover el permiso. ");
		}
		
		permisos.remove(permiso);
		
		/*while ((i < permisos.size())&&(eliminado == false)) {
			if (permisos.get(i).equals(permiso)) {
				permisos.remove(i);
				eliminado = true;
			}
			i++;
		}*/
		eliminado = true;
		return eliminado;
	}
}
