package examen2013;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		GestorBar gb = new GestorBar();

		ArrayList<Bar> bares = new ArrayList<Bar>();

		bares.add(new Bar("El rebote", "gran v�a 3", "Tapas"));
		bares.add(new Bar("La competencia", "ave mar�a 23", "Restaurante"));
		bares.add(new Bar("Casa Blas", "Plaza Espa�a 3", "Tapas"));
		bares.add(new Bar("Dominos pizza", "Fuencarral 34", "Comida r�pida"));
		bares.add(new Bar("Burguer Queen", "Montera 12", "Comida r�pida"));

		gb.escribirCSVbar(bares);
		
		bares = gb.cargarCSVbar();
		
		//for(Bar bar: bares)
			//System.out.println(bar);
		
		
	}
}
