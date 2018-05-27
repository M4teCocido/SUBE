package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import dao.fichadas.colectivo.InternoColectivoDao;
import dao.fichadas.colectivo.LineaColectivoDao;
import dao.fichadas.colectivo.TramoColectivoDao;
import dao.lectoras.LectoraColectivoDao;
import modelo.fichadas.colectivo.InternoColectivo;
import modelo.fichadas.colectivo.LineaColectivo;
import modelo.fichadas.colectivo.TramoColectivo;
import modelo.lectoras.LectoraColectivo;



public class TestCreacionMaestrosColectivo {

	private static int numeroSerieLectora = 2000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Generamos Maestros de Subte
		
		LineaColectivoDao daoLinea = new LineaColectivoDao();
		InternoColectivoDao daoEstacion = new InternoColectivoDao();
		TramoColectivoDao daoTramo = new TramoColectivoDao();
		LectoraColectivoDao daoLectora = new LectoraColectivoDao();
		
		LineaColectivo linea74 = new LineaColectivo("74");
		List<TramoColectivo> tramosLinea74 = new ArrayList<TramoColectivo>();
		List<InternoColectivo> internosLinea74 = new ArrayList<InternoColectivo>();
		List<LectoraColectivo> lectorasLinea74 = new ArrayList<LectoraColectivo>();
		
		agregarEstacionSubte("Constitucion", lineaC, estacionesLineaC, lectorasLineaC);
		agregarEstacionSubte("San Juan", lineaC, estacionesLineaC, lectorasLineaC);
		agregarEstacionSubte("Independencia", lineaC, estacionesLineaC, lectorasLineaC);
		agregarEstacionSubte("Mariano Moreno", lineaC, estacionesLineaC, lectorasLineaC);
		agregarEstacionSubte("Avenida de Mayo", lineaC, estacionesLineaC, lectorasLineaC);
		agregarEstacionSubte("Diagonal Norte", lineaC, estacionesLineaC, lectorasLineaC);
		agregarEstacionSubte("Lavalle", lineaC, estacionesLineaC, lectorasLineaC);
		agregarEstacionSubte("General San Martin", lineaC, estacionesLineaC, lectorasLineaC);
		agregarEstacionSubte("Retiro", lineaC, estacionesLineaC, lectorasLineaC);

		//Persistimos.
		try {
			daoLineaSubte.agregarLinea(lineaC);
			
			for (EstacionSubte e : estacionesLineaC) {
				daoEstacionSubte.agregarEstacion(e);
			}
			
			for (LectoraSubte l : lectorasLineaC) {
				daoLectoraSubte.agregarLectora(l);
			}
		} catch (HibernateException he) {
			System.out.println(he.getMessage() + ", " + he.toString());
			he.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage() + ", " + e.toString());
			e.printStackTrace();
		}
		
	}

	private static void agregarEstacionSubte(String nombre, LineaSubte linea, List<EstacionSubte> estaciones, List<LectoraSubte> lectoras) {
		EstacionSubte estacion = new EstacionSubte(nombre, linea);
		estaciones.add(estacion);
		lectoras.add(new LectoraSubte(numeroSerieLectora++, estacion));
	}
	
}
