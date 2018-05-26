package modelo.fichadas;
import java.util.GregorianCalendar;

public abstract class Fichada {
	
	private int idFichada;
	private int idLectora;
	private GregorianCalendar fechaHora; 
	
	public Fichada() {}
	
	public Fichada(GregorianCalendar fechaHora, int idLectora) {
		super();
		this.setIdLectora(idLectora);
		this.fechaHora = fechaHora;
	}

	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	public int getIdFichada() {
		return idFichada;
	}

	public void setIdFichada(int idFichada) {
		this.idFichada = idFichada;
	}
	
	public int getIdLectora() {
		return idLectora;
	}

	public void setIdLectora(int idLectora) {
		this.idLectora = idLectora;
	}
	
	@Override
	public String toString() {
		return "Fichada [fechaHora=" + fechaHora;
	}

	
}
