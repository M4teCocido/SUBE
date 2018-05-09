package modelo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import modelo.Descuentos.*;

import modelo.Persona;
import modelo.Descuentos.DescuentoTarifaSocial;
import modelo.fichadas.*;
import modelo.fichadas.colectivo.FichadaColectivo;
import modelo.fichadas.subte.FichadaSubte;
import modelo.fichadas.tren.FichadaTren;


public class TarjetaSube {
	private String codigo;
	private Persona owner;
	private ArrayList<Fichada> fichadas;
	private DescuentoTarifaSocial descuentoTarifaSocial;
	private DescuentoRedSube descuentoRedSube;
	private DescuentoBoletoEstudiantil descuentoVoletoEstudiantil;
	private BigDecimal saldo;

	

	public void efectuarCarga (BigDecimal monto) {
		
		
	}
	
	public void procesarFichada(FichadaColectivo fichadaColectivo) {
		
	}
	
	public void procesarFichada(FichadaTren fichadaTren) {
		
	}
	
	public void procesarFichada (FichadaSubte fichadaSubte) {
	
	}
	
	public void procesarFichada (FichadaRecarga fichadaCarga) {
		
	}

	
	public void asignarDescuento(DescuentoRedSube descuento) {
		
	}

	public List<Fichada> obtenerViajesRealizados(GregorianCalendar fechaInicio , GregorianCalendar fechaFin ) {
		List<Fichada> fichadas = new ArrayList<Fichada>();
	
		return fichadas;
	}
	
	public List<TransaccionSUBE> obtenerViajesRealizadosColectivo (GregorianCalendar fechaInicio, GregorianCalendar fechaFinal){
		List<TransaccionSUBE>transacciones = new ArrayList<TransaccionSUBE>();
	
		return transacciones;
	}

	

}