package ut01.act04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Act_contarVocales {
	
	public int contarVocales(String quijote) {

		// me creo el contador de vocales

		int contarVocales = 0;
		
		//me creo el buffer para leer el fichero
		
		BufferedReader leerLineas = null;
		
		try {
			// me creo el string donde le voy a pasar todo el buffer de lineas

			String lineas = "";
		
			
			//Con esta linea abro el fichero "Quijote" y creo el buffer paara ller y se lo paso 
			// a "leerlineas"  para leer el fichero

			leerLineas = new BufferedReader(new FileReader(quijote));
			//reccorro el fichero hasta el final y se lo asigno a la variable linea
			
			while ((lineas = leerLineas.readLine()) != null) {
			
			//me creo un String con todas las vocales para comparalo con el fichero leido entero en lineas	
				String vocales = "aeiouAEIOU"; 
				
				/*otro bucle para leer todo el archivo que asigne a "lineas" y uso "charAt"
				 * para devolver el carácter situado en la posición 'index' pasada por parámetro. 
				 * La primera posición es la 0
				 * 
				 */
				
				for (int i = 0; i < lineas.length(); i++)
					{
					
					char casteo = lineas.charAt(i);
		/*
		 * Uso el metodo "Character.isLetter" para saber si es una letra y 
		 * el "indexOf" para devolvernos la posición, mediante un número entero, de una cadena 
		 * o un carácter dentro de una cadena de texto nada. En el caso de que el carácter
		 *  o la cadena no exista se devuelve un -1
		 */
					if (Character.isLetter(casteo) && vocales.indexOf(casteo + "") > -1)
						contarVocales++;
						} 
	
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
		}

		return contarVocales;
	}

}
