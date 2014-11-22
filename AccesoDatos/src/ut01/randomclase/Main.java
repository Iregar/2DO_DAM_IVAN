package ut01.randomclase;

public class Main {

	public static void main(String[] args) {
		//lamo a la clase Gestor Bicicleta
		GestorBicicleta gb = new GestorBicicleta();
		
		gb.dummy();
		
		gb.guardarBici(new Bicicleta(14, true, "10/11/2014", 23));
		gb.imprimir();

	}

}
