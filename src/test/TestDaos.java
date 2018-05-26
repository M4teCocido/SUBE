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
import dao.fichadas.subte.FichadaSubteDao;
import modelo.Documento;
import modelo.eTipoDocumento;
import modelo.fichadas.Fichada;
import modelo.fichadas.TransaccionSUBE;
import modelo.fichadas.subte.EstacionSubte;
import modelo.fichadas.subte.FichadaSubte;
import modelo.fichadas.subte.LineaSubte;
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
			TransaccionSUBEDao daoTransaccion = new TransaccionSUBEDao();
			FichadaSubteDao daoFichada = new FichadaSubteDao();
            TarjetaSubeDao daoTarjeta = new TarjetaSubeDao();
            
			GregorianCalendar cal = new GregorianCalendar(2018, 4, 25, 15, 25, 33);
            LineaSubte linea = new LineaSubte("A", new BigDecimal(8));
            EstacionSubte estacion = new EstacionSubte("Carabobo", linea);
            FichadaSubte fichada = new FichadaSubte(cal, estacion);
            TarjetaSube tarjeta = new TarjetaSube("7515131531", new BigDecimal(6));

            daoFichada.agregarFichada(fichada);
            daoTarjeta.agregarTarjetaSube(tarjeta);
            
            TransaccionSUBE transaccion = new TransaccionSUBE(fichada, new BigDecimal (5), tarjeta);
            int idTransaccion = daoTransaccion.agregarTransaccion(transaccion);
            transaccion = daoTransaccion.traerTransaccion(idTransaccion);
			/*UsuarioDao daoUsuario = new UsuarioDao();
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
			//TransaccionSUBEDao daoTransaccion = new TransaccionSUBEDao();
			//FALTA MAPEAR FICHADAS
			//TransaccionSUBE transaccion = new TransaccionSUBE();
		} catch (Exception e) {
			System.out.println(e.getMessage() + ", " + e.getCause());
			
			e.printStackTrace();
		}
	}
}
