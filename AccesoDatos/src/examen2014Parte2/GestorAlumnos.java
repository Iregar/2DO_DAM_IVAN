package examen2014Parte2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Exmane2013_miercoles.Bar;

public class GestorAlumnos {

	/**
	 * fichero fichero de texto plano donde se encuentran los alumnos
	 */
	private final static String FICHERO = "./resources/alumnos.csv";	

	// me pongo un tamaño de 20 para los caracteres del String

		final static int TAM_CAMPO = 20;
		
		//Un caracter de un String ocupa 2 bytes y un entero 4 bytes
		
		final static int TAM_REGISTRO = 4 + 40 + 40 + Float.SIZE;	
		
		
	//Me creo el fichero Binario
		
		private final static String FICHERO_BINARIO = "./resources/alumnos.dat";
	
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
	
	/**
	 * Método que migra los datos del fichero FICHERO csv al FICHERO_BINARIO	 
	 * @return devuelve true si lo ha migrado con éxtito
	 */
	//public boolean migrateFromCSV(String ficheroCSV) {
		private String rellenarString(String campo) {
			StringBuilder sb = new StringBuilder(campo);
			sb.setLength(TAM_CAMPO);

			return sb.toString();
		}

		public void migrateFromCSV() {
			RandomAccessFile aleatorio = null;
			// me creo el array donde guardare los objetos del array csv
			// y llama al metodo directamente que los guarda cargarCSVbar();

			ArrayList<Alumno> nuevaArray = obtengerAlumnosCSV();

			//me creo las variables para pasarlas al binario
			int matricula = 1;
			StringBuilder sb;
			int position = 0;
			String name, curso;
			try {
				// Fichero donde voy a escribir
				aleatorio = new RandomAccessFile(FICHERO_BINARIO, "rw");
				for (Alumno alumnos : nuevaArray) {
					// position = (id-1)*TAM_REGISTRO;
					// aleatorio.seek(position);

					aleatorio.write(matricula);

					sb = new StringBuilder(alumnos.getNombre());
					name = sb.toString();
					aleatorio.writeChars(name);

					sb = new StringBuilder(alumnos.getModulo());
					sb.setLength(TAM_CAMPO);
					curso = sb.toString();
					aleatorio.writeChars(curso);

					aleatorio.writeFloat(alumnos.getNota());
				
					matricula++;
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (aleatorio != null) {
					try {
						aleatorio.close();
					} catch (IOException e) {

					}
				}
			}
		}
		
		/**
		 * Método que guarda un alumno en un fichero binario de alto rendimiento
		 * 
		 * @param Alumno nuevo
		 *           
		 */
		public void guardarAlumno(Alumno alumno) {
			RandomAccessFile randomOut = null;
			int posicion = 0;
			StringBuilder sb;
			try {
				randomOut = new RandomAccessFile(FICHERO_BINARIO,"rw");
				//nos vampos a la posicion
				posicion = (alumno.getMatricula()-1)*TAM_REGISTRO;
				
				randomOut.seek(posicion);
				
				//con esto escribo 
				randomOut.writeInt(alumno.getMatricula());

				sb = new StringBuilder(alumno.getNombre());
				sb.setLength(TAM_CAMPO);
				randomOut.writeChars(sb.toString());

				sb = new StringBuilder(alumno.getModulo());
				sb.setLength(TAM_CAMPO);
				randomOut.writeChars(sb.toString());
				
				randomOut.writeFloat(alumno.getNota());
				
				
			} catch (FileNotFoundException e) {
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				if(randomOut!=null)
					try {
						randomOut.close();
					} catch (IOException e) {
						
					}
			}
			
		}
		
		
		
		
		
		
		

		/**
		 * Método que imprime el contenido del fichero binario con todos los bares
		 */
		public void imprimir() {
			RandomAccessFile streamIn = null;
			int matricula;
			String name, modulo;
			Float nota;
			char[] aChar = new char[TAM_CAMPO];
			char caracter;
			try {
				streamIn = new RandomAccessFile(FICHERO_BINARIO, "r");
				while (streamIn.getFilePointer() < streamIn.length()) {
					;
	//para leer hay que hacerlo char a char y luego lo metere en un array de Chars
	//mediante un for le metere el char leido al array de Char (aChar[i] = caracter);				
				
					//me leo la matricula
					matricula = streamIn.readInt();
					
					for (int i = 0; i < TAM_CAMPO; i++) {
						caracter = streamIn.readChar();
						if (caracter != 0)// no es de relleno
							aChar[i] = caracter;
						else
							aChar[i] = ' ';
					}
			
					//me leo el nombre
		//despues de leer como leo en array de char me lo convierto en String
					name = new String(aChar);

					for (int i = 0; i < TAM_CAMPO; i++) {
						caracter = streamIn.readChar();
						if (caracter != 0)// no es de relleno
							aChar[i] = caracter;
						else
							aChar[i] = ' ';
					}
					//me leo el modulo
					//despues de leer como leo en array de char me lo convierto en String
					modulo = new String(aChar);

					for (int i = 0; i < TAM_CAMPO; i++) {
						caracter = streamIn.readChar();
						if (caracter != 0)// no es de relleno
							aChar[i] = caracter;
						else
							aChar[i] = ' ';
					}
					//me leo la nota
			//despues de leer como leo en array de char me lo convierto en String
					nota = streamIn.readFloat();
							
					for (int i = 0; i < TAM_CAMPO; i++) {
						caracter = streamIn.readChar();
						if (caracter != 0)// no es de relleno
							aChar[i] = caracter;
						else
							aChar[i] = ' ';
					}
					
	
					
		Alumno alumnos = new Alumno(matricula,name, modulo, nota);
	//me mostrar siempre y cuando el id no se un cero e imprimo mi objeto bar
					if(matricula!=0) System.out.println(alumnos);

				}
			} catch (FileNotFoundException e) {

			} catch (IOException e) {
			} finally {
				if (streamIn != null) {
					try {
						streamIn.close();
					} catch (IOException e) {

					}
				}
			}
		}
	}
	

