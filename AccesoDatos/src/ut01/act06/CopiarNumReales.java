package ut01.act06;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*Crear un fichero binario “ENTEROS.BIN” pasándole el 
 * contenido del fichero “ENTEROS.TXT” con números separados por puntos y coma.
 * 
 */
public class CopiarNumReales {

	public static void main(String[] args) {
		// me declaro el objeto de Scanner para recoger por teclado
		
		Scanner teclado = new Scanner(System.in);
		
		//me ceclaro la variable donde recogele los doubles
		double texto = 0;
		
		//Declaro  los flujos de datos fichero y flujo
		
				DataOutputStream escriba=null;
				try {
					
					//me creo el fichero de salida
					
		escriba = new DataOutputStream(new FileOutputStream("./ficheros/DOUBLE.bin"));
	
					do{
						escriba.writeDouble(texto);
				System.out.println ("Introduce los numeros reales, por favor");
				texto=teclado.nextDouble();
					}while(texto != -1); //cierro el bucle cuando se ponga un numero negativo
				
					//cierro el fichero
					escriba.close();
				
		//abro flujo para leer
	
    // Se abre el fichero original para lectura y su flujo
					
  FileInputStream leerArchivo = new FileInputStream("./ficheros/DOUBLE.bin");
    BufferedInputStream bufferLeido = new BufferedInputStream(leerArchivo);
    
    	//me creo el objeto para y almacenando todos los valores(Objeto StringBuilder)
    
    					StringBuilder sb = new StringBuilder();
	int number =0;
	while((number=bufferLeido.read())!=-1){
	sb.append(number);
		}			
	//cierro el buffer de leer el fichero
	
	bufferLeido.close();
		System.out.println(sb);
				
				}	 catch (FileNotFoundException e) {
					
				} catch (IOException e) {
					
				}
				finally{
					if(escriba!=null)
						try {
							escriba.close();
						} catch (IOException e) {
							
					}
				}
				}
			}



