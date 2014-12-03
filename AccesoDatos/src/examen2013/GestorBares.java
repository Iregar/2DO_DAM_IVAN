
package examen2013;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GestorBares {

	
	//me creo un metodo  para escribir los bares en una csv
	
	public void escribirCSVbar(ArrayList<Bar> bares){
		
		
		//me creo los ficheros de escritura
		
				FileWriter fw = null;
				BufferedWriter bw = null;
				
				try{
					//flujo de escritura
					fw = new FileWriter("./resources/Bares.csv"); // solo escribo caracter a caracter
					bw = new BufferedWriter(fw); // escribo linea lieneas
					
					//recorro con un for Each
					for (Bar bar:bares){
						StringBuilder sb = new StringBuilder();
						sb.append(bar.getName());
						sb.append(";");
						sb.append(bar.getAddress());
						sb.append(";");
						sb.append(bar.getTipo());
					
						
						//Escribo en el fichero todo en forma de String
						
						bw.write(sb.toString());
						//retorno de barra
						bw.newLine();
						
					}
					
						
					}catch (IOException e){
						System.out.println("error de fichero");
					}finally {
						if (bw!=null){
							try {
								bw.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
							}
					}
	}
				
				/**
				 * Método que lee el fichero csv FICHERO y los devuelve en una lista de
				 * objetos Bar
				 * 
				 */
				public ArrayList<Bar> cargarCSVbar() {
					ArrayList<Bar> bares = new ArrayList<Bar>();
					
					FileReader fr = null;
					BufferedReader br = null;
					String linea;
					Bar bar;
					try {
						fr = new FileReader("./resources/Bares.csv");
						br = new BufferedReader(fr);
						
						while( (linea = br.readLine())!=null){
							// sacar los campos de la linea del fichero csv
							// name;address;type				
							StringTokenizer st = new StringTokenizer(linea,";");				
							bar = new Bar(st.nextToken(),st.nextToken(),st.nextToken());
							//String [] campos = linea.split(";");
							// campos[0] name, campos[1] address campos[2] type
							//bar = new  Bar(campos[0],campos[1],campos[2]);					
							bares.add(bar);		
						}
						
					} catch (FileNotFoundException e) {
						
					} catch (IOException e) {
					
					}
					
					finally{
						if (br!=null)
							try {
								br.close();
							} catch (IOException e) {
								
							}
					}
					
					return bares;
	
	}
}
