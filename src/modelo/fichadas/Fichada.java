package modelo.fichadas;
import java.util.GregorianCalendar;
public class Fichada {
	private GregorianCalendar fechaHora; 
	private float monto;
	
	public Fichada(GregorianCalendar fechaHora, float monto) {
		super();
		this.fechaHora = fechaHora;
		this.monto = monto;
	}

	public Fichada() {}

	protected GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	protected void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	protected float getMonto() {
		return monto;
	}

	protected void setMonto(float monto) {
		this.monto = monto;
	}


}
