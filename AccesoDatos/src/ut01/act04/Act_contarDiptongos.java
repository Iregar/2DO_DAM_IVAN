package ut01.act04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Act_contarDiptongos {
	
	public int contarDiptongos(String quijote) {

		
	// me creo el contador de diptongos

			int contarDiptongos = 0;
		
		//me creo el buffer para leer el fichero
		
		BufferedReader leo = null;
		
		try {
			// me creo el string donde le voy a pasar todo el buffer de lineas

			String lineas = "";
		
			
			//Con esta linea abro el fichero "Quijote" y creo el buffer para leer y se lo paso 
			// a "leo"  para leer el fichero

			leo = new BufferedReader(new FileReader(quijote));
			//reccorro el fichero hasta el final y se lo asigno a la variable linea
			
			while ((lineas = leo.readLine()) != null) {

				
				/*recorro con un for todo el fichero y lo compraro con if con las posibles
				 * posibilidades de un diptongo
				 */
				
				
				for(int i=0;i < lineas.length();i++){
				if (lineas.indexOf("ui")>-1){
					contarDiptongos++;
				}else if(lineas.indexOf("au")>-1){
					contarDiptongos++;
				}else if(lineas.indexOf("eu")>-1){
					contarDiptongos++;
				}		
		}	 //cierro el for
} //cierro while

		}catch (FileNotFoundException e) {

		} catch (IOException e) {

		}

		finally {
			if (leo != null)
				try {
					leo.close();
				} catch (IOException e) {
				}
		}

		return contarDiptongos;
	}	

}

	


