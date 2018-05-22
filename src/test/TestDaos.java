package test;

import modelo.Documento;
import modelo.Documento.eTipoDocumento;
import modelo.Permiso;
import modelo.Persona;
import modelo.Usuario;
import modelo.dao.DocumentoDao;
import modelo.dao.PermisoDao;
import modelo.dao.UsuarioDao;

public class TestDaos {

	public static void main(String[] args) {
		/*PermisoDao dao = new PermisoDao();
		Permiso permiso = new Permiso("Permiso 1", "Test del permiso", "1111");
		dao.agregarPermiso(permiso);
		Permiso permiso2 = dao.traerPermiso(1);
		permiso2.setNombre("Nombre modificado");
		permiso2.setDescripcion("Modificado correctamente");
		permiso2.setCodigo("2222");
		dao.modificarPermiso(permiso2);
		dao.eliminarPermiso(permiso2);
		*/
		/*UsuarioDao dao2 = new UsuarioDao();
		Persona persona = new Persona();
		Usuario usuario = new Usuario("Gonzalocapo", "capomal", persona);
		dao2.agregarUsuario(usuario);*/
		try {
			DocumentoDao dao3 = new DocumentoDao();
			Documento documento = new Documento("37612478", eTipoDocumento.DNI);
			dao3.agregarDocumento(documento);
		} catch (Exception e) {
			System.out.println(e.getMessage() + e.getCause());
			e.printStackTrace();
		}
	}
}
