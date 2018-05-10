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
	private ArrayList<TransaccionSUBE> transacciones;
	private DescuentoTarifaSocial descuentoTarifaSocial;
	private DescuentoRedSube descuentoRedSube;
	private DescuentoBoletoEstudiantil descuentoBoletoEstudiantil;
	private BigDecimal saldo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Persona getOwner() {
		return owner;
	}

	public void setOwner(Persona owner) {
		this.owner = owner;
	}

	public DescuentoTarifaSocial getDescuentoTarifaSocial() {
		return descuentoTarifaSocial;
	}

	public void setDescuentoTarifaSocial(DescuentoTarifaSocial descuentoTarifaSocial) {
		this.descuentoTarifaSocial = descuentoTarifaSocial;
	}

	public DescuentoRedSube getDescuentoRedSube() {
		return descuentoRedSube;
	}

	public void setDescuentoRedSube(DescuentoRedSube descuentoRedSube) {
		this.descuentoRedSube = descuentoRedSube;
	}

	public DescuentoBoletoEstudiantil getDescuentoBoletoEstudiantil() {
		return descuentoBoletoEstudiantil;
	}

	public void setDescuentoBoletoEstudiantil(DescuentoBoletoEstudiantil descuentoBoletoEstudiantil) {
		this.descuentoBoletoEstudiantil = descuentoBoletoEstudiantil;
	}
	
	public ArrayList<TransaccionSUBE> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(ArrayList<TransaccionSUBE> transacciones) {
		this.transacciones = transacciones;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public void efectuarCarga (BigDecimal monto) {
		
		
	}
	
	public void procesarFichada(FichadaColectivo fichadaColectivo) {
		
	}
	
	public void procesarFichada(FichadaTren fichadaTren) {
		
	}
	
	public void procesarFichada (FichadaSubte fichadaSubte) {
		BigDecimal monto = fichadaSubte.getMonto();
		this.saldo = this.saldo.subtract(monto);
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

	public List<TransaccionSUBE> obtenerViajesRealizadosTren (GregorianCalendar fechaInicio, GregorianCalendar fechaFinal){
		List<TransaccionSUBE> transacciones  = new ArrayList <TransaccionSUBE>();
		return transacciones;
	}
	
	public List<TransaccionSUBE> obtenerViajesRealizadosSubte (GregorianCalendar fechaInicio, GregorianCalendar fechaFinal){
		List<TransaccionSUBE>transacciones = new ArrayList<TransaccionSUBE>();
		return transacciones;
	}
	
}