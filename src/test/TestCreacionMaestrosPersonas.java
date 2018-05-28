package test;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import dao.DocumentoDao;
import dao.PersonaDao;
import dao.TarjetaSubeDao;
import dao.descuentos.DescuentoBoletoEstudiantilDao;
import dao.descuentos.DescuentoTarifaSocialDao;
import dao.fichadas.subte.EstacionSubteDao;
import dao.lectoras.LectoraSubteDao;
import modelo.Documento;
import modelo.eTipoDocumento;
import modelo.Descuentos.DescuentoBoletoEstudiantil;
import modelo.Descuentos.DescuentoTarifaSocial;
import modelo.Descuentos.eTipoBoletoEstudiantil;
import modelo.fichadas.FichadaRecarga;
import modelo.fichadas.subte.EstacionSubte;
import modelo.fichadas.subte.FichadaSubte;
import modelo.lectoras.LectoraSubte;
import modelo.Persona;
import modelo.TarjetaSube;
import modelo.eGenero;

public class TestCreacionMaestrosPersonas {

	public static void main(String[] args) {
		GregorianCalendar fecha = new GregorianCalendar (1993, 11, 16);
		
			
		PersonaDao daoPersona = new PersonaDao();
		DocumentoDao daoDocumento = new DocumentoDao();
		DescuentoBoletoEstudiantilDao daoBoletoEstudiantil = new DescuentoBoletoEstudiantilDao();
		DescuentoTarifaSocialDao daoTarifaSocial = new DescuentoTarifaSocialDao();
		TarjetaSubeDao daoTarjeta = new TarjetaSubeDao();
		EstacionSubteDao daoEstacionSubte = new EstacionSubteDao();
		LectoraSubteDao daoLectoraSubte = new LectoraSubteDao();
		
		Persona persona;
		Documento doc;
		DescuentoTarifaSocial descuentoTarifaSocial;
		DescuentoBoletoEstudiantil dbe;
		TarjetaSube tarjeta1;
		TarjetaSube tarjeta2;
		EstacionSubte estacionSubte;
		LectoraSubte lectora;
		
		try {
			//Creamos los objetos
			estacionSubte = daoEstacionSubte.traerEstacion(1);
			lectora = daoLectoraSubte.traerLectora(1);
			persona = new Persona("Gonzalo", "Montaña", eGenero.M, fecha, "gonzamcomps@gmail.com", "1558912066", "42991823");
			doc = new Documento("37612478", eTipoDocumento.DNI, persona);
			descuentoTarifaSocial = new DescuentoTarifaSocial(persona);
			dbe = new DescuentoBoletoEstudiantil(eTipoBoletoEstudiantil.ESCOLAR, persona);
			tarjeta1 = new TarjetaSube("TARJETA1", 100);
			tarjeta1.setPropietario(persona);
			tarjeta2 = new TarjetaSube("TARJETA2", 200);
			tarjeta2.setPropietario(persona);
			tarjeta2.procesarFichada(new FichadaSubte(new GregorianCalendar(), lectora, estacionSubte));
			tarjeta2.procesarFichada(new FichadaSubte(new GregorianCalendar(), lectora, estacionSubte));
			tarjeta2.procesarFichada(new FichadaSubte(new GregorianCalendar(), lectora, estacionSubte));
			//tarjeta2.procesarFichada(new FichadaSubte(new GregorianCalendar(), null, estacionSubte));
			//Persistimos
			int idPersona = daoPersona.agregarPersona(persona);
			int idDoc = daoDocumento.agregarDocumento(doc);
			int idTarifaSocial = daoTarifaSocial.agregarDescuento(descuentoTarifaSocial);
			int idBoletoEstudiantil = daoBoletoEstudiantil.agregarDescuento(dbe);
			int idTarjeta1 = daoTarjeta.agregarTarjetaSube(tarjeta1);
			int idTarjeta2 = daoTarjeta.agregarTarjetaSube(tarjeta2);
			//Traemos la persona y chequeamos si trae todo.
			persona = daoPersona.traerPersona(idPersona);
			System.out.println("Persona persistida : " + persona.toString());
			tarjeta1 = daoTarjeta.traerTarjeta(idTarjeta1);
			tarjeta2 = daoTarjeta.traerTarjeta(idTarjeta2);
			System.out.println("Tarjeta1 persistida : " + tarjeta1.toString());
			System.out.println("Tarjeta2 persistida : " + tarjeta2.toString());
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}