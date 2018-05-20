package test;

import java.util.GregorianCalendar;

import modelo.Documento;
import modelo.Documento.eTipoDocumento;
import modelo.Persona;
import modelo.Persona.eGenero;

public class TestPersona {

	public static void main(String[] args) {
		GregorianCalendar fecha = new GregorianCalendar (1993, 11, 16);
		try {
			Documento doc = new Documento ("37612478", eTipoDocumento.DNI);
			Persona per = new Persona ("Gonzalo", "Montana", doc, eGenero.M, fecha, "gonzamcomps@gmail.com", "1558912066", "42991823");
			System.out.println(per.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage() + e.getCause());
			e.printStackTrace();
		}
	}
}