package modelo.fichadas.tren;

public class ViajeTren {
	
	private int idViaje;
	private EstacionTren estacionOrigen;
	private EstacionTren estacionDestino;
	private SeccionTren seccionTren;
	private RecorridoTren recorrido;
	
	public ViajeTren(EstacionTren estacionOrigen) {
		super();
		this.estacionOrigen = estacionOrigen;
	}
		
	public ViajeTren(EstacionTren estacionOrigen, EstacionTren estacionDestino, SeccionTren seccionTren, RecorridoTren recorrido) {
		super();
		this.estacionOrigen = estacionOrigen;
		this.estacionDestino = estacionDestino;
		this.seccionTren = seccionTren;
		this.recorrido = recorrido;
	}

	public int getIdViaje() {
		return this.idViaje;
	}
	
	protected void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}
	
	public EstacionTren getEstacionOrigen() {
		return estacionOrigen;
	}
	
	public void setEstacionOrigen(EstacionTren estacionOrigen) {
		this.estacionOrigen = estacionOrigen;
	}
	
	public EstacionTren getEstacionDestino() {
		return estacionDestino;
	}
	
	public void setEstacionDestino(EstacionTren estacionDestino) {
		this.estacionDestino = estacionDestino;
	}
	
	public SeccionTren getSeccionTren() {
		return seccionTren;
	}
	
	public void setSeccionTren(SeccionTren seccionTren) {
		this.seccionTren = seccionTren;
	}

	@Override
	public String toString() {
		return "ViajeTren [estacionOrigen=" + estacionOrigen + ", estacionDestino=" + estacionDestino + ", seccionTren="
				+ seccionTren + "]";
	}

	public RecorridoTren getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(RecorridoTren recorrido) {
		this.recorrido = recorrido;
	}
}
