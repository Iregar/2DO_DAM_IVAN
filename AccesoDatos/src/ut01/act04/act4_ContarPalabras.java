package ut01.act04;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class act4_ContarPalabras {

		static final int TAM_BUFFER = 1024;
		
		/**
		 * Method that count all the words of a given text file
		 * @param pathTextFile
		 * @return
		 */
		public int countWords(String pathTextFile){
			BufferedReader readStream = null;
			String buffer;
			int numberWords = 0;
			
			boolean readingWord = false;
			char letter;
			try {
				 readStream = new BufferedReader(new FileReader(pathTextFile),TAM_BUFFER);
				
				while((buffer=readStream.readLine())!=null){
					
					for(int i=0; i< buffer.length();i++){
						
						//con el charAT podemos coger caracter a caracter
						letter = buffer.charAt(i);
						
						//el metodo isletter para diferenciar si es un caractyer de la A a la Z
						//metodo que comprueba q el caracter pasado como parametro es una letra
						if(!readingWord && Character.isLetter(letter)){
							readingWord = true;
						}
						else if (readingWord && Character.isLetter(letter)){
							// do nothing
						}
						else if (readingWord && !Character.isLetter(letter)){
							readingWord = false;
							++numberWords;		
							
						}
					}
					
					
				}
				//quitamos, y  el último caracter.
			
				
			} catch (FileNotFoundException e) {

			} catch (IOException e) {
			
			}
			finally{
				if (readStream!=null)
					try {
						readStream.close();
					} catch (IOException e) {
					}
			}
			
			return numberWords;
			
			
		}
	
	
}
