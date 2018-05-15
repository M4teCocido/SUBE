package modelo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import modelo.Descuentos.*;

import modelo.Persona;
import modelo.fichadas.*;
import modelo.fichadas.colectivo.FichadaColectivo;
import modelo.fichadas.subte.FichadaSubte;
import modelo.fichadas.tren.FichadaTren;


public class TarjetaSube {
	
	private String codigo;
	private Persona propietario;
	private ArrayList<TransaccionSUBE> transacciones;
	private DescuentoRedSube descuentoRedSube;
	private BigDecimal saldo;

	
	public TarjetaSube() {}
	
	

	public TarjetaSube(String codigo, BigDecimal saldo) {
		super();
		this.codigo = codigo;
		this.transacciones = new ArrayList<TransaccionSUBE>();
		this.saldo = saldo;
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Persona getPropietario() {
		return this.propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	public DescuentoRedSube getDescuentoRedSube() {
		return descuentoRedSube;
	}

	public void setDescuentoRedSube(DescuentoRedSube descuentoRedSube) {
		this.descuentoRedSube = descuentoRedSube;
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
		BigDecimal monto = fichadaSubte.obtenerPrecio();
		
		monto=this.propietario.getDescuentoTarifaSocial().aplicarDescuento(monto);
		
		
		this.saldo = this.saldo.subtract(monto);
		this.transacciones.add(new TransaccionSUBE (fichadaSubte,monto));
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



	@Override
	public String toString() {
		return "TarjetaSube [codigo=" + codigo + ", propietario=" + propietario + ", transacciones=" + transacciones
				+ ", descuentoRedSube=" + descuentoRedSube + ", saldo=" + saldo + "]";
	}
	
}