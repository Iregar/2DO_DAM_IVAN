package ut01.act04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Act_contaLineas {

	public int contarLineas(String quijote) {

		// me creo el contador de lineas

		int lineasContadas = 0;
		
		//me creo el buffer para leer
		
		BufferedReader leerLineas = null;
		try {
			// me creo el string donde le voy a pasar todo el buffer de lineas

			String lineas = "";
			
			// abro el buffer para leer el fichero

			leerLineas = new BufferedReader(new FileReader(quijote));
			while ((lineas = leerLineas.readLine()) != null) {
				lineasContadas++;
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

		return lineasContadas;
	}

}
