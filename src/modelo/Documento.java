package modelo;

public class Documento {
	private enum eTipoDocumento {DNI, LIBRETA_ENROLAMIENTO}
	
	private String numero; 
	private eTipoDocumento tipoDocumento; 
	
	public Documento(String numero, eTipoDocumento tipoDocumento) {
		this.numero = numero;
		this.setTipoDocumento(tipoDocumento);
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public eTipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(eTipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
}
