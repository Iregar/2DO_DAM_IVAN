package ut01.act04;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Act_quitMayusculas {

	//para dividir cada 1024
	static final int TAM_BUFFER = 1024;
	
	

	/**
	 * Crear un nuevo fichero “QUIMAYUS.TXT” con el mismo texto completo, 
	 * pero con todas las letras en mayúsculas, quitando los posibles acentos
	 *  o diéresis que pueda haber.
	 */
	
	//metodo para reemplzara las letras
	private String replaceAllAccents(String line) {
		return line.replaceAll("Á", "A").replaceAll("É", "E")
				.replaceAll("Í", "I").replaceAll("Ó", "O").replaceAll("Ú", "U")
				.replaceAll("Ü", "U");

	}

	public void writeUppercaseFile( final String path, final String pathUppercase) {
		
		//para crear un hilo en JAVA
		Thread t = new Thread(new Runnable() {

			public void run() {

				BufferedReader streamIn = null;
				BufferedWriter streamOut = null;
				String line;
				try {
					streamIn = new BufferedReader(new FileReader(path));
					streamOut = new BufferedWriter(
							new FileWriter(pathUppercase));

					while ((line = streamIn.readLine()) != null) {
						//CON EL REPLACEll reemplazo caracteres
						line = replaceAllAccents(line.toUpperCase());
						streamOut.write(line);
						//para dar un enter (retorno de carro)
						streamOut.newLine();

					}
				} catch (FileNotFoundException e) {
					System.err.println("Error File not found");
				} catch (IOException e) {
					System.err.println("Error I/O");

				} finally {
					if (streamIn != null) {
						try {
							streamIn.close();
						} catch (IOException e) {
							System.err.println("Error I/O");
						}
					}
					if (streamOut != null) {
						try {
							streamOut.close();
						} catch (IOException e) {
							System.err.println("Error I/O");
						}
					}
				}

			}
		});
		//cierro Hilo
		t.start();
	}

}

