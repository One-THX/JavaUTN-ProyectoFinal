package ar.com.cdt.javaUTN.entity;

import javax.persistence.*;

@Entity
@Table(name="estudianteentity")
public class EstudianteEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
 public Long id;

 public EstudianteEntity() {
	super();
}

 public String nombre;
 public String apellido;
 public long DNI;
 public int edad;
 
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}


public EstudianteEntity(Long id, String nombre, String apellido, long dNI, int edad) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.apellido = apellido;
	DNI = dNI;
	this.edad = edad;
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
public long getDNI() {
	return DNI;
}
public void setDNI(long dNI) {
	DNI = dNI;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}

@Override
public String toString() {
	return "EstudianteEntity [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", DNI=" + DNI + ", edad="
			+ edad + "]";
}

}
