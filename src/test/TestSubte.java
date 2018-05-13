package test;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

import modelo.*;
import modelo.Descuentos.DescuentoTarifaSocial;
import modelo.fichadas.Fichada;
import modelo.fichadas.TransaccionSUBE;
import modelo.fichadas.subte.EstacionSubte;
import modelo.fichadas.subte.FichadaSubte;
import modelo.fichadas.subte.LineaSubte;

public class TestSubte {

	public static void main(String[] args) {
		Persona persona = new Persona();
		persona.asignarDescuentoTarifaSocial(new DescuentoTarifaSocial ("Descuento Tarifa Social", new BigDecimal (55)));
		
		TarjetaSube tarjeta = new TarjetaSube();
		tarjeta.setSaldo(new BigDecimal (21));
		tarjeta.setPropietario(persona);
		LineaSubte lineaC = new LineaSubte ("Linea C", new BigDecimal(11));
		EstacionSubte constitucion= new EstacionSubte("Constitucion", lineaC); 
		EstacionSubte moreno = new EstacionSubte("Moreno", lineaC); 
		lineaC.getRecorridoSubte().add(constitucion);
		lineaC.getRecorridoSubte().add(moreno);
		FichadaSubte fichadaSubte = new FichadaSubte(FuncionesGregorian.traerFecha(1998, 07, 31),constitucion);
		TransaccionSUBE transaccion = new TransaccionSUBE (fichadaSubte, new BigDecimal (11));
		tarjeta.procesarFichada(fichadaSubte);
		
		
		
		//Printeos
		System.out.println(persona.toString());
		System.out.println(lineaC.getRecorridoSubte().get(0));
		System.out.println(lineaC.getRecorridoSubte().get(1));
		System.out.println(fichadaSubte.toString());
		System.out.println(transaccion.toString());
		System.out.println(tarjeta.getSaldo().toString());
		System.out.println(persona.getDescuentoTarifaSocial());
		
		//Test cosas con descuento
		
		
		
	}

	
	//Por q si utilizo fichada en cada  tipo hay una clase generica TransaccionSube? por q  es  el resultado de el proceso tiene el monto
	//el constructor de fichada subte no deberia tomar el monto desde el monto en la linea ??
	
}
