package ut01.act04;

public class act_sufijo_linea {
	
	
	/**
	* count number of words of a line ending in suffix
	* @param line
	* @return
	*/
	public int countWordsLine(String line, String suffix){
	char letter;
	boolean readingWord = false;
	int numberWords = 0;
	StringBuffer word = new StringBuffer();
	for(int i=0; i< line.length();i++){
	letter = line.charAt(i);
	if(!readingWord && Character.isLetter(letter)){
	readingWord = true;
	word.append(letter);
	}
	else if (readingWord && Character.isLetter(letter)){
	word.append(letter);
	}
	else if (readingWord && !Character.isLetter(letter)){
	readingWord = false;
	if(word.toString().endsWith(suffix))
	++numberWords;	
	}
	}
	return numberWords;
	}

}
