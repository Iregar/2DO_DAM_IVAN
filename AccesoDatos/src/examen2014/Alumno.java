package examen2014;

import java.io.Serializable;

public class Alumno implements Serializable{

	private String nombre, modulo;
	private float nota;
	private int matricula;
	

	//constructor vacio propio de un javabeans
	
	public Alumno() {
		
		nombre =null;
		modulo = null;
		nota = 0;
		matricula = 0;
	}
	
	
	public Alumno(int matricula, String nombre, String modulo, float nota) {
		super();
		this.nombre = nombre;
		this.modulo = modulo;
		this.nota = nota;
		this.matricula = matricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}


	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", modulo=" + modulo + ", nota="
				+ nota + ", matricula=" + matricula + "]";
	}

	
	
}
