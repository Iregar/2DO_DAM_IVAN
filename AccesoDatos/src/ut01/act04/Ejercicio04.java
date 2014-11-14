package ut01.act04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio04 {
	
	/**
	* Method that counts all the characters of a given text file
	* @param pathTextFile
	* @return
	*/
	
	public int countCharacter(String pathTextFile){
		
		FileReader readStream = null;
		int numberCharacters = 0;
		try {
			 readStream = new FileReader(pathTextFile);
			
			while(readStream.read()!=-1){
				++numberCharacters;
			}
			
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
		
		return numberCharacters;
	}
	

}
