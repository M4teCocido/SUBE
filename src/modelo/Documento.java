package modelo;
import modelo.eTipoDocumento;

public class Documento {
	
	private int idDocumento;
	private String numero;
	private eTipoDocumento tipoDocumento;
	
	public Documento() {}
	
	public Documento(String numero, eTipoDocumento tipoDocumento) throws Exception {
		this.setNumero(numero);
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
		if (validar(numero) == false) throw new Exception("El documento esta mal ingresado.");
		else this.numero = numero;
	}

	public eTipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(eTipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Override
	public String toString() {
		return getNumero() + "\nTipo de documento: " + getTipoDocumento();
	}

	public boolean validar(String numero) {
		boolean valido = false;
		if (numero.matches("^[0-9]*$") && (numero.length() > 6 && numero.length() < 9)) valido = true;
		return valido;
	}
}
