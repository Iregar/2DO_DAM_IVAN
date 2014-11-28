

import java.io.File;
import java.util.Scanner;
/**
 * Ejemplo de como mostar el contenido de un directorio
 *@author Iván Reyes
 *@author www.uem.es
 *@version 2.0
 */
public class OpenDirectory {

	/**
	 * Voy a recorrer el directorio Temp y mostrar sus ficheros
	 * @see PruebasJavaDoc
	 * @param args argumentos introducidos
	 */
	public static void main(String[] args) {
	
		
		
		PruebasJavaDoc doc = new PruebasJavaDoc();
		doc.mostrar();
		
	System.out.println("voy a ver los ficheros de un directorio");
		File carpeta = new File ("c:\\temp" );
		String []archivos = carpeta.list();
		for (int i=0; i<archivos.length; i++){
			System.out.println(archivos[i]);
		}
		/** 
		 * Atacare a algunos atributos de la clase
		 * 
		 */
		
		
		System.out.println("voy a ver las propiedades de los ficheros en un directorio");		
		
		File fichero = new File ("c:\\temp\\pepe.docx");
		if (fichero.exists()){
			System.out.println("El fichero se llama "+ fichero.getName());
			System.out.println("La ruta del fichero es "+ fichero.getPath());
			System.out.println("La ruta absoluta del fichero es "+ fichero.getAbsolutePath());
			System.out.println("El espacio libre del fichero es "+ fichero.getFreeSpace());
			System.out.println("El tamaño del fichero es "+ fichero.length());
			System.out.println("El fichero es "+ fichero.isDirectory());
			System.out.println("El fichero es "+ fichero.isFile());
			
			
		}
		
		
		
	}

}
