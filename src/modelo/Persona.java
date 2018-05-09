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
}
