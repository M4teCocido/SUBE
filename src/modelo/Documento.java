package modelo;

public class Documento {
	private enum eTipoDocumento {DNI, LIBRETA_ENROLAMIENTO}
	
	private int idDocumento;
	private String numero; 
	private eTipoDocumento tipoDocumento; 
	
	public Documento() {}
	
	public Documento(String numero, eTipoDocumento tipoDocumento) {
		this.numero = numero;
		this.setTipoDocumento(tipoDocumento);
	}
	
	protected void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}
	
	public int getIdDocumento() {
		return this.idDocumento;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) throws Exception{
		if (validar() == false) throw new Exception("El documento esta mal ingresado.");
		else this.numero = numero;
	}

	public eTipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(eTipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public boolean validar() {
		boolean valido = false;
		if (numero.matches("[0-9]+") && (numero.length() > 6 && numero.length() < 9)) valido = true;
		return valido;
	}
}
