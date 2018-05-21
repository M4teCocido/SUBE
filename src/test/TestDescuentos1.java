package test;

import java.math.BigDecimal;
import java.util.GregorianCalendar;


import modelo.Persona;
import modelo.TarjetaSube;
import modelo.Descuentos.DescuentoBoletoEstudiantil;
import modelo.Descuentos.DescuentoTarifaSocial;
import modelo.fichadas.subte.EstacionSubte;
import modelo.fichadas.subte.FichadaSubte;
import modelo.fichadas.subte.LineaSubte;

public class TestDescuentos1 {

	public static void main(String[] args) throws Exception{
		Persona persona = new Persona();
		
		
		TarjetaSube tarjeta = new TarjetaSube("9999",new BigDecimal (21));
		//tarjeta.setSaldo(new BigDecimal (21));
		tarjeta.setPropietario(persona);
		
		LineaSubte lineaC = new LineaSubte ("Linea C", new BigDecimal(11));						 
		EstacionSubte constitucion= new EstacionSubte("Constitucion", lineaC); 
		EstacionSubte moreno = new EstacionSubte("Moreno", lineaC); 
		lineaC.getRecorridoSubte().add(constitucion);
		lineaC.getRecorridoSubte().add(moreno);
		
		FichadaSubte f1 = new FichadaSubte(new GregorianCalendar(), constitucion);
		
		persona.asignarDescuentoTarifaSocial(new DescuentoTarifaSocial ("Descuento Tarifa Social", new BigDecimal (55)));
		
		FichadaSubte f2 = new FichadaSubte(new GregorianCalendar(), constitucion);
		
		persona.asignarDescuentoBoletoEstudiantil(new DescuentoBoletoEstudiantil (DescuentoBoletoEstudiantil.eTipoBoletoEstudiantil.ESCOLAR));
		
		FichadaSubte f3 = new FichadaSubte(new GregorianCalendar(), constitucion);
		
	}
	
	
	
}
