package test;

import java.util.GregorianCalendar;

import modelo.Persona;

public class TestPersona {

	public static void main(String[] args) {
		GregorianCalendar fecha = new GregorianCalendar (1993, 11, 16);
		try {
			Persona per = new Persona ("Gonzalo", "Montana", fecha, "gonzamcomps@gmail.com", "1558912066", "42991823");
			System.out.println(per.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage() + e.getCause());
			e.printStackTrace();
		}
	}
}