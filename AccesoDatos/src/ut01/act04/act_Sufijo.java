	package ut01.act04;
	import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class act_Sufijo {
	
	static final int TAM_BUFFER = 1024;
	/**
	* Method that countd all the words of a given text file end in suffix
	* @param pathTextFile
	* @return
	*/
	public int countWords(String pathTextFile, String suffix){
	BufferedReader readStream = null;
	String buffer;
	int numberWords = 0;
	try {
	readStream = new BufferedReader(new FileReader(pathTextFile),TAM_BUFFER);
	while((buffer=readStream.readLine())!=null){
	numberWords+= countWordsLine(buffer,suffix);	
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
	return numberWords;
	}
	private int countWordsLine(String buffer, String suffix) {
		// TODO Auto-generated method stub
		return 0;
	}

}
