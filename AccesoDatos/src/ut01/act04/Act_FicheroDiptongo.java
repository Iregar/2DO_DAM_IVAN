package ut01.act04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Act_FicheroDiptongo {
	
	public static void main(String[] args) throws IOException
    {
	/*
	 * Crear un nuevo fichero “DIPTONGO.TXT” con todas las palabras que 
	 * contengan al menos un diptongo.
	 */
// leo el quijote aunque no hace falta porque se lo digo abajo en el buffer
		FileReader fichero = new FileReader("./resources/QUIJOTE.txt");
	
//escribo en un fichero de texto que me creo
		FileWriter fichero1 = new FileWriter("c:/Temp/diptongos.txt");
           
		
		// me creo el contador de diptongos

				int contarDiptongos = 0;
				String test="";
			
			//me creo el buffer para leer el fichero
			
			BufferedReader leo = null;
			
			try {
				// me creo el string donde le voy a pasar todo el buffer de lineas

				String lineas = "";
			
				
				//Con esta linea abro el fichero "Quijote" y creo el buffer para leer y se lo paso 
				// a "leo"  para leer el fichero

				leo = new BufferedReader(new FileReader("./resources/QUIJOTE.txt"));
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

				//System.out.println(contarDiptongos);
				String total ="";
				total= Integer.toString(contarDiptongos);
				
				fichero1.write("hay");
	               fichero1.write(total);
	               fichero1.write("diptongos");
	            
	               //Cierro el stream
	               fichero1.close(); 
				
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

	
		}	

	}

		
