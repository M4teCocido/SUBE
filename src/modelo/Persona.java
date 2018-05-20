package modelo;
import java.text.SimpleDateFormat;
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
	
	public void setEmail(String email) throws Exception{
		if (validarEmail() == false) throw new Exception("El email contiene alguno de los siguientes caracteres no permitidos: ¡!?¿+^*¨Ç:;/");
		else this.email = email;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) throws Exception{
		if (validarCelular() == false) throw new Exception("El celular esta mal ingresado (no comienza con 11 o 15, contiene letras, mayor/menor a 10 digitos).");
		else this.celular = celular;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) throws Exception{
		if (validarTelefono() == false) throw new Exception("El telefono esta mal ingresado (mayor/menor a 8 digitos).");
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
		if (celular.matches("[0-9]+") && (celular.length() == 10)) {
			if (celular.substring(0).matches("[1]")) {
				if (celular.substring(1).matches("[1]") || (celular.substring(1).matches("[5]"))) valido = true;
			}
		}
		return valido;
	}
	
	public boolean validarEmail() {
		boolean valido = false;
		if (email.contains("@") && !email.substring(0, email.indexOf("@") - 1).matches("[¡!?¿+^*¨Ç:;/]*")) valido = true;
		return valido;
	}
	
	public static String fechaCorta (GregorianCalendar fecha) {
		return new SimpleDateFormat("dd/MM/yyyy").format(fecha.getTime());
	}
	
	
}

