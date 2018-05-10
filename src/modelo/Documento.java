package modelo;

public class Documento {
	private enum eTipoDocumento {DNI, LIBRETA_ENROLAMIENTO}
	
	private String numero; 
	private eTipoDocumento tipoDocumento; 
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
