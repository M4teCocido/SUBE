package test;

import java.util.GregorianCalendar;

import dao.DocumentoDao;
import dao.PersonaDao;
import dao.UsuarioDao;
import modelo.Documento;
import modelo.eTipoDocumento;
import modelo.Descuentos.DescuentoBoletoEstudiantil;
//import modelo.Persona.eGenero;
import modelo.eGenero;
import modelo.Permiso;
import modelo.Persona;
import modelo.Usuario;

public class TestDaos {

	public static void main(String[] args) {
		
		/*PermisoDao dao = new PermisoDao();
		Permiso permiso = new Permiso("Permiso 1", "Test del permiso", "1111");
		dao.agregarPermiso(permiso);*/
		
		try {
			UsuarioDao daoUsuario = new UsuarioDao();
			PersonaDao daoPersona = new PersonaDao();
			DocumentoDao daoDocumento = new DocumentoDao();
			GregorianCalendar cal = new GregorianCalendar(1993, 11, 16);

			//Creamos y Guardamos
			Persona persona = new Persona("Gonzalo", "Montaña", eGenero.M, cal, "gonzamcomps@gmail.com", "1558912066", "42991823");
			int idPersona = daoPersona.agregarPersona(persona);
			Documento doc = new Documento("37612478", eTipoDocumento.DNI, persona);
			int idDoc = daoDocumento.agregarDocumento(doc);
			DescuentoBoletoEstudiantil dbe = new DescuentoBoletoEstudiantil(DescuentoBoletoEstudiantil.eTipoBoletoEstudiantil.ESCOLAR);
			int idDescuentoEstudiantil;
			//Ahora levantamos y revisamos que funque.
			doc = daoDocumento.traerDocumento(idDoc);
			persona = daoPersona.traerPersona(idPersona);
			System.out.println(persona);
			
			//Usuario usuario = new Usuario("Gonzalocapo", "capomal", persona);
			//dao2.agregarUsuario(usuario);
		} catch (Exception e) {
			System.out.println(e.getMessage() + ", " + e.getCause());
			
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
