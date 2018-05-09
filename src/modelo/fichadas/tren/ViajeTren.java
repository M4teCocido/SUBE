package modelo.fichadas.tren;

public class ViajeTren {
	
	private EstacionTren estacionOrigen;
	private EstacionTren estacionDestino;
	private SeccionTren seccionTren;
	
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

}
