package modelo;

public class Documento {
	private String numero; 
	private enum eEtipoDocumento {tipo1,tipo2}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
