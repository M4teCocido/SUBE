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
import modelo.fichadas.colectivo.RamalColectivo;
import modelo.fichadas.colectivo.TramoColectivo;
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
		RamalColectivo ramal3 = new RamalColectivo ( l165,"Ramal 3 por San Martin");
		TramoColectivo cruceAMonteGrande = new TramoColectivo ("Desde el cruce de Lomas hasta Est. Monte Grande", new BigDecimal (9),ramal3);
		
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
		
		tarjeta.getSaldo().toString();
		
		
		
		//Instancio Fichada tren-----------------------------------------------------------------------------------------
		
		FichadaTren fichadaPruebaA = new FichadaTren (FuncionesGregorian.traerFecha(2018, 03, 6),constitucionTren, eTipoFichadaTren.ENTRADA);
		
		TransaccionSUBE transaccion = tarjeta.procesarFichada(fichadaPruebaA);
		//System.out.println( tarjeta.getSaldo().toString());
		
		FichadaTren fichadaPruebaB = new FichadaTren (FuncionesGregorian.traerFecha(2018, 03, 6), lanusTren, eTipoFichadaTren.SALIDA);
		transaccion = tarjeta.procesarFichada(fichadaPruebaB);
	  
	    FichadaTren fichadaPruebaC = new FichadaTren (FuncionesGregorian.traerFecha(2018, 03, 6), aKornTren, eTipoFichadaTren.SALIDA);
	    transaccion =  tarjeta.procesarFichada(fichadaPruebaC);
	    
	    for (TransaccionSUBE t : tarjeta.getTransacciones()) {
	    	System.out.println(t.toString());
	    }
	    
		// procesado de  fichadas----------------------------------------------------------------------------------------------------------------------------
		/*
	    FichadaSubte fichadaSubte = new FichadaSubte(FuncionesGregorian.traerFecha(2018, 07, 31),constitucion);
		FichadaColectivo fichadaColectivo = new FichadaColectivo (FuncionesGregorian.traerFecha(2018, 07,31), cruceAMonteGrande);
		
		
		//TransaccionSUBE transaccion = new TransaccionSUBE (fichadaSubte, new BigDecimal (11));
		tarjeta.procesarFichada(fichadaSubte);
		//System.out.println("Saldo depsues fichada subte"+tarjeta.toString());
		tarjeta.procesarFichada(fichadaColectivo);
		System.out.println("Saldo despues fichada colectivo"+tarjeta.toString());
		
		Set<TransaccionSUBE>auxTransaccion = tarjeta.getTransacciones();
		System.out.println("Lista de  transacciones");*/
		
		//--------------------------------------------------------------------------------------------------------------------------
		
		//Printeos
	/*	System.out.println("----------------------------------------------------------------------------------------------------------------------");
		System.out.println(persona.toString());
		System.out.println(lineaC.getRecorridoSubte().get(0));
		System.out.println(lineaC.getRecorridoSubte().get(1));
		System.out.println(fichadaSubte.toString());
		//System.out.println(transaccion.toString());
		System.out.println(tarjeta.getSaldo().toString());
		System.out.println(persona.getDescuentoTarifaSocial());
		System.out.println(tarjeta.getTransacciones().get(0));
		*/
		
		
		
	}

	
	
}
