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
import modelo.fichadas.tren.RecorridoTren;
import modelo.fichadas.tren.SeccionTren;
import modelo.fichadas.tren.ViajeTren;
import modelo.fichadas.tren.FichadaTren.eTipoFichadaTren;

public class TestA {

	public static void main(String[] args) {
		Persona persona = new Persona();
		persona.asignarDescuentoTarifaSocial(new DescuentoTarifaSocial ("Descuento Tarifa Social", new BigDecimal (55)));
		
		TarjetaSube tarjeta = new TarjetaSube("9999",new BigDecimal (21));
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
		RecorridoTren recorridoEzeiza = new RecorridoTren (roca, "Ezeiza");
		EstacionTren constitucionTren= new EstacionTren("Constitucion", recorridoEzeiza);  
		EstacionTren lanusTren= new EstacionTren("Lanus", recorridoEzeiza ); 
		
		recorridoEzeiza.getEstaciones().add(lanusTren);
		recorridoEzeiza.getEstaciones().add(constitucionTren);
		
		SeccionTren primeraSeccion = new SeccionTren("Primera seccion", new BigDecimal (3), recorridoEzeiza);
		FichadaTren fichadaTrenA =  new FichadaTren (FuncionesGregorian.traerFecha(1998, 10, 10), constitucionTren, eTipoFichadaTren.ENTRADA);
		FichadaTren fichadaTrenB = new FichadaTren (FuncionesGregorian.traerFecha(1998, 9, 10), lanusTren, eTipoFichadaTren.SALIDA );
		
		
		
		
		
		
		// procesado de  fichadas----------------------------------------------------------------------------------------------------------------------------
		FichadaSubte fichadaSubte = new FichadaSubte(FuncionesGregorian.traerFecha(2018, 07, 31),constitucion);
		FichadaColectivo fichadaColectivo = new FichadaColectivo (FuncionesGregorian.traerFecha(2018, 07,31), cruceAMonteGrande);
		//TransaccionSUBE transaccion = new TransaccionSUBE (fichadaSubte, new BigDecimal (11));
		tarjeta.procesarFichada(fichadaSubte);
		//System.out.println("Saldo depsues fichada subte"+tarjeta.toString());
		tarjeta.procesarFichada(fichadaColectivo);
		System.out.println("Saldo despues fichada colectivo"+tarjeta.toString());
		
		Set<TransaccionSUBE>auxTransaccion = tarjeta.getTransacciones();
		System.out.println("Lista de  transacciones");
		for (int i = 0; i< auxTransaccion.size(); i++) {
			System.out.println(i+"-"+auxTransaccion.get(i).toString());
		}
		
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
		tarjeta.procesarFichada(fichadaTrenA);
		tarjeta.procesarFichada(fichadaTrenB);
		
		
	}

	
	
}
