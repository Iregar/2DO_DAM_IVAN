package examen2013;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero {
	private final static String FICHERO = "./ficheros/ficheroEscrito.csv";
	
	public static void main(String[] args) {
		File output = null;
		FileWriter fw = null;
				
		try {
			fw = new FileWriter(new File(FICHERO));
			
			for (int a=0; a<10; a++){
			fw.write("holaAdios"+""+"cansado");
			fw.write("\n");
			
			}
			
			
		} catch (IOException e) {
		
		}finally{
			if (fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
				
				}
			}
		}
		
	}

}
