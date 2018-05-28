package test;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import dao.DocumentoDao;
import dao.PersonaDao;
import dao.descuentos.DescuentoBoletoEstudiantilDao;
import dao.descuentos.DescuentoTarifaSocialDao;
import modelo.Documento;
import modelo.eTipoDocumento;
import modelo.Descuentos.DescuentoBoletoEstudiantil;
import modelo.Descuentos.DescuentoTarifaSocial;
import modelo.Descuentos.eTipoBoletoEstudiantil;
import modelo.Persona;
import modelo.TarjetaSube;
import modelo.eGenero;

public class TestPersona {

	public static void main(String[] args) {
		GregorianCalendar fecha = new GregorianCalendar (1993, 11, 16);
		
			
		PersonaDao daoPersona = new PersonaDao();
		DocumentoDao daoDocumento = new DocumentoDao();
		DescuentoBoletoEstudiantilDao daoBoletoEstudiantil = new DescuentoBoletoEstudiantilDao();
		DescuentoTarifaSocialDao daoTarifaSocial = new DescuentoTarifaSocialDao();
		
		Persona persona;
		Documento doc;
		DescuentoTarifaSocial descuentoTarifaSocial;
		DescuentoBoletoEstudiantil dbe;
		try {
			//Creamos los objetos
			persona = new Persona("Gonzalo", "Montaña", eGenero.M, fecha, "gonzamcomps@gmail.com", "1558912066", "42991823");
			doc = new Documento("37612478", eTipoDocumento.DNI, persona);
			descuentoTarifaSocial = new DescuentoTarifaSocial(persona);
			dbe = new DescuentoBoletoEstudiantil(eTipoBoletoEstudiantil.ESCOLAR, persona);
			
			//Persistimos
			int idPersona = daoPersona.agregarPersona(persona);
			int idDoc = daoDocumento.agregarDocumento(doc);
			int idTarifaSocial = daoTarifaSocial.agregarDescuento(descuentoTarifaSocial);
			int idBoletoEstudiantil = daoBoletoEstudiantil.agregarDescuento(dbe);
			
			//Traemos la persona y chequeamos si trae todo.
			persona = daoPersona.traerPersona(idPersona);
			System.out.println("Persona persistida : " + persona.toString());

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}