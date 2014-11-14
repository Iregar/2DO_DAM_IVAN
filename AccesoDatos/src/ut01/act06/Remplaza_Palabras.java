package ut01.act06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/*
 * Sustituir todas las apariciones de una palabra por otra en un texto
 * 
 */

public class Remplaza_Palabras {
	
	public static void main(String [] arg){
	
	//public static void reemplazoPalabras (){
	
		 
		BufferedReader leerLineas = null;
		BufferedWriter Escribir = null;
	
		try{
			//leo el fichero y el buffer de lectura
			//leerLineas = new BufferedReader(new FileReader("./resources/NovelaPoliciaca.txt"));
		leerLineas = new BufferedReader(new FileReader("./ficheros/NovelaPoliciaca.txt"));
		
		//
			Escribir = new BufferedWriter(new FileWriter("./ficheros/NovelaPoliciacaBIS.txt"));
	
	      //Recorro el fichero
		
		String lineas=null;
		
		 String nuevotexto ="";
		 
				while ((lineas = leerLineas.readLine()) != null) {
					
				nuevotexto = lineas.replaceAll("Dupin","Ivan" ).concat("\r\n");
				Escribir.write(nuevotexto);
				
				System.out.println(nuevotexto);
				}
				
			} catch (FileNotFoundException e) {

			} catch (IOException e) {

			}

			finally {
				
				if (leerLineas != null)
					try {
						leerLineas.close();
					} catch (IOException e) {
					}
				if (Escribir != null)
					try {
						Escribir.close();
					} catch (IOException e) {
					}
			}

		}

	}

