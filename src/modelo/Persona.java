package modelo;
//import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import modelo.Documento;
import modelo.TarjetaSube;
import modelo.Descuentos.*;

public class Persona {
	private enum eGenero {M, F};
	
	private String nombre;
	private String apellido;
	private Documento documento;
	private eGenero genero;
	private GregorianCalendar fechaNacimiento;
	private String email;
	private String celular;
	private String telefono;
	private ArrayList<TarjetaSube> tarjetasAsociadas;
	private DescuentoTarifaSocial descuentoTarifaSocial;
	private DescuentoBoletoEstudiantil descuentoBoletoEstudiantil;
	
	
	
	public Persona() {}



	public Persona(String nombre, String apellido, Documento documento, eGenero genero,
			GregorianCalendar fechaNacimiento, String email, String celular, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.celular = celular;
		this.telefono = telefono;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Documento getDocumento() {
		return documento;
	}
	
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	
	public eGenero getGenero() {
		return genero;
	}
	
	public void setGenero(eGenero genero) {
		this.genero = genero;
	}
	
	public GregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) throws Exception{
		if (validarCelular() == false) throw new Exception("El celular esta mal ingresado.");
		else this.celular = celular;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) throws Exception{
		if (validarTelefono() == false) throw new Exception("El telefono esta mal ingresado.");
		else this.telefono = telefono;
	}
	
	public ArrayList<TarjetaSube> getTarjetasAsociadas() {
		return tarjetasAsociadas;
	}
	
	public void setTarjetasAsociadas(ArrayList<TarjetaSube> tarjetasAsociadas) {
		this.tarjetasAsociadas = tarjetasAsociadas;
	}
	
	public DescuentoTarifaSocial getDescuentoTarifaSocial() {
		return descuentoTarifaSocial;
	}
	
	public void setDescuentoTarifaSocial(DescuentoTarifaSocial descuentoTarifaSocial) {
		this.descuentoTarifaSocial = descuentoTarifaSocial;
	}
	
	public DescuentoBoletoEstudiantil getDescuentoBoletoEstudiantil() {
		return descuentoBoletoEstudiantil;
	}

	public void setDescuentoBoletoEstudiantil(DescuentoBoletoEstudiantil descuentoBoletoEstudiantil) {
		this.descuentoBoletoEstudiantil = descuentoBoletoEstudiantil;
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento + ", genero="
				+ genero + ", fechaNacimiento=" + fechaNacimiento + ", email=" + email + ", celular=" + celular
				+ ", telefono=" + telefono + ", tarjetasAsociadas=" + tarjetasAsociadas + ", descuentoTarifaSocial="
				+ descuentoTarifaSocial + "]";
	}
	
	public boolean asignarDescuentoBoletoEstudiantil(DescuentoBoletoEstudiantil descuento) {
		this.descuentoBoletoEstudiantil = descuento;
		return false;
	}
	
	public boolean asignarDescuentoTarifaSocial(DescuentoTarifaSocial descuento) {
		this.descuentoTarifaSocial = descuento;
		return false;
	}
	
	public boolean validarTelefono() {
		boolean valido = false;
		if (telefono.matches("[0-9]+") && (telefono.length() > 6 && telefono.length() < 9)) valido = true;
		return valido;
	}
	
	public boolean validarCelular() {
		boolean valido = false;
		//podria chequear si los 2 primeros numeros son 11 o 15
		if (celular.matches("[0-9]+") && (celular.length() == 10)) valido = true;
		return valido;
	}
	
}
