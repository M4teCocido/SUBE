package modelo.fichadas;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
public class Fichada {
	
	private GregorianCalendar fechaHora; 
	
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

	@Override
	public String toString() {
		return "Fichada [fechaHora=" + fechaHora + "]";
	}
	

}
