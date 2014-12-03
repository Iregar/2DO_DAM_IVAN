package examen2013;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		//me creo un objeto de GestorBares
		GestorBares gb = new GestorBares();
		
		//me creo el array donde guardo los bares
		ArrayList<Bar> bares = new ArrayList<Bar>();
		
		//introduzco los datos en el array
		
		bares.add(new Bar("El rebote", "gran vía 3", "Tapas"));
		bares.add(new Bar("La competencia", "ave maría 23", "Restaurante"));
		bares.add(new Bar("Casa Blas", "Plaza España 3", "Tapas"));
		bares.add(new Bar("Dominos pizza", "Fuencarral 34", "Comida rápida"));
		bares.add(new Bar("Burguer Queen", "Montera 12", "Comida rápida"));
		bares.add(new Bar("Meson Galicia", "Ibiza 15", "Comida casera"));

		//lamo al metodo escribir
		
		gb.escribirCSVbar(bares);
		
		//bares = gb.car
		
		
		//LLamar al metodo leer
		
		System.out.println(gb.cargarCSVbar().toString());
	}

}
