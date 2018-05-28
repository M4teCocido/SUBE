package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import modelo.Persona;
import modelo.TarjetaSube;
import modelo.eGenero;
import modelo.fichadas.FichadaRecarga;
import modelo.fichadas.colectivo.FichadaColectivo;
import modelo.fichadas.colectivo.InternoColectivo;
import modelo.fichadas.colectivo.LineaColectivo;
import modelo.fichadas.colectivo.TramoColectivo;
import modelo.fichadas.subte.EstacionSubte;
import modelo.fichadas.subte.FichadaSubte;
import modelo.fichadas.subte.LineaSubte;
import modelo.lectoras.LectoraColectivo;
import modelo.lectoras.LectoraExterna;
import modelo.lectoras.LectoraSubte;

public class testTarjetaSubeSubte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Se crea una tarjeta nueva con saldo 0
		BigDecimal saldo = new BigDecimal(0);
		TarjetaSube tarjeta = new TarjetaSube("123456", saldo);
		
		//Se le realiza una recarga y chequeamos que se haya cargado correctamente
		GregorianCalendar fechaRecarga = new GregorianCalendar(2018, 5, 28, 10, 0, 0);
		BigDecimal montoCarga = new BigDecimal(100);
		LectoraExterna lectoraRecarga = new LectoraExterna(1, "Kiosco");
		FichadaRecarga cargaSaldo = new FichadaRecarga(fechaRecarga, montoCarga, lectoraRecarga);
		
		tarjeta.procesarFichada(cargaSaldo);
		
		System.out.println("Su saldo es: " + tarjeta.getSaldo());
		
		//Creamos la linea, la lista de estaciones y chequeamos que funcione
		BigDecimal viajeSubte = new BigDecimal(9.25);
		LineaSubte lineaSubte = new LineaSubte("C", viajeSubte);
		
		List<EstacionSubte> listaEstacionesSubte = new ArrayList<EstacionSubte>();
		listaEstacionesSubte.add(new EstacionSubte("Constitucion", lineaSubte));
		listaEstacionesSubte.add(new EstacionSubte("San Juan", lineaSubte));
		listaEstacionesSubte.add(new EstacionSubte("Independencia", lineaSubte));
		listaEstacionesSubte.add(new EstacionSubte("Moreno", lineaSubte));
		listaEstacionesSubte.add(new EstacionSubte("Av. de Mayo", lineaSubte));
		listaEstacionesSubte.add(new EstacionSubte("Diagonal Norte", lineaSubte));
		listaEstacionesSubte.add(new EstacionSubte("Lavalle", lineaSubte));
		listaEstacionesSubte.add(new EstacionSubte("Gral. San Martin", lineaSubte));
		listaEstacionesSubte.add(new EstacionSubte("Retiro", lineaSubte));
		
		//System.out.println(listaEstacionesSubte);
		
		//Simulamos
		GregorianCalendar fechaFichada = new GregorianCalendar(2018, 5, 28, 10, 15, 0);
		LectoraSubte lectoraSubte = new LectoraSubte(1, listaEstacionesSubte.get(0));
		FichadaSubte fichadaSubte = new FichadaSubte(fechaFichada, lectoraSubte, lectoraSubte.getEstacion());
		
		tarjeta.procesarFichada(fichadaSubte);
		
		System.out.println("El lugar de la fichada fue: " + fichadaSubte.toString());
		System.out.println("Saldo despues de viajar es: " + tarjeta.getSaldo());
		
		//Creamos simulacion de colectivo 
		GregorianCalendar fechaFichadaColectivo = new GregorianCalendar(2018, 5, 28, 15, 45, 0);
		LineaColectivo lineaColectivo = new LineaColectivo("160");
		TramoColectivo tramoColectivo = new TramoColectivo("Tramo", new BigDecimal(9.25), lineaColectivo);
		InternoColectivo interno = new InternoColectivo(lineaColectivo, "Roy", null);
		LectoraColectivo lectoraColectivo = new LectoraColectivo(1, interno);
		FichadaColectivo fichadaColectivo = new FichadaColectivo(fechaFichadaColectivo, tramoColectivo, lectoraColectivo);
		
		tarjeta.procesarFichada(fichadaColectivo);
		
		System.out.println("Su saldo es: " + tarjeta.getSaldo());
		
		//Creamos la persona y la asociamos a la tarjeta para aplicar descuentos
		try {
			Persona propietario = new Persona("Gonzalo", "Montaña", eGenero.M, new GregorianCalendar(1993, 11, 16), "gonzamcomps@gmail.com", "1558912066", "42991823");
			tarjeta.setPropietario(propietario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
				
	}

}
