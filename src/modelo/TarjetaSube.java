package modelo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
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
	
	private int idTarjeta;
	private String codigo;
	private Persona propietario;
	private Set<TransaccionSUBE> transacciones;
	private DescuentoRedSube descuentoRedSube;
	private BigDecimal saldo;

	public TarjetaSube() {}
	
	public TarjetaSube(String codigo, BigDecimal saldo) {
		super();
		this.codigo = codigo;
		this.saldo = saldo;
		this.transacciones = new HashSet<TransaccionSUBE>();
		this.descuentoRedSube = new DescuentoRedSube();
	}

	protected void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	
	public int getIdTarjeta() {
		return this.idTarjeta;
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
	
	public Set<TransaccionSUBE> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(Set<TransaccionSUBE> transacciones) {
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
	
	public TransaccionSUBE procesarFichada(FichadaColectivo fichadaColectivo) {
		BigDecimal monto = procesarDescuento(fichadaColectivo.obtenerPrecioColectivo(), fichadaColectivo);
		TransaccionSUBE transaccion = this.procesarTransaccion(fichadaColectivo, monto); 
		this.transacciones.add(transaccion);
		return transaccion;
		

	}
	
	public void procesarFichada(FichadaTren fichadaTren) {
		
		if (fichadaTren.getTipoFichada().equals(eTipoFichadaTren.ENTRADA)) {
			procesarSaldoMaximo (fichadaTren);
			/*System.out.println("Es de entrada");
			BigDecimal monto=fichadaTren.getEstacion().getLinea().obtenerMayorSeccion();
			//procesarDescuento (monto, fichadaTren);
			transaccion = procesarTransaccion (fichadaTren,monto);
			this.transacciones.add(transaccion);*/
		}
		
		
		if (fichadaTren.getTipoFichada().equals(eTipoFichadaTren.SALIDA)) {
			
			TransaccionSUBE transaccion = null;
			if (this.transacciones.get(this.transacciones.size()-1).getFichada() instanceof FichadaTren) {
				FichadaTren fichaAux =  (FichadaTren) this.transacciones.get(this.transacciones.size()-1).getFichada();
				
				if (fichaAux.getTipoFichada().equals(eTipoFichadaTren.ENTRADA)){
					//Significa q entro y salio  sin anomalias (FLUJO NORMAL)
					
					
					ViajeTren viajeAux = fichadaTren.getEstacion().getLinea().obtenerViaje(fichaAux.getEstacion(), fichadaTren.getEstacion());
					BigDecimal bonificacion = new BigDecimal(0);
					bonificacion = this.transacciones.get(this.transacciones.size()-1)
							.getImporte().subtract(viajeAux.getSeccionTren().getImporte()); 
					transaccion = procesarTransaccion (fichadaTren, bonificacion);
					//System.out.println("Trasaccion bonifiacion"+transaccion.getImporte().toString());
					
				 
				} 
			}
		}
		
	}
	
	public TransaccionSUBE procesarFichada (FichadaSubte fichadaSubte) {
		BigDecimal monto = procesarDescuento (fichadaSubte.obtenerPrecio(), fichadaSubte);
		TransaccionSUBE transaccion = procesarTransaccion(fichadaSubte, monto);
		this.transacciones.add(transaccion);
		return transaccion;
	}
	
	public TransaccionSUBE procesarFichada (FichadaRecarga fichadaCarga) {
		TransaccionSUBE transaccion = procesarTransaccion(fichadaCarga, fichadaCarga.getMonto().multiply(new BigDecimal(-1f)));
		this.transacciones.add(transaccion);
		return transaccion;
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
		BigDecimal montoFinal = monto.add(BigDecimal.ZERO);
		if (this.propietario != null) {
			//Aplica descuentos
			if (this.propietario.getDescuentoBoletoEstudiantil() != null && this.propietario.getDescuentoBoletoEstudiantil().LeQuedanCargas()) { //Como es del 100%, si existe ignoramos los otros.
				montoFinal=this.propietario.getDescuentoBoletoEstudiantil().aplicarDescuento(montoFinal, fichada);
			} else {
				if (this.propietario.getDescuentoTarifaSocial() != null) {
					montoFinal=this.propietario.getDescuentoTarifaSocial().aplicarDescuento(montoFinal, fichada);
				}
			}
		}
		
		if (this.descuentoRedSube != null) {
			montoFinal = this.descuentoRedSube.aplicarDescuento(montoFinal, fichada);
		}
		
		return montoFinal;
	}
	
	public TransaccionSUBE procesarTransaccion (Fichada fichada, BigDecimal monto) {
		//Descuenta saldo y crea  transaccion
		BigDecimal montoFinal = monto.add(BigDecimal.ZERO); //Creamos uno nuevo
		montoFinal = montoFinal.setScale(2, BigDecimal.ROUND_HALF_UP);
		this.saldo = this.saldo.subtract(montoFinal);
		return new TransaccionSUBE (fichada, montoFinal);
	
	
	}

	@Override
	public String toString() {
		return this.saldo.toString();
	}
	public void procesarSaldoMaximo (FichadaTren fichadaTren) {
		TransaccionSUBE transaccion = null;
		System.out.println("Es de entrada");
		BigDecimal monto=fichadaTren.getEstacion().getLinea().obtenerMayorSeccion();
		//procesarDescuento (monto, fichadaTren);
		transaccion = procesarTransaccion (fichadaTren,monto);
		this.transacciones.add(transaccion);
		System.out.println("Transaccion en fichada entrada "+transaccion.getImporte().toString());
	}
	
	//hacer  clase  "numero importe" subclase de  bigdecimal
	//hacer  metodo interno para  reutilizar  comprovacion de not null y  calculo descuento 
}