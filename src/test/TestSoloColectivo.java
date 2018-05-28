package test;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import modelo.Persona;
import modelo.TarjetaSube;
import modelo.Descuentos.DescuentoTarifaSocial;
import modelo.fichadas.colectivo.FichadaColectivo;
import modelo.fichadas.colectivo.InternoColectivo;
import modelo.fichadas.colectivo.LineaColectivo;
import modelo.fichadas.colectivo.TramoColectivo;
import modelo.lectoras.LectoraColectivo;

public class TestSoloColectivo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona persona = new Persona();
		persona.asignarDescuentoTarifaSocial(new DescuentoTarifaSocial ("Descuento Tarifa Social", 55));
		
		TarjetaSube tarjeta = new TarjetaSube("9999",new BigDecimal (200));
		
		tarjeta.setPropietario(persona);
		
		LineaColectivo l165 = new LineaColectivo ("165");
		LectoraColectivo lectoraColectivoA = new LectoraColectivo ();
		
		InternoColectivo internoA = new InternoColectivo (l165, "internoA", lectoraColectivoA);
		internoA.getLectora().setInterno(internoA);
		TramoColectivo tramoColectivoA = new TramoColectivo("Tramo A",new BigDecimal (9), l165);
		
		FichadaColectivo fichadaAColectivo = new FichadaColectivo (new GregorianCalendar(2018, 3, 6, 13,10,00),tramoColectivoA, lectoraColectivoA);
		System.out.println(tarjeta.getSaldo().toString());
		System.out.println(tarjeta.procesarFichada(fichadaAColectivo).toString());

	}

}
