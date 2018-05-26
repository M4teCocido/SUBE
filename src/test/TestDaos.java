package test;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import dao.DocumentoDao;
import dao.PermisoDao;
import dao.PersonaDao;
import dao.TarjetaSubeDao;
import dao.UsuarioDao;
import dao.fichadas.TransaccionSUBEDao;
import modelo.Documento;
import modelo.eTipoDocumento;
import modelo.fichadas.TransaccionSUBE;
//import modelo.Persona.eGenero;
import modelo.eGenero;
import modelo.Permiso;
import modelo.Persona;
import modelo.TarjetaSube;
import modelo.Usuario;


public class TestDaos {

	public static void main(String[] args) {
		
		/*PermisoDao dao = new PermisoDao();
		Permiso permiso = new Permiso("Permiso 1", "Test del permiso", "1111");
		dao.agregarPermiso(permiso);*/
		
		try {
			/*UsuarioDao daoUsuario = new UsuarioDao();
			PersonaDao daoPersona = new PersonaDao();
			DocumentoDao daoDocumento = new DocumentoDao();
			GregorianCalendar cal = new GregorianCalendar(1993, 11, 16);

			//Creamos y Guardamos
			Persona persona = new Persona("Gonzalo", "Montaña", eGenero.M, cal, "gonzamcomps@gmail.com", "1558912066", "42991823");
			int idPersona = daoPersona.agregarPersona(persona);
			Documento doc = new Documento("37612478", eTipoDocumento.DNI, persona);
			int idDoc = daoDocumento.agregarDocumento(doc);
			//Ahora levantamos y revisamos que funque.
			doc = daoDocumento.traerDocumento(idDoc);
			persona = daoPersona.traerPersona(idPersona);
			//System.out.println(persona);
			
			UsuarioDao daousuario = new UsuarioDao();
			Usuario usuario = new Usuario("Gonzalocapo", "capomal", persona);
			int idUsuario = daoUsuario.agregarUsuario(usuario);
			usuario = daoUsuario.traerUsuarioPorId(idUsuario);*/
			
			//----------------------------TEST TARJETA SUBE----------------------------
			/*TarjetaSubeDao daoTarjeta = new TarjetaSubeDao();
			TarjetaSube tarjeta = new TarjetaSube("11111", new BigDecimal (100));
			daoTarjeta.agregarTarjetaSube(tarjeta);
			int idTarjeta = daoTarjeta.agregarTarjetaSube(tarjeta);
			tarjeta = daoTarjeta.traerTarjeta(idTarjeta);
			System.out.println(tarjeta);*/
			//----------------------------TEST TRANSACCION----------------------------
			TransaccionSUBEDao daoTransaccion = new TransaccionSUBEDao();
			//FALTA MAPEAR FICHADAS
			TransaccionSUBE transaccion = new TransaccionSUBE();
		} catch (Exception e) {
			//System.out.println(e.getMessage() + e.getCause());
			
			e.printStackTrace();
		}
	}
}
