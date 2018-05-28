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
	private final int saldoMaximo = 600;
	
	public TarjetaSube() {}
	
	public TarjetaSube(String codigo, int saldo) {
		this(codigo, new BigDecimal(saldo));
	}
	
	public TarjetaSube(String codigo, BigDecimal saldo) {
		super();
		this.codigo = codigo;
		this.saldo = saldo;
		this.transacciones = new HashSet<TransaccionSUBE>();
		this.descuentoRedSube = new DescuentoRedSube(this);
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
	

	public Resultado procesarFichada(FichadaColectivo fichadaColectivo) {
		BigDecimal monto = procesarDescuento(fichadaColectivo.obtenerPrecio(), fichadaColectivo);
		
		TransaccionSUBE transaccion = null; 
		Resultado resultado = null;
		
		if (comprobarSaldoSuficiente(monto) == true ) {
			transaccion = this.procesarTransaccion(fichadaColectivo, monto); 
			transaccion.setImporte(new BigDecimal (transaccion.getImporte().ROUND_HALF_UP));
			this.transacciones.add(transaccion);
			resultado = new Resultado  (true,"-"+transaccion.getImporte().toString(), transaccion);
		}else {resultado = new Resultado  (false, "Saldo insuficiente", transaccion);}
		
		return resultado;
	}
	
	
	
	
	public Resultado procesarFichada(FichadaTren fichadaActual) { //Se procesa fichada tren. -----------
		
		TransaccionSUBE transaccion = null;
		Resultado resultado = null;
		
		
		
		if (fichadaActual.getTipoFichada().equals(eTipoFichadaTren.ENTRADA)) {
			if (comprobarSaldoSuficiente (fichadaActual.getEstacion().getLinea().obtenerMayorSeccion() )== true){
				transaccion = procesarSaldoMaximo (fichadaActual);
				resultado =  new Resultado (true, "-" + transaccion.getImporte().toString(), transaccion );
			}
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
			    		resultado = new Resultado (true, "+"+getUltimaTransaccion().getImporte().subtract(bonificacion).toString(),transaccion);
					    System.out.println("Bonificacion:" + bonificacion.toString());
				    	this.transacciones.add(transaccion);
					
					
					}else{	if (comprobarSaldoSuficiente (fichadaActual.getEstacion().getLinea().obtenerMayorSeccion() )== true){
								transaccion = new  TransaccionSUBE ( new BigDecimal (0),this, fichadaActual );
								resultado =  new Resultado (true, "-" + getUltimaTransaccion().getImporte() , transaccion );
								
							}
						} 	
				}else{	if (comprobarSaldoSuficiente (fichadaActual.getEstacion().getLinea().obtenerMayorSeccion() )== true){
								transaccion = procesarSaldoMaximo (fichadaActual);
								resultado =  new Resultado (true, "-" + transaccion.getImporte().toString(), transaccion );
							}
					}
			
			}else {	if(comprobarSaldoSuficiente (fichadaActual.getEstacion().getLinea().obtenerMayorSeccion() )== true){
							transaccion = procesarSaldoMaximo (fichadaActual);
							resultado =  new Resultado (true, "-" + transaccion.getImporte().toString(), transaccion );
			   			}
				}

		}
		return  resultado;
	}
	
	
	
	
	
	
	
	public Resultado procesarFichada (FichadaSubte fichadaSubte) { //procesa fichada subte------------
		BigDecimal monto = procesarDescuento (fichadaSubte.obtenerPrecio(), fichadaSubte);
		Resultado resultado = null;
		TransaccionSUBE transaccion = null; 	
		
		
		if (comprobarSaldoSuficiente(monto) == true ) {
			transaccion = this.procesarTransaccion(fichadaSubte, monto); 
			//System.out.println(transaccion.getImporte().toString());
			this.transacciones.add(transaccion);
			resultado = new Resultado (true, "-" + transaccion.getImporte().toString(),transaccion);
		}else {resultado = new Resultado(false, "Saldo insuficiente", transaccion);}
		
		
		return  resultado ;
	}
	
	public Resultado procesarFichada (FichadaRecarga fichadaCarga) {
		
		TransaccionSUBE transaccion = null;
		Resultado resultado = null;
		BigDecimal saldoDespuesCarga = this.saldo.add(fichadaCarga.getMonto());
		
		if (saldoDespuesCarga.compareTo(new BigDecimal (saldoMinimo))==1) {
			if (saldoDespuesCarga.compareTo(new BigDecimal (saldoMaximo))!=1) {
					this.saldo = saldoDespuesCarga;
					transaccion =  new TransaccionSUBE ( fichadaCarga.getMonto(),this, fichadaCarga );
					this.transacciones.add(transaccion);
					
					resultado = new Resultado (true, "+" + transaccion.getImporte().toString(), transaccion );
			} else {resultado = new Resultado (false, "Carga supera maximo", transaccion);}
		}else { resultado =  new Resultado (false, "Carga no supera minimo", transaccion );}
	
		
		return resultado;
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

	private TransaccionSUBE procesarTransaccion (Fichada fichada, BigDecimal monto) {
		//Descuenta saldo y crea  transaccion
		BigDecimal montoFinal = monto.add(BigDecimal.ZERO); //Creamos uno nuevo
		montoFinal = montoFinal.setScale(2, BigDecimal.ROUND_HALF_UP);
		this.saldo = this.saldo.subtract(montoFinal);
		return new TransaccionSUBE ( montoFinal,this, fichada );
	}

	
	
	@Override
	public String toString() {
		String propietarioString = "NINGUNO";
		if (this.propietario != null)
			propietarioString = this.propietario.getNombre();
		return "TarjetaSube [idTarjeta=" + idTarjeta + ", codigo=" + codigo + ", propietario=" + propietarioString
				+ ", transacciones=" + transacciones + ", descuentoRedSube=" + descuentoRedSube + ", saldo=" + saldo
				+ ", activa=" + activa + "]";
	}

	public TransaccionSUBE procesarSaldoMaximo (FichadaTren fichadaTren) {
		TransaccionSUBE transaccion = null;
		//System.out.println("Es de entrada");
		BigDecimal monto=fichadaTren.getEstacion().getLinea().obtenerMayorSeccion();
		monto=procesarDescuento (monto, fichadaTren);
		
		transaccion = procesarTransaccion (fichadaTren, monto);
		this.transacciones.add(transaccion);
	
		return transaccion;	
	}
	
	public boolean comprobarSaldoSuficiente (BigDecimal monto ) {//Comprueba saldo suficiente ---------------------
		
		boolean aprobado = true;
		BigDecimal montoAux = new BigDecimal (0);
		
		montoAux = this.saldo.subtract(monto);
		
		if( montoAux.compareTo(new BigDecimal (saldoMinimo))==-1) {
			aprobado = false;
		}
		return aprobado;
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

	public class Resultado{
		 private boolean aprobado;
		 private String mensaje;
		 private TransaccionSUBE transaccion;
		 public Resultado(boolean aprobado, String mensaje, TransaccionSUBE transaccion) {
			super();
			this.aprobado = aprobado;
			this.mensaje = mensaje;
			this.transaccion = transaccion;
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
		public TransaccionSUBE getTransaccion() {
			return transaccion;
		}
		public void setTransaccion(TransaccionSUBE transaccion) {
			this.transaccion = transaccion;
		}
		@Override
		public String toString() {
			return "Resultado [mensaje=" + mensaje + "]";
		}	 
	 
		
	
	}
}

