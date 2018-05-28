package test;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import dao.DocumentoDao;
import dao.PersonaDao;
import dao.descuentos.DescuentoBoletoEstudiantilDao;
import modelo.Documento;
import modelo.eTipoDocumento;
import modelo.Descuentos.DescuentoBoletoEstudiantil;
import modelo.Descuentos.eTipoBoletoEstudiantil;
import modelo.Persona;
import modelo.TarjetaSube;
import modelo.eGenero;

public class TestPersona {

	public static void main(String[] args) {
		GregorianCalendar fecha = new GregorianCalendar (1993, 11, 16);
		try {
			
			PersonaDao daoPersona = new PersonaDao();
			DocumentoDao daoDocumento = new DocumentoDao();
			DescuentoBoletoEstudiantilDao daoBoletoEstudiantil = new DescuentoBoletoEstudiantilDao();
			GregorianCalendar cal = new GregorianCalendar(1993, 11, 16);
			
			Persona persona = new Persona("Gonzalo", "Montaña", eGenero.M, cal, "gonzamcomps@gmail.com", "1558912066", "42991823");
			Documento doc = persona.getDocumento();
	
			int idPersona = daoPersona.agregarPersona(persona);
			
			System.out.println("Guardamos el documento...");
			doc = new Documento("37612478", eTipoDocumento.DNI, persona);
			int idDoc = daoDocumento.agregarDocumento(doc);
			
			persona = daoPersona.traerPersona(idPersona);
			doc = persona.getDocumento();

			System.out.println("IdPersona : " + idPersona + " - IdDoc : " + idDoc);
			daoPersona.eliminarPersona(persona);
			
			//DescuentoBoletoEstudiantil dbe = new DescuentoBoletoEstudiantil(eTipoBoletoEstudiantil.ESCOLAR, persona);
			//int idDescuentoEstudiantil = daoBoletoEstudiantil.agregarDescuento(dbe);
			//Ahora levantamos y revisamos que funque.
			//doc = daoDocumento.traerDocumento(idDoc);
			
			//System.out.println(persona);

			/*
			TarjetaSube tarjeta = new TarjetaSube("1111", new BigDecimal(100));
			per.asociarTarjeta(tarjeta);
			per.desasociarTarjeta(tarjeta);
			per.asociarTarjeta(tarjeta);*/
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
}