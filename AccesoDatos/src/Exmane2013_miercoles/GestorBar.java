package Exmane2013_miercoles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.jar.Attributes.Name;

import Exmane2013_miercoles.Bar;

public class GestorBar {

	/**
	 * fichero fichero de texto plano donde se encuentran los alumnos
	 */
	private final static String FICHERO = "./resources/baresExamen.csv";
	/**
	 * fichero fichero binario de alto rendimiento que guarda bares
	 */
	private final static String FICHERO_BINARIO = "./resources/bares.dat";

	// me pongo un tamaño de 20 para los caracteres del String

	final static int TAM_CAMPO = 20;
	//Un caracter de un Srting ocupa 2 bytes y un entero 4 bytes
	//como quiere un tamaño de 20 sería 20*2= 40
	final static int TAM_REGISTRO = 40 + 40 + 40 + 4;
	
	public int sumar(int a, int b){
		return a + b;
	}

	
	public int restar(int a, int b){
		return a-b;
	}
	/**
	 * Método que guarda en el csv FICHERO una lista de bares
	 * 
	 */
	public void escribirCSVbar(ArrayList<Bar> bares) {
		// me creo el archivo de escribir
		FileWriter archivo = null;

		// me creo el buffer
		BufferedWriter bufferEscritura = null;

		try {
			archivo = new FileWriter(FICHERO);
			bufferEscritura = new BufferedWriter(archivo);
			/*
			 * for each: Me creo una variable del objeto BAR y recorro mi array
			 * Bares
			 */
			for (Bar locales : bares) {
				// me creo el StringBuilder
				StringBuilder sp = new StringBuilder();
				sp.append(locales.getName());
				sp.append(";");
				sp.append(locales.getAddress());
				sp.append(";");
				sp.append(locales.getTipo());
				sp.append(";");
				sp.append(locales.getId());

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
	 * Método que lee el fichero csv FICHERO y los devuelve en una lista de
	 * objetos Bar
	 * 
	 */
	public ArrayList<Bar> cargarCSVbar() {
		ArrayList<Bar> restaurante = new ArrayList<Bar>();

		FileReader ficheroLeido = null;
		BufferedReader streamFichero = null;

		try {
			ficheroLeido = new FileReader(FICHERO);
			streamFichero = new BufferedReader(ficheroLeido);

			String linea;
			/*
			 * me creo variable donde le metele todo lo que lea d el fichero del
			 * tipo BAR
			 */

			Bar pepe;

			while ((linea = streamFichero.readLine()) != null) {
				// me creo un StringTokenizer para leer ;
				StringTokenizer st = new StringTokenizer(linea, ";");
				pepe = new Bar(st.nextToken(), st.nextToken(), st.nextToken(),
						Integer.parseInt(st.nextToken()));
				restaurante.add(pepe);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (streamFichero != null) {
				try {
					streamFichero.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return restaurante;

	}

	/**
	 * Método que guarda un bar en la posición de su id
	 * 
	 * @param Bar
	 *            nuevo
	 */
	public void guardarBar(Bar bar) {
		RandomAccessFile randomOut = null;
		int posicion = 0;
		StringBuilder sb;
		try {
			randomOut = new RandomAccessFile(FICHERO_BINARIO,"rw");
			//nos vampos a la posicion
			posicion = (bar.getId()-1)*TAM_REGISTRO;
			
			randomOut.seek(posicion);
			
			//con esto escribo 
			randomOut.writeInt(bar.getId());

			sb = new StringBuilder(bar.getName());
			sb.setLength(TAM_CAMPO);
			randomOut.writeChars(sb.toString());

			sb = new StringBuilder(bar.getAddress());
			sb.setLength(TAM_CAMPO);
			randomOut.writeChars(sb.toString());
			
			sb = new StringBuilder(bar.getTipo());
			sb.setLength(TAM_CAMPO);
			randomOut.writeChars(sb.toString());
			
			
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
	 * Método que elimina un bar de la posición de su id
	 * 
	 * @param Bar a eliminar
	 *  
	 */
	public void eliminarBar(int id) {
		//Declaro el fichero del que leele
		RandomAccessFile randomOut = null;
		int posicion = 0;
		StringBuilder sb;
		try {
			//abro el flujo e intanscio del fichero donde voy a leer
			randomOut = new RandomAccessFile(FICHERO_BINARIO, "rw");
			posicion = (id-1)*TAM_REGISTRO;
			
			if(posicion<randomOut.length()){
				//me posiciono
				randomOut.seek(posicion);
				
				//con esto escribo 
				randomOut.writeInt(0);

				sb = new StringBuilder("");
				sb.setLength(TAM_CAMPO);
				randomOut.writeChars(sb.toString());

				sb = new StringBuilder("");
				sb.setLength(TAM_CAMPO);
				randomOut.writeChars(sb.toString());
				
				sb = new StringBuilder("");
				sb.setLength(TAM_CAMPO);
				randomOut.writeChars(sb.toString());
				
			}

		

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (randomOut != null) {
				try {
					randomOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	
	/**
	 * Método que modifica un dato del fichero binario
	 * 
	 */
	public void modificar (int id){
		
		RandomAccessFile datoModificado = null;
		int posicion =0;
		StringBuilder sb;
		
		try {
			datoModificado = new RandomAccessFile(FICHERO_BINARIO, "rw");
			posicion= (id-1)*TAM_REGISTRO;
			
			if (posicion<datoModificado.length()){
				try {
					datoModificado.seek(posicion);
					//con esto escribo 
					
					datoModificado.writeInt(3);

					sb = new StringBuilder("Pepito Perez");
					sb.setLength(TAM_CAMPO);
					datoModificado.writeChars(sb.toString());
					
					sb = new StringBuilder("Av de Los estados");
					sb.setLength(TAM_CAMPO);
					datoModificado.writeChars(sb.toString());
					
					sb = new StringBuilder("Canas");
					sb.setLength(TAM_CAMPO);
					datoModificado.writeChars(sb.toString());
					
				} catch (IOException e) {
					
				}
			}
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Método que migra los datos del fichero FICHERO csv al FICHERO_BINARIO
	 */

	private String rellenarString(String campo) {
		StringBuilder sb = new StringBuilder(campo);
		sb.setLength(TAM_CAMPO);

		return sb.toString();
	}

	public void migrateFromCSV() {
		RandomAccessFile aleatorio = null;
		// me creo el array donde guardare los objetos del array csv
		// y llama al metodo directamente que los guarda cargarCSVbar();

		ArrayList<Bar> nuevaArray = cargarCSVbar();

		int id = 1;
		StringBuilder sb;
		int position = 0;
		String name, address, tipo;
		try {
			// Fichero donde voy a escribir
			aleatorio = new RandomAccessFile(FICHERO_BINARIO, "rw");
			for (Bar bares : nuevaArray) {
				// position = (id-1)*TAM_REGISTRO;
				// aleatorio.seek(position);

				aleatorio.writeInt(id);

				sb = new StringBuilder(bares.getName());
				sb.setLength(TAM_CAMPO);
				name = sb.toString();
				aleatorio.writeChars(name);

				sb = new StringBuilder(bares.getAddress());
				sb.setLength(TAM_CAMPO);
				address = sb.toString();
				aleatorio.writeChars(address);

				sb = new StringBuilder(bares.getTipo());
				sb.setLength(TAM_CAMPO);
				tipo = sb.toString();
				aleatorio.writeChars(tipo);
				id++;
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

	public void escribirRegistro(RandomAccessFile aleatorio, int id, Bar bares)
			throws IOException {
		aleatorio.writeInt(id);
		aleatorio.writeChars(rellenarString(bares.getName()));
		aleatorio.writeChars(rellenarString(bares.getAddress()));
		aleatorio.writeChars(rellenarString(bares.getTipo()));
	}

	/**
	 * Método que imprime el contenido del fichero binario con todos los bares
	 */
	public void imprimir() {
		RandomAccessFile streamIn = null;
		int id;
		String name, address, tipo;
		char[] aChar = new char[TAM_CAMPO];
		char caracter;
		try {
			streamIn = new RandomAccessFile(FICHERO_BINARIO, "r");
			while (streamIn.getFilePointer() < streamIn.length()) {
				id = streamIn.readInt();
//para leer hay que hacerlo char a char y luego lo metere en un array de Chars
//mediante un for le metere el char leido al array de Char (aChar[i] = caracter);				
				
				for (int i = 0; i < TAM_CAMPO; i++) {
					caracter = streamIn.readChar();
					if (caracter != 0)// no es de relleno
						aChar[i] = caracter;
					else
						aChar[i] = ' ';
				}
			
	//despues de leer como leo en array de char me lo convierto en String
				name = new String(aChar);

				for (int i = 0; i < TAM_CAMPO; i++) {
					caracter = streamIn.readChar();
					if (caracter != 0)// no es de relleno
						aChar[i] = caracter;
					else
						aChar[i] = ' ';
				}
				//despues de leer como leo en array de char me lo convierto en String
				address = new String(aChar);

				for (int i = 0; i < TAM_CAMPO; i++) {
					caracter = streamIn.readChar();
					if (caracter != 0)// no es de relleno
						aChar[i] = caracter;
					else
						aChar[i] = ' ';
				}
		//despues de leer como leo en array de char me lo convierto en String
				tipo = new String(aChar);
//Me creo el objeto de BAR metiendole lo que hemos leido
				Bar bar = new Bar(name, address, tipo, id);
//me mostrar siempre y cuando el id no se un cero e imprimo mi objeto bar
				if(id!=0) System.out.println(bar);

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
// ...

