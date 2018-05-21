package modelo.Descuentos;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import modelo.fichadas.Fichada;
import util.IndexableSet;

public class LapsoDescuentoRedSube {
	
	private int idLapso;
	private static BigDecimal descuento50 = new BigDecimal(0.5);
	private static BigDecimal descuento75 = new BigDecimal(0.75);
	private GregorianCalendar fechaHoraVencimiento;
	private IndexableSet<Fichada> viajesRealizados;

	public LapsoDescuentoRedSube() {}
	
	public LapsoDescuentoRedSube(GregorianCalendar fechaHoraVencimiento) {
		super();
		this.fechaHoraVencimiento = fechaHoraVencimiento;
		this.viajesRealizados = new IndexableSet<Fichada>();
	}

	public int getIdLapso() {
		return idLapso;
	}
	
	protected void setIdLapso(int idLapso) {
		this.idLapso = idLapso;
	}
	
	public GregorianCalendar getFechaHoraVencimiento() {
		return fechaHoraVencimiento;
	}

	public void setFechaHoraVencimiento(GregorianCalendar fechaHoraVencimiento) {
		this.fechaHoraVencimiento = fechaHoraVencimiento;
	}

	public IndexableSet<Fichada> getViajesRealizados() {
		return viajesRealizados;
	}

	public void setViajesRealizados(IndexableSet<Fichada> viajesRealizados) {
		this.viajesRealizados = viajesRealizados;
	}
	
	public boolean yaTermino() {
		return (this.getCantidadViajes() >= 5 || this.fechaHoraVencimiento.before (new GregorianCalendar()));
	}
	
	public int getCantidadViajes() {
		return this.viajesRealizados.size();
	}
	
	public BigDecimal aplicarDescuento(BigDecimal importe, Fichada fichada) {
		BigDecimal importeFinal = new BigDecimal(importe.doubleValue());
		this.viajesRealizados.add(fichada);
		int cantidadViajes = this.getCantidadViajes();
		
		if (cantidadViajes == 2) //Segundo Viaje
			importeFinal = importe.multiply(descuento50);
		else if (cantidadViajes > 2)
			importeFinal = importe.multiply(descuento75);
		
		return importeFinal;
	}
}
