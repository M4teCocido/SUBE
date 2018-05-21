package modelo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import modelo.Descuentos.*;

import modelo.Persona;
import modelo.fichadas.*;
import modelo.fichadas.colectivo.FichadaColectivo;
import modelo.fichadas.subte.FichadaSubte;
import modelo.fichadas.tren.FichadaTren;
import modelo.fichadas.tren.FichadaTren.eTipoFichadaTren;
import modelo.fichadas.tren.ViajeTren;
import util.IndexableSet;

public class TarjetaSube {
	
	private String codigo;
	private Persona propietario;
	private IndexableSet<TransaccionSUBE> transacciones;
	private DescuentoRedSube descuentoRedSube;
	private BigDecimal saldo;

	public TarjetaSube() {}
	
	public TarjetaSube(String codigo, BigDecimal saldo) {
		super();
		this.codigo = codigo;
		this.saldo = saldo;
		this.transacciones = new IndexableSet <TransaccionSUBE> ();
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
	
	public IndexableSet<TransaccionSUBE> getTransacciones() {
		return transacciones;
	}

	
	

	public void setTransacciones(IndexableSet<TransaccionSUBE> transacciones) {
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
		BigDecimal monto = procesarDescuento(fichadaColectivo.obtenerPrecioColectivo(), fichadaColectivo);
		this.transacciones.add(procesarTransaccion(fichadaColectivo, monto));

	}
	
	public void procesarFichada(FichadaTren fichadaTren) {
		
		if (fichadaTren.getTipoFichada().equals(eTipoFichadaTren.ENTRADA)) {
			System.out.println("Es de entrada");
			BigDecimal monto=fichadaTren.getEstacion().getLinea().obtenerMayorSeccion();
			//procesarDescuento (monto, fichadaTren);
			
			this.transacciones.add(procesarTransaccion (fichadaTren,monto));
		}
		
		
		if (fichadaTren.getTipoFichada().equals(eTipoFichadaTren.SALIDA)) {
			
			
			if (this.transacciones.get(this.transacciones.size()-1).getFichada() instanceof FichadaTren) {
				FichadaTren fichaAux =  (FichadaTren) this.transacciones.get(this.transacciones.size()-1).getFichada();
				
				if (fichaAux.getTipoFichada().equals(eTipoFichadaTren.ENTRADA)){
					//Significa q entro y salio  sin anomalias (FLUJO NORMAL)
					
					
					ViajeTren viajeAux = fichadaTren.getEstacion().getLinea().obtenerViaje(fichaAux.getEstacion(), fichadaTren.getEstacion());
					BigDecimal bonificacion = new BigDecimal(0);
					bonificacion = this.transacciones.get(this.transacciones.size()-1).getImporte().subtract(viajeAux.getSeccionTren().getImporte()); 
				
					this.saldo=this.saldo.add(bonificacion);
				 
				}
			}
	
		}
	}
	
	public void procesarFichada (FichadaSubte fichadaSubte) {
		BigDecimal monto = procesarDescuento (fichadaSubte.obtenerPrecio(), fichadaSubte);
		this.transacciones.add(procesarTransaccion(fichadaSubte, monto));
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


	public BigDecimal procesarDescuento (BigDecimal monto, Fichada fichada) {
		
		//Aplica descuentos
		if (this.propietario.getDescuentoTarifaSocial() != null) {
			monto=this.propietario.getDescuentoTarifaSocial().aplicarDescuento(monto, fichada);
		}
		
		
		return monto;
	}
	
	public TransaccionSUBE procesarTransaccion (Fichada fichada, BigDecimal monto) {
		//Descuenta saldo y crea  transaccion
		this.saldo = this.saldo.subtract(monto);
		return new TransaccionSUBE (fichada,monto);
	
	
	}

	@Override
	public String toString() {
		return this.saldo.toString();
	}
	
	
	//hacer  clase  "numero importe" subclase de  bigdecimal
	//hacer  metodo interno para  reutilizar  comprovacion de not null y  calculo descuento 
}