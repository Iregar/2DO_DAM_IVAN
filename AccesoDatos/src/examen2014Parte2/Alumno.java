package examen2014Parte2;

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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricula;
		result = prime * result + ((modulo == null) ? 0 : modulo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + Float.floatToIntBits(nota);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (matricula != other.matricula)
			return false;
		if (modulo == null) {
			if (other.modulo != null)
				return false;
		} else if (!modulo.equals(other.modulo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Float.floatToIntBits(nota) != Float.floatToIntBits(other.nota))
			return false;
		return true;
	}

	
	
}
