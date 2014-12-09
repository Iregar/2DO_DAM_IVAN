package examen2014;
import java.util.ArrayList;

import Exmane2013_miercoles.Bar;

public class Test {

	public static void main(String[] args) {
	
		GestorAlumnos ga = new GestorAlumnos();
	
		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		alumnos.add(new Alumno(1,"Carlos","Acceso Datos",9));
		alumnos.add(new Alumno(2,"Pepe","Acceso Datos",8));
		alumnos.add(new Alumno(3,"Maria","Sistemas de Gestión Empresarial",8));
		alumnos.add(new Alumno(4,"Lucia","Inglés",8));
		
		//ga.guardarAlumnoCSV(1,"Carlos","Acceso Datos",9);
		//ga.guardarAlumnoCSV(2,"Pepe","Acceso Datos",8);
		//ga.guardarAlumnoCSV(3,"Maria","Sistemas de Gestión Empresarial",8);
		//ga.guardarAlumnoCSV(4,"Lucia","Inglés",8);
		
		//ArrayList<Alumno> alumnos = obtengerAlumnosCSV();
		
		//llamo al metodo para crearme el csv
		ga.escribirCSValumnos(alumnos);
		
		ga.obtengerAlumnosCSV();
		
		for(Alumno alumno:alumnos){
			System.out.println(alumno);
		}

	}

}