package examen2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Exmane2013_miercoles.Bar;

public class GestorAlumnos {

	/**
	 * fichero fichero de texto plano donde se encuentran los alumnos
	 */
	private final static String FICHERO = "./resources/alumnos.csv";	

	
	/**
	 * Método que me crea un csv de una lista de alumnos
	 * 
	 */
	public void escribirCSValumnos(ArrayList<Alumno> alumnos) {
		// me creo el archivo de escribir
		FileWriter archivo = null;

		// me creo el buffer
		BufferedWriter bufferEscritura = null;
		
		//El array que me da es: ArrayList<Alumno> alumnos = obtengerAlumnosCSV();
		try {
			archivo = new FileWriter(FICHERO);
			bufferEscritura = new BufferedWriter(archivo);
			/*
			 * for each: Me creo una variable del objeto BAR y recorro mi array
			 * Bares
			 */
			for (Alumno clase : alumnos) {
				// me creo el StringBuilder
				StringBuilder sp = new StringBuilder();
				sp.append(clase.getMatricula());
				sp.append(";");
				sp.append(clase.getNombre());
				sp.append(";");
				sp.append(clase.getModulo());
				sp.append(";");
				sp.append(clase.getNota());

				bufferEscritura.write(sp.toString()); // lo paso a String
				bufferEscritura.newLine(); // le doy un salto de linea
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bufferEscritura != null) {
				try {
					bufferEscritura.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	
	/**
	 * Método que no sobreescribe el fichero y 
       * guarda el alumno al final del fichero csv 
	 */	
	public void guardarAlumnoCSV(int matricula, String nombre, String modulo, float nota) {
		// me creo el archivo de escribir
		FileWriter archivo = null;

		// me creo el buffer
		BufferedReader leer=null;
		BufferedWriter fw = null;
		
		
		try {
			archivo = new FileWriter(FICHERO,true);
			
			fw= new BufferedWriter(archivo);
		
				StringBuilder sp = new StringBuilder();
				sp.append(Integer.toString(matricula));
				sp.append(";");
				sp.append(nombre);
				sp.append(";");
				sp.append(modulo);
				sp.append(Float.toString(nota));
				
				fw.write(sp.toString()); //paso el StringBuilder a String
				fw.newLine(); //le doy un salto de linea
			
			
		} catch (IOException e) {
			
		}finally {
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					
				}
			}
		}
		
		
	}
	/**
	 * Método que lee el fichero csv FICHERO y los devuelve en una lista de
	 * objetos Alumno
	 * 
	 */
	public ArrayList<Alumno> obtengerAlumnosCSV() {
	
	//El array que me da es: ArrayList<Alumno> alumnos = obtengerAlumnosCSV();
		//me creo mi array
	ArrayList<Alumno> students = new ArrayList<Alumno>();
	
	// me creo el archivo para leer y el buffer
	FileReader leer = null;
	BufferedReader input = null;
	
	try {
		leer = new FileReader(FICHERO);
		input = new BufferedReader(leer);
		
		String linea;
		//me creo un objeto de la clase Alumno
		Alumno pepito;
		try {
			while ((linea = input.readLine()) != null) {
				// me creo un StringTokenizer para leer ;
				StringTokenizer st = new StringTokenizer(linea, ";");
		pepito = new Alumno(Integer.parseInt(st.nextToken()), st.nextToken(), 
				st.nextToken(),Float.parseFloat(st.nextToken()));
						
				students.add(pepito);
			}
				
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (FileNotFoundException e) {
		
	}finally{
		if(input!=null){
			try {
				input.close();
			} catch (IOException e) {
			
			}
		}
	}
	return students;
}
	
	
}