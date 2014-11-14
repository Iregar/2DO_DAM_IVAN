package ut01.act04;

public class Main {

	final static String PATH_TEXT_FILE = "./resources/QUIJOTE.txt";

	public static void main(String[] args) {
		
		//llamo al metodo contarlineas
		//	Act_contaLineas e5 =new Act_contaLineas();
		
		//llamo al metodo contarDiptongos
		//Act_contarDiptongos e8 = new Act_contarDiptongos();
		
		//llamo al metodo contarfrecuanciaVocales
				Act_frecuenciaVocales e9 = new Act_frecuenciaVocales();
		
		//llamo al metodo contarVocales
		Act_contarVocales e7 = new Act_contarVocales();
		
		//llamo al metodo contarMinusculas
		Act_contarMinusculas e6 =new Act_contarMinusculas();
		
		//llamo al metodo countcharacter
		//Ejercicio04 e4 = new Ejercicio04();
	   
		long startTime = System.currentTimeMillis();

		System.out.println("las minusculas  que hay en el quijote son"+ e6.contarMinusculas(PATH_TEXT_FILE));
		System.out.println("las vocales que hay en el quijote son" + e7.contarVocales(PATH_TEXT_FILE));
		//System.out.println("Los diptongos que hay en el quijote son" + e8.contarDiptongos(PATH_TEXT_FILE));
		System.out.println("La vocal a aparecece" + " "+  e9.frecuenciaVocales(PATH_TEXT_FILE)+" "+ "veces");
		
	    long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    	
		System.out.println(elapsedTime);
	}

}
