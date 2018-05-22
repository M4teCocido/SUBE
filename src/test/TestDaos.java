package test;

import java.util.GregorianCalendar;

import modelo.Documento;
import modelo.Documento.eTipoDocumento;
//import modelo.Persona.eGenero;
import modelo.eGenero;
import modelo.Permiso;
import modelo.Persona;
import modelo.Usuario;
import modelo.dao.DocumentoDao;
import modelo.dao.PermisoDao;
import modelo.dao.PersonaDao;
import modelo.dao.UsuarioDao;

public class TestDaos {

	public static void main(String[] args) {
		
		/*PermisoDao dao = new PermisoDao();
		Permiso permiso = new Permiso("Permiso 1", "Test del permiso", "1111");
		dao.agregarPermiso(permiso);*/
		
		try {
			UsuarioDao dao2 = new UsuarioDao();
			Documento doc = new Documento("37612478", eTipoDocumento.DNI);
			DocumentoDao dao4 = new DocumentoDao();
			dao4.agregarDocumento(doc);
			GregorianCalendar cal = new GregorianCalendar(1993, 11, 16);
			Persona persona = new Persona("Gonzalo", "Montaña", doc, eGenero.M, cal, "gonzamcomps@gmail.com", "1558912066", "42991823");
			PersonaDao dao3 = new PersonaDao();
			dao3.agregarPersona(persona);
			Usuario usuario = new Usuario("Gonzalocapo", "capomal", persona);
			dao2.agregarUsuario(usuario);
		} catch (Exception e) {
			System.out.println(e.getMessage() + e.getCause());
			e.printStackTrace();
		}
		
		/*Permiso permiso2 = dao.traerPermiso(1);
		permiso2.setNombre("Nombre modificado");
		permiso2.setDescripcion("Modificado correctamente");
		permiso2.setCodigo("2222");
		dao.modificarPermiso(permiso2);
		dao.eliminarPermiso(permiso2);*/
		
		/*try {
			DocumentoDao dao3 = new DocumentoDao();
			Documento documento = new Documento("37612478", eTipoDocumento.DNI);
			dao3.agregarDocumento(documento);
		} catch (Exception e) {
			System.out.println(e.getMessage() + e.getCause());
			e.printStackTrace();
		}*/
	}
}
