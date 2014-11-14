package ut01.act05;

import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio5 {

	private static final String ERROR_IO = "Error al abrir fichero";
	
	//me creo una arrya Bidimensional  llamada jugadores
	
	static String[] [] jugadores = {
		{ "Casillas", "Pepe", "Sergio", "Carvajal",
			"Marcelo", "Modric", "Kroos", "Isco", "James", "Cristiano",
			"Benzema"},
		{ "Bravo", "Alves", "Masquerano", "Alba",
			"Mathieu", "Xabi", "Iniesta", "Neymar", "Messi", "L.Suarez",
			"Pedrito" }
	};

	public static void main(String[] args) {
		
//llamo al metodo el cual tiene el bucle para buscar los jugadores en los ficheros
		writePlayers();
	}

	public static void writePlayers() {
		
		//me creo los ficheros de escritura
		
		FileWriter fw = null;
		FileWriter fb = null;

		try {
			fw = new FileWriter("./resources/RealMadrid.csv");
			fw = new FileWriter("./resources/Barcelona.csv");
			
			//recorro doblemente el array pq es bidimensional
			
			for (String [] jugador : jugadores) {
				for (String alineacion :jugador){
					
				fw.write(alineacion);
				fw.write(";");}
			}
		} catch (IOException e) {
			System.err.println(ERROR_IO);

		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					System.err.println(ERROR_IO);
				}
			}
		}
	}
}