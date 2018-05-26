package test;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import dao.DocumentoDao;

import dao.PersonaDao;
import dao.UsuarioDao;
import modelo.Documento;
import modelo.eTipoDocumento;
import modelo.Descuentos.DescuentoBoletoEstudiantil;

import dao.PermisoDao;
import dao.PersonaDao;
import dao.TarjetaSubeDao;
import dao.UsuarioDao;
import dao.fichadas.TransaccionSUBEDao;
import modelo.Documento;
import modelo.eTipoDocumento;
import modelo.fichadas.Fichada;
import modelo.fichadas.TransaccionSUBE;

//import modelo.Persona.eGenero;
import modelo.eGenero;
import modelo.Permiso;
import modelo.Persona;
import modelo.TarjetaSube;
import modelo.Usuario;


public class TestDaos {

	public static void main(String[] args) {
		
		try {
			//------------------------TEST PERMISO-----------------------------------
			/*PermisoDao daoPermiso = new PermisoDao();
			Permiso permiso = new Permiso("Permiso 1", "Test del permiso", "1111");
			daoPermiso.agregarPermiso(permiso);
			//------------------------TEST PERSONA Y DOCUMENTO-----------------------
			PersonaDao daoPersona = new PersonaDao();
			DocumentoDao daoDocumento = new DocumentoDao();
			GregorianCalendar fechaNac = new GregorianCalendar(1993, 11, 16);
			//Creamos y Guardamos
			Persona persona = new Persona("Gonzalo", "Montaña", eGenero.M, fechaNac, "gonzamcomps@gmail.com", "1558912066", "42991823");
			int idPersona = daoPersona.agregarPersona(persona);
			Documento doc = new Documento("37612478", eTipoDocumento.DNI, persona);
			int idDoc = daoDocumento.agregarDocumento(doc);
			//DescuentoBoletoEstudiantil dbe = new DescuentoBoletoEstudiantil(DescuentoBoletoEstudiantil.eTipoBoletoEstudiantil.ESCOLAR);
			//int idDescuentoEstudiantil;
			//Ahora levantamos y revisamos que funque.
			doc = daoDocumento.traerDocumento(idDoc);
			persona = daoPersona.traerPersona(idPersona);
			//---------------------------TEST USUARIO----------------------------------
			UsuarioDao daoUsuario = new UsuarioDao();
			Usuario usuario = new Usuario("Gonzalocapo", "capomal", persona);
			int idUsuario = daoUsuario.agregarUsuario(usuario);
			usuario = daoUsuario.traerUsuarioPorId(idUsuario);
			//----------------------------TEST TARJETA SUBE----------------------------
			TarjetaSubeDao daoTarjeta = new TarjetaSubeDao();
			TarjetaSube tarjeta = new TarjetaSube("11111", new BigDecimal (100));
			int idTarjeta = daoTarjeta.agregarTarjetaSube(tarjeta);
			tarjeta = daoTarjeta.traerTarjeta(idTarjeta);*/
			//----------------------------TEST TRANSACCION Y FICHADA----------------------------
			TransaccionSUBEDao daoTransaccion = new TransaccionSUBEDao();
            GregorianCalendar cal = new GregorianCalendar(2018, 4, 25, 15, 25, 33);
            Fichada fichada = new Fichada(cal) {};
            TransaccionSUBE transaccion = new TransaccionSUBE(fichada, new BigDecimal (5));
            int idTransaccion = daoTransaccion.agregarTransaccion(transaccion);
            transaccion = daoTransaccion.traerTransaccion(idTransaccion);
            TarjetaSubeDao daoTarjeta2 = new TarjetaSubeDao();
            //TarjetaSube tarjeta2 = new TarjetaSube(, )
            System.out.println(transaccion);
            //-----------------------------TEST NO SE--------------------------------------------
		} catch (Exception e) {
			System.out.println(e.getMessage() + ", " + e.getCause());
			
			e.printStackTrace();
		}
	}
}
