package modelo.fichadas.tren;
import modelo.fichadas.Fichada;
import modelo.fichadas.tren.EstacionTren;

public abstract class FichadaTren extends Fichada {
	private enum eTipoFichadaTren {ENTRADA,SALIDA};
	
	private EstacionTren estacion;
	private eTipoFichadaTren tipoFichada;
	
	public eTipoFichadaTren getTipoFichada() {
		return tipoFichada;
	}

	public void setTipoFichada(eTipoFichadaTren tipoFichada) {
		this.tipoFichada = tipoFichada;
	}

	public EstacionTren getEstacion() {
		return estacion;
	}
	
	public void setEstacion(EstacionTren estacion) {
		this.estacion = estacion;
	}
	
}
