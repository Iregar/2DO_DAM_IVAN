package ut01.act06;


import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


/*
 * Recojo numeros binarios por teclado y los guardo en fichero
 */
public class MostrarBinario {

	public static void main(String[] args) {
		
		// me declaro el objeto de Scanner para recoger por teclado
		Scanner teclado = new Scanner(System.in).useLocale(Locale.US);
				
				//me ceclaro la variable donde recogele los doubles
				double texto = 0;
				
				//Declaro  los flujos de datos fichero y flujo
				
						DataOutputStream escriba=null;
						
						try {
							
							//me creo el fichero de salida
				escriba = new DataOutputStream(new FileOutputStream("./ficheros/DOUBLE.bin"));
				
				do{
						
						System.out.println ("Introduce los numeros reales, por favor");
						texto=teclado.nextDouble();
						escriba.writeDouble(texto);
							}while(texto != -1); //cierro el bucle cuando se ponga un numero negativo
		
						//cierro el fichero
						escriba.close();
					
			
						//empiezo a leer el fichero Double.bin
						
	
			BufferedInputStream leido = new BufferedInputStream(new FileInputStream("./ficheros/DOUBLE.bin"));
			
			//LLamo a la Clase StringBuilder para concatenar objetos
			StringBuilder sp = new StringBuilder();
			
			int n;
			//bucle para leer fichero Binario
			
				while((n=leido.read())!=-1){
					sp.append(n);
				sp.append(" ");
				}
				System.out.println(sp);
				leido.close();
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

