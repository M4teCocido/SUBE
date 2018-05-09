package modelo;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import modelo.Documento;
import modelo.TarjetaSube;
import modelo.fichadas.Fichada;
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
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
	
}
