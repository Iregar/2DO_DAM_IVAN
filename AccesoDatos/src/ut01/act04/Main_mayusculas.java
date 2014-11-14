package ut01.act04;

public class Main_mayusculas {



	final static String PATH_TEXT_FILE = "./resources/QUIJOTE.txt";
	final static String PATH_TEXT_FILE_UPPERCASE = "./resources/QUIJOTEUPPERCASE.txt";

	public static void main(String[] args) {
		
		Act_quitMayusculas e5 = new Act_quitMayusculas();
		
		long startTime = System.currentTimeMillis();

		e5.writeUppercaseFile(PATH_TEXT_FILE, PATH_TEXT_FILE_UPPERCASE);
		
	    long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    	
		System.out.println(elapsedTime);
		// 2039000 characteres 216 miliseconds
		// 2039000 characteres 102 miliseconds
		// 777414 word 126 miliseconds
		// 106 words ending with cion in 340 miliseconds
	}

}