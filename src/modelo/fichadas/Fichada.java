package modelo.fichadas;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
<<<<<<< HEAD
public  abstract class Fichada {
=======

public class Fichada {
	
>>>>>>> c4dede986a9ffb9428874e5db7e012fd28289adc
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
