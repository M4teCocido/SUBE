package test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import java.util.Set;

import modelo.*;
import modelo.Descuentos.DescuentoTarifaSocial;
import modelo.fichadas.Fichada;
import modelo.fichadas.TransaccionSUBE;
import modelo.fichadas.colectivo.FichadaColectivo;
import modelo.fichadas.colectivo.LineaColectivo;

import modelo.fichadas.subte.EstacionSubte;
import modelo.fichadas.subte.FichadaSubte;
import modelo.fichadas.subte.LineaSubte;
import modelo.fichadas.tren.EstacionTren;
import modelo.fichadas.tren.FichadaTren;
import modelo.fichadas.tren.LineaTren;

import modelo.fichadas.tren.SeccionTren;
import modelo.fichadas.tren.ViajeTren;
import modelo.fichadas.tren.FichadaTren.eTipoFichadaTren;
import util.FuncionesGregorian;

public class TestA {

	public static void main(String[] args) {
		Persona persona = new Persona();
		persona.asignarDescuentoTarifaSocial(new DescuentoTarifaSocial ("Descuento Tarifa Social", 55));
		
		TarjetaSube tarjeta = new TarjetaSube("9999",new BigDecimal (200));
		//tarjeta.setSaldo(new BigDecimal (21));
		tarjeta.setPropietario(persona);
		
		
		//Instancia de objetos para fichada subte--------------------------------------------------
		LineaSubte lineaC = new LineaSubte ("Linea C", new BigDecimal(11));						 
		EstacionSubte constitucion= new EstacionSubte("Constitucion", lineaC); 
		EstacionSubte moreno = new EstacionSubte("Moreno", lineaC); 
		lineaC.getRecorridoSubte().add(constitucion);
		lineaC.getRecorridoSubte().add(moreno);
		//Instancia de objetos para fichada Colectivo-----------------------------------------------------------------------------------------
		
		LineaColectivo l165 = new LineaColectivo ("165");
	
	
		
		//Instancia Objetos Fichada Tren
		LineaTren roca = new LineaTren ("Roca");
		
		EstacionTren constitucionTren = new EstacionTren("Constitucion", roca); 
		EstacionTren lanusTren = new EstacionTren("Lanus", roca);
		EstacionTren aKornTren = new EstacionTren ("A. Korn", roca);
		
		
		
		SeccionTren primeraSeccion = new SeccionTren ("Primera Seccion", new BigDecimal(2),roca);
		roca.getSecciones().add(primeraSeccion);
		SeccionTren segundaSeccion = new SeccionTren ("Segunda Seccion", new BigDecimal(3),roca);
		roca.getSecciones().add(segundaSeccion);
		SeccionTren terceraSeccion = new SeccionTren ("Tercera Seccion", new BigDecimal(4),roca);
		roca.getSecciones().add(terceraSeccion);
		
		ViajeTren viajeA = new ViajeTren (constitucionTren,lanusTren, primeraSeccion,roca);
		roca.getViajes().add(viajeA);
		ViajeTren viajeB = new ViajeTren (constitucionTren, aKornTren, terceraSeccion,roca);
		roca.getViajes().add(viajeA);
		
		
		
		
		
		//Instancio Fichada tren-----------------------------------------------------------------------------------------
		
		System.out.println("Caso de uso a");
		
		FichadaTren fichadaPruebaA = new FichadaTren (new GregorianCalendar(2018, 3, 6, 13,10,00),constitucionTren, eTipoFichadaTren.ENTRADA);
		TransaccionSUBE transaccion = tarjeta.procesarFichada(fichadaPruebaA);
	
		
		FichadaTren fichadaPruebaB = new FichadaTren (new GregorianCalendar(2018, 3, 6, 17,10,00), lanusTren, eTipoFichadaTren.SALIDA);
		transaccion = tarjeta.procesarFichada(fichadaPruebaB);
	  
	    FichadaTren fichadaPruebaC = new FichadaTren (new GregorianCalendar (2018, 3, 6, 18,10,00), aKornTren, eTipoFichadaTren.SALIDA);
	    transaccion =  tarjeta.procesarFichada(fichadaPruebaC);
	    
	    System.out.println("Caso de uso b)");
	    
	    
	    FichadaTren fichadaPruebaD = new FichadaTren (new GregorianCalendar(2018, 3, 6, 19,10,00), lanusTren, eTipoFichadaTren.ENTRADA);
		transaccion = tarjeta.procesarFichada(fichadaPruebaD);
	  
		  FichadaTren fichadaPruebaE = new FichadaTren (new GregorianCalendar(2018, 3, 6, 23,10,00), lanusTren, eTipoFichadaTren.SALIDA);
			transaccion = tarjeta.procesarFichada(fichadaPruebaE);
		  
	    
	    for (TransaccionSUBE t : tarjeta.getTransacciones()) {
	    	System.out.println(t.toString());
	    }
	    
	    
	    
	
		
	}

	
	
}
