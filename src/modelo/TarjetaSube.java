package modelo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import modelo.Descuentos.*;

import modelo.Persona;
import modelo.fichadas.*;
import modelo.fichadas.colectivo.FichadaColectivo;
import modelo.fichadas.subte.FichadaSubte;
import modelo.fichadas.tren.FichadaTren;
import modelo.fichadas.tren.eTipoFichadaTren;
import modelo.fichadas.tren.ViajeTren;
import util.IndexableSet;

public class TarjetaSube {
	
	private int idTarjeta;
	private String codigo;
	private Persona propietario;
	private Set<TransaccionSUBE> transacciones;
	private DescuentoRedSube descuentoRedSube;
	private BigDecimal saldo;
	private boolean activa;
	private final int saldoMinimo = -19;
	
	public TarjetaSube() {}
	
	public TarjetaSube(String codigo, BigDecimal saldo) {
		super();
		this.codigo = codigo;
		this.saldo = saldo;
		this.transacciones = new HashSet<TransaccionSUBE>();
		this.descuentoRedSube = new DescuentoRedSube();
		this.activa = true;
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
	
	public boolean isActiva() {
		return activa;
	}
	
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	
	public void efectuarCarga (BigDecimal monto) {
		
	}
	
	public TransaccionSUBE procesarFichada(FichadaColectivo fichadaColectivo) {
		BigDecimal monto = procesarDescuento(fichadaColectivo.obtenerPrecio(), fichadaColectivo);
		
		TransaccionSUBE transaccion = null; 
			Resultado resultado = comprobarSaldoSuficiente(monto);
			
			if (resultado.aprobado == true ) {
				transaccion = this.procesarTransaccion(fichadaColectivo, monto); 
				this.transacciones.add(transaccion);
			}
		
		return transaccion;
	}
	


	
	public TransaccionSUBE procesarFichada(FichadaTren fichadaActual) { //Se procesa fichada tren. -----------
		
		TransaccionSUBE transaccion = null;
		System.out.println(fichadaActual.toString());
		if (fichadaActual.getTipoFichada().equals(eTipoFichadaTren.ENTRADA)) {
			transaccion = procesarSaldoMaximo (fichadaActual);
		} else {
			
			FichadaTren fichadaAnterior =  (FichadaTren) getUltimaFichada();
			Fichada ultimaFichada = this.getUltimaFichada();
			
			if (ultimaFichada instanceof FichadaTren) {

				System.out.println(fichadaAnterior.toString());
				
				if (fichadaAnterior.getTipoFichada().equals(eTipoFichadaTren.ENTRADA)){
					System.out.print("Delta tiempo");
					
					System.out.println(fichadaActual.getFechaHora().get(GregorianCalendar.HOUR_OF_DAY)-fichadaAnterior.getFechaHora().get(GregorianCalendar.HOUR_OF_DAY));
					
					if((fichadaActual.getFechaHora().get(GregorianCalendar.HOUR_OF_DAY)-fichadaAnterior.getFechaHora().get(GregorianCalendar.HOUR_OF_DAY))<2){
						ViajeTren viajeAux = fichadaActual.getEstacion().getLinea().obtenerViaje(fichadaAnterior.getEstacion(), fichadaActual.getEstacion());
					    BigDecimal bonificacion = new BigDecimal(0);
					
				     	bonificacion = getUltimaTransaccion().getImporte();
			    		transaccion = procesarTransaccion (fichadaActual, bonificacion);
					
					    System.out.println("Bonificacion:" + bonificacion.toString());
				    	this.transacciones.add(transaccion);
					}
					
				 
				} else  transaccion = procesarSaldoMaximo (fichadaActual);
			} else transaccion =  procesarSaldoMaximo (fichadaActual);

		}
		return transaccion;
	}
	
	
	
	public TransaccionSUBE procesarFichada (FichadaSubte fichadaSubte) { //procesa fichada subte------------
		BigDecimal monto = procesarDescuento (fichadaSubte.obtenerPrecio(), fichadaSubte);
		
		
		
		TransaccionSUBE transaccion = null; 
		Resultado resultado = comprobarSaldoSuficiente(monto);
		
		if (resultado.aprobado == true ) {
			transaccion = this.procesarTransaccion(fichadaSubte, monto); 
			this.transacciones.add(transaccion);
		}
		
		
		return transaccion;
	}
	
	public TransaccionSUBE procesarFichada (FichadaRecarga fichadaCarga) {
		TransaccionSUBE transaccion = procesarTransaccion(fichadaCarga, fichadaCarga.getMonto().multiply(new BigDecimal(-1f)));
		this.transacciones.add(transaccion);
		return transaccion;
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


	public BigDecimal procesarDescuento (BigDecimal monto, Fichada fichada) {//Interface para todo proceso de descuento---------
		BigDecimal montoFinal = monto.add(BigDecimal.ZERO);
		if (this.propietario != null) {
			//Aplica descuentos
			if (this.propietario.getDescuentoBoletoEstudiantil() != null && this.propietario.getDescuentoBoletoEstudiantil().leQuedanCargas()) { //Como es del 100%, si existe ignoramos los otros.
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
	public TransaccionSUBE procesarSaldoMaximo (FichadaTren fichadaTren) {
		TransaccionSUBE transaccion = null;
		System.out.println("Es de entrada");
		BigDecimal monto=fichadaTren.getEstacion().getLinea().obtenerMayorSeccion();
		monto=procesarDescuento (monto, fichadaTren);
		
		transaccion = procesarTransaccion (fichadaTren, monto);
		this.transacciones.add(transaccion);
		System.out.println("Transaccion en fichada entrada "+transaccion.getImporte().toString());
		
		return transaccion;
		
	}
	
	public Resultado comprobarSaldoSuficiente (BigDecimal monto ) {//Comprueba saldo suficiente 
		
		Resultado resultadoComprobacion =  new Resultado (true,"Transaccion aprobada");
		BigDecimal montoAux = new BigDecimal (0);
		
		montoAux = this.saldo.subtract(monto);
		
		if( montoAux.compareTo(new BigDecimal (saldoMinimo))==-1) {
			resultadoComprobacion.setAprobado(false);
			resultadoComprobacion.setMensaje("Saldo Insuficiente");
		}
		return resultadoComprobacion;
	}

	
	private TransaccionSUBE getUltimaTransaccion() {// Obtiene la ultima transaccion dentro de lista de trasacciones----------
		if (this.transacciones.size() > 0)
			return IndexableSet.get(this.transacciones,this.transacciones.size()-1);		
		else
			return null;
	}
	
	
	private Fichada getUltimaFichada() {// obtiene la  ultima  fichada dentro de la ultima transaccion---------
		TransaccionSUBE tx = this.getUltimaTransaccion();
		if (tx != null)
			return tx.getFichada();
		else
			return null;
	}
	
	
	public void asignarDescuento(DescuentoRedSube descuento) {
		
	}

	 
	
	
	
	class Resultado{
		 private boolean aprobado;
		 private String mensaje;
		public Resultado(boolean aprobado, String mensaje) {
			super();
			this.aprobado = aprobado;
			this.mensaje = mensaje;
		}
		public Resultado() {
			super();
		}
		public boolean isAprobado() {
			return aprobado;
		}
		public void setAprobado(boolean aprobado) {
			this.aprobado = aprobado;
		}
		public String getMensaje() {
			return mensaje;
		}
		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}
		 
		 
		
		 
	 
	 }
	
	
}

