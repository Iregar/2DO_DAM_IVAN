package ut01.act06;


import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;



/*
 * Crear un fichero de texto “DOUBLE.BIN” con números reales (double)
 *  introducidos por teclado.
 */

public class FicheroNumReales {

	
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
	