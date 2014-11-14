package ut01.act04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Act_frecuenciaVocales {
	
	

	public int frecuenciaVocales(String quijote) {

		
		// me creo el contador de la vocal a o A

				int cuenta_a = 0;
		
				
				
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
					 * posibilidades
					 */
					
					
					for(int x=0;x < lineas.length();x++){
						
				              if(lineas.charAt(x)=='a'){
				            	  cuenta_a++;
				              if(lineas.charAt(x)=='A'){
				            	  cuenta_a++;
				            
				        }
							
				              } 
				              
			}	
	}

				
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

			return cuenta_a;
			
		}	

	}

		




