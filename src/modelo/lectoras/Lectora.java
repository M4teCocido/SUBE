package modelo.lectoras;

public abstract class Lectora {
private int idLectora;
private String nombre;

public Lectora() {
}

public Lectora(String nombre) {
	super();
	this.nombre = nombre;
}

public int getIdLectora() {
	return idLectora;
}
public String getNombre() {
	return nombre;
}
protected void setIdLectora(int idLectora) {
	this.idLectora = idLectora;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}


}
