package ut01.act04;

import java.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Act_contarMinusculas {

	public int contarMinusculas (String quijote) {
		//me creo el contador
		
		int cuentaMinusculas =0;
		
		//me creo el buffer para leer las minusculas y la llamo wordlow
		
		FileReader wordlow = null;
		
		try {
			
			// abro el buffer para leer el fichero

			wordlow = new FileReader(quijote);
			
			//me creo la variable donde voy a ver los caracteres para luego comporarlos
			// con el metodo booleanisLowerCase(char caracter) q 
			//Retorna un verdadero si el carácter del parámetro es una letra minúscula 
			
			
			
			//reccorro el fichero y me creo un string donde voy a devolver el valor
			
			int letra;
			
			while ((letra = wordlow.read())!=-1){
				
			if (Character.isLowerCase((char) letra)){
			
				
				cuentaMinusculas++;
			}
				
		} //cierro el while
				
			
			
			
			
			
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}

		finally {
			if (wordlow != null)
				try {
					wordlow.close();
				} catch (IOException e) {
				}
		}

		return cuentaMinusculas;
	}

}
