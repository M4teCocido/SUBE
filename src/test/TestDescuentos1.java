package test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;


import modelo.Persona;
import modelo.TarjetaSube;
import modelo.Descuentos.DescuentoBoletoEstudiantil;
import modelo.Descuentos.DescuentoTarifaSocial;
import modelo.fichadas.Fichada;
import modelo.fichadas.TransaccionSUBE;
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
		TransaccionSUBE tx;
		
		System.out.println("Fichadas sin descuentos (Solo Red Sube) en Subte. Precio base : $11.00");
		
		System.out.println("Red Sube 0");
		FichadaSubte f1 = new FichadaSubte(new GregorianCalendar(), constitucion);
		tx = tarjeta.procesarFichada(f1);
		printTransaccion(f1, tx);
		
		
		System.out.println("Red Sube 1");
		f1 = new FichadaSubte(new GregorianCalendar(), constitucion);
		tx = tarjeta.procesarFichada(f1);
		printTransaccion(f1, tx);
		
		System.out.println("Red Sube 2");
		f1 = new FichadaSubte(new GregorianCalendar(), constitucion);
		tx = tarjeta.procesarFichada(f1);
		printTransaccion(f1, tx);
		
		System.out.println("Red Sube 3");
		f1 = new FichadaSubte(new GregorianCalendar(), constitucion);
		tx = tarjeta.procesarFichada(f1);
		printTransaccion(f1, tx);
		
		System.out.println("Red Sube 4");
		f1 = new FichadaSubte(new GregorianCalendar(), constitucion);
		tx = tarjeta.procesarFichada(f1);
		printTransaccion(f1, tx);
		
		System.out.println("Red Sube 5 (Empezamos de vuelta)");
		f1 = new FichadaSubte(new GregorianCalendar(), constitucion);
		tx = tarjeta.procesarFichada(f1);
		printTransaccion(f1, tx);
		
		System.out.println("Red Sube 6 (gg)");
		f1 = new FichadaSubte(new GregorianCalendar(), constitucion);
		tx = tarjeta.procesarFichada(f1);
		printTransaccion(f1, tx);
		
		System.out.println("Aplicando todas las de Boleto Estudiantil");
		
		GregorianCalendar fechaFueraBoleto = new GregorianCalendar();
		fechaFueraBoleto.set(Calendar.HOUR_OF_DAY, 4);
		
		persona.asignarDescuentoBoletoEstudiantil(new DescuentoBoletoEstudiantil (DescuentoBoletoEstudiantil.eTipoBoletoEstudiantil.ESCOLAR));
		for (int i = 0; i < 51; i++) {
			
			f1 = new FichadaSubte(fechaFueraBoleto, constitucion);
			tx = tarjeta.procesarFichada(f1);
			printTransaccion(f1, tx);
		}
		
		/*
		System.out.println("Fichada Con SOCIAL");
		persona.asignarDescuentoTarifaSocial(new DescuentoTarifaSocial ("Descuento Tarifa Social", 55));
		FichadaSubte f2 = new FichadaSubte(new GregorianCalendar(), constitucion);
		tx = tarjeta.procesarFichada(f2);
		printTransaccion(f2, tx);
		
		System.out.println("Fichada Con SOCIAL y ESTUDIANTIL");
		persona.asignarDescuentoBoletoEstudiantil(new DescuentoBoletoEstudiantil (DescuentoBoletoEstudiantil.eTipoBoletoEstudiantil.ESCOLAR));
		FichadaSubte f3 = new FichadaSubte(new GregorianCalendar(), constitucion);
		tx = tarjeta.procesarFichada(f3);
		printTransaccion(f3, tx);*/
	}
	
	private static void printTransaccion(Fichada fichada, TransaccionSUBE tx) {
		//System.out.println("Fichada original :" + fichada);
		if (tx != null) {
			System.out.println("Transaccion : " +  tx.getImporte());
		} else {
			System.out.println("NO SE EFECTUO TRANSACCION");
		}
	}
	
}
