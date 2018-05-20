package modelo.fichadas.tren;

public class ViajeTren {
	
	private EstacionTren estacionOrigen;
	private EstacionTren estacionDestino;
	private SeccionTren seccionTren;
	
	public ViajeTren(EstacionTren estacionOrigen) {
		super();
		this.estacionOrigen = estacionOrigen;
		
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
	
}
