package modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private List<Permiso> permisos;
	private String nombreUsuario;
	private String password;
	private Persona persona;
		
	public Usuario(String nombreUsuario, String password, Persona persona) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.persona = persona;
		this.permisos = new ArrayList<Permiso>();
	}
	
	public boolean agregarPermiso(Permiso permiso) {
		return true;
	}	
	
	public boolean removerPermiso (Permiso permiso) {
		return true;
	}

	public List<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
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

}
