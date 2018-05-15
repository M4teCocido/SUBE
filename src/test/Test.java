package test;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

import modelo.*;
import modelo.Descuentos.DescuentoTarifaSocial;
import modelo.fichadas.Fichada;
import modelo.fichadas.TransaccionSUBE;
import modelo.fichadas.colectivo.FichadaColectivo;
import modelo.fichadas.colectivo.LineaColectivo;
import modelo.fichadas.colectivo.RamalColectivo;
import modelo.fichadas.colectivo.TramoColectivo;
import modelo.fichadas.subte.EstacionSubte;
import modelo.fichadas.subte.FichadaSubte;
import modelo.fichadas.subte.LineaSubte;
import modelo.fichadas.tren.FichadaTren;

public class Test {

	public static void main(String[] args) {
		Persona persona = new Persona();
		persona.asignarDescuentoTarifaSocial(new DescuentoTarifaSocial ("Descuento Tarifa Social", new BigDecimal (55)));
		
		TarjetaSube tarjeta = new TarjetaSube("9999",new BigDecimal (21));
		//tarjeta.setSaldo(new BigDecimal (21));
		tarjeta.setPropietario(persona);
		
		
		//Instacia de objetos para fichada subte--------------------------------------------------
		LineaSubte lineaC = new LineaSubte ("Linea C", new BigDecimal(11));						 
		EstacionSubte constitucion= new EstacionSubte("Constitucion", lineaC); 
		EstacionSubte moreno = new EstacionSubte("Moreno", lineaC); 
		lineaC.getRecorridoSubte().add(constitucion);
		lineaC.getRecorridoSubte().add(moreno);
		//Instancia de objetos para fichada Colectivo-----------------------------------------------------------------------------------------
		
		LineaColectivo l165 = new LineaColectivo ("165");
		RamalColectivo ramal3 = new RamalColectivo ( l165,"Ramal 3 por San Martin");
		TramoColectivo CruceAMonteGrande = new TramoColectivo ("Desde el cruce de Lomas hasta Est. Monte Grande", new BigDecimal (9),ramal3);
		
		//----------------------------------------------------------------------------------------------------------------------------
		FichadaSubte fichadaSubte = new FichadaSubte(FuncionesGregorian.traerFecha(1998, 07, 31),constitucion);
		//TransaccionSUBE transaccion = new TransaccionSUBE (fichadaSubte, new BigDecimal (11));
		tarjeta.procesarFichada(fichadaSubte);
		
		FichadaColectivo fichadaColectivo = new FichadaColectivo (FuncionesGregorian.traerFecha(1998, 06, 31));
		
		
		//--------------------------------------------------------------------------------------------------------------------------
		
		//Printeos
		System.out.println(persona.toString());
		System.out.println(lineaC.getRecorridoSubte().get(0));
		System.out.println(lineaC.getRecorridoSubte().get(1));
		System.out.println(fichadaSubte.toString());
		//System.out.println(transaccion.toString());
		System.out.println(tarjeta.getSaldo().toString());
		System.out.println(persona.getDescuentoTarifaSocial());
		System.out.println(tarjeta.getTransacciones().get(0));
		System.out.println(tarjeta.toString());
		
		
		
		
	}

	
	
}
