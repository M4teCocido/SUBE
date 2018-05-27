package modelo.fichadas;
import java.util.GregorianCalendar;

import modelo.lectoras.Lectora;

public abstract class Fichada {
	
	private int idFichada;
	private Lectora lectora;
	private GregorianCalendar fechaHora; 
	
	public Fichada() {}
	
	public Fichada(GregorianCalendar fechaHora, Lectora lectora) {
		super();
		this.setLectora(lectora);
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
	
	public Lectora getLectora() {
		return lectora;
	}

	public void setLectora(Lectora lectora) {
		this.lectora = lectora;
	}
	
	@Override
	public String toString() {
		return "Fichada [fechaHora=" + fechaHora;
	}	
}
