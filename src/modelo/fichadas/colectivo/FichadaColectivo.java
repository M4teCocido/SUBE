package modelo.fichadas.colectivo;
import modelo.fichadas.Fichada;
import modelo.fichadas.colectivo.TramoColectivo;

public class FichadaColectivo extends Fichada {
	private TramoColectivo tramo;

	public TramoColectivo getTramo() {
		return tramo;
	}

	public void setTramo(TramoColectivo tramo) {
		this.tramo = tramo;
	}

}
