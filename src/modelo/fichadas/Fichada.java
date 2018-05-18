package modelo.fichadas;
import java.util.GregorianCalendar;

public abstract class Fichada {
	
	private int idFichada;
	private GregorianCalendar fechaHora; 
	
	public Fichada() {}
	
	public Fichada(GregorianCalendar fechaHora) {
		super();
		this.fechaHora = fechaHora;
	}

	protected void setIdFichada(int idFichada) {
		this.idFichada = idFichada;
	}
	
	public int getIdFichada() {
		return this.idFichada;
	}
	
	protected GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	protected void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Override
	public String toString() {
		return "Fichada [fechaHora=" + fechaHora;
	}
	
}
