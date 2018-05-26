package modelo.lectoras;

import modelo.fichadas.colectivo.InternoColectivo;

public class LectoraColectivo extends Lectora {
	private InternoColectivo interno;
	
	public LectoraColectivo() {}
	
	public LectoraColectivo(InternoColectivo interno) {
		super();
		this.interno = interno;
	}
	
	public InternoColectivo getInterno() {
		return interno;
	}
	
	public void setInterno(InternoColectivo interno) {
		this.interno = interno;
	}
}
