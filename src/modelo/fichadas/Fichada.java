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
	
	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Override
	public String toString() {
		return "Fichada [fechaHora=" + fechaHora;
	}
	
}
