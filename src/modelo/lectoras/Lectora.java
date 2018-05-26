package modelo.lectoras;

public abstract class Lectora {
	
	private int idLectora;
	private int nroSerie;

	public Lectora() {}

	public Lectora(int nroSerie) {
		super();
		this.setNroSerie(nroSerie);
	}

	public int getIdLectora() {
		return idLectora;
	}
	
	protected void setIdLectora(int idLectora) {
		this.idLectora = idLectora;
	}

	public int getNroSerie() {
		return nroSerie;
	}

	public void setNroSerie(int nroSerie) {
		this.nroSerie = nroSerie;
	}

}
