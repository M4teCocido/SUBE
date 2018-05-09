package modelo;
import java.util.ArrayList;
import modelo.Descuentos.*;

import modelo.Persona;
import modelo.Descuentos.DescuentoTarifaSocial;
import modelo.fichadas.*;
import modelo.fichadas.colectivo.FichadaColectivo;
import modelo.fichadas.subte.FichadaSubte;
import modelo.fichadas.tren.FichadaTren;


public class TarjetaSube {
	private String codigo;
	private Persona owner;
	private ArrayList<Fichada> fichadas;
	private DescuentoTarifaSocial descuentoTarifaSocial;
	private DescuentoRedSube descuentoRedSube;
	private DescuentoBoletoEstudiantil descuentoVoletoEstudiantil;
	private float saldo;

	

	public void efectuarCarga (float monto) {
		
		
	}
	
	public void procesarFichada(FichadaColectivo fichadaColectivo) {
		
	}
	
	public void procesarFichada(FichadaTren fichadaTren) {
		
	}
	
	public void procesarFichada (FichadaSubte fichadaSubte) {
	
	}
	
	

}