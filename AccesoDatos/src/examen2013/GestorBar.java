package examen2013;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GestorBar {

	/**
	 * fichero fichero de texto plano donde se encuentran los alumnos
	 */
	private final static String FICHERO = "./ficheros/pafetos.csv";
	
	/**
	 * Método que guarda en el csv FICHERO una lista de bares
	 * 
	 */
	public void escribirCSVbar(ArrayList<Bar> bares) {
		
		FileWriter output = null;
		BufferedWriter fw = null;
		
		 try {
			
			output = new FileWriter(FICHERO);
			fw = new BufferedWriter(output);
			
			for (Bar pafetos: bares){
				StringBuilder sp = new StringBuilder();
				sp.append(pafetos.getName());
				sp.append(";");
				sp.append(pafetos.getAddress());
				sp.append(";");
				sp.append(pafetos.getType());
				
				fw.write(sp.toString()); //paso el StringBuilder a String
				fw.newLine(); //le doy un salto de linea
				
			}
			
		} catch (IOException e) {
			
		}finally{
			if (fw!= null){
				try {
					fw.close();
				} catch (IOException e) {
				
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
		ArrayList<Bar> pizzas = new ArrayList<Bar> ();
		//me creo lector y flujo
		FileReader lector= null;
		BufferedReader leyendo= null;
		 //me creo un objeto de clase Bar para recoger lo que lea
		Bar bares;
		String linea;
		
		try {
			leyendo = new BufferedReader(new FileReader(FICHERO));
			while((linea= leyendo.readLine())!=null){
				//me creo un objeto StringTokenizer para decirle donde cortar en este caso ;
				StringTokenizer dp = new StringTokenizer(linea,";");
				
				//Al objeto bares le añado todo lo que voy leyendo + el ;
				bares= new Bar(dp.nextToken(),dp.nextToken(),dp.nextToken());
			
				//Le meto a mi array todo lo leido en el objeto bares
				pizzas.add(bares);
				}
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}finally{
			if (leyendo!= null){
				try {
					leyendo.close();
				} catch (IOException e) {
				
				}
			}
		}
		
		//devuelvo mi array
		return pizzas;
	}
}