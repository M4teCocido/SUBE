package modelo.fichadas;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
public class Fichada {
	private GregorianCalendar fechaHora; 
	private BigDecimal monto;
	
	public Fichada(GregorianCalendar fechaHora) {
		super();
		this.fechaHora = fechaHora;
		
	}

	public Fichada() {}

	protected GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	protected void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	protected BigDecimal getMonto() {
		return monto;
	}

	protected void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Fichada [fechaHora=" + fechaHora + ", monto=" + monto + "]";
	}
	
	

}
