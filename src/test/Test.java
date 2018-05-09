package test;
import java.math.BigDecimal;

import modelo.*;
import modelo.fichadas.subte.EstacionSubte;
import modelo.fichadas.subte.LineaSubte;

public class Test {

	public static void main(String[] args) {
		Persona persona = new Persona();
		TarjetaSube tarjeta = new TarjetaSube();
		LineaSubte lineaC = new LineaSubte ("Linea C", new BigDecimal(11));
		EstacionSubte constitucion= new EstacionSubte("Constitucion", lineaC); 
		lineaC.getRecorridoSubte().add(constitucion);
		
		
		System.out.println(persona.toString());
		System.out.println(lineaC.getRecorridoSubte().get(0));
		

	}

}
