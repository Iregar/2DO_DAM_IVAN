package ut01.act06;


public class Main {

	final static String FILE = "./resources/fibonaci.bin";
	
	public static void main(String[] args) {
		System.out.println(Fibonacci.getFibonacci(2));
		Fibonacci.writeFileFibonacci(FILE, 10);
		System.out.println(Fibonacci.readFileFibonacci(FILE));


		//final  static String FILE = "./resources/RealMadrid.csv";

	/*	static String[] RealMadridPlayers = { "Casillas", "Pepe", "Benzema",
				"Sergio Ramos", "Cristiano",
				"Bale", "Isco", "Modric", "Carvajal", "James" };
		static int[] RealMadridDorsales = { 1, 3, 9, 4, 7,
		11, 23, 10, 25, 14 };
		public static void main(String[] args) {
			Players.writeFilePlayers(FILE, RealMadridPlayers, RealMadridDorsales);
			Players.printFilePlayers(FILE);
		}*/
	}
}

