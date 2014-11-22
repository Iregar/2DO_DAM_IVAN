package ut01.act07;

public class Main {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		int numBicis = 50000; 
		Bicicleta bici;
		// bicis de prueba
		BicicletaManagerSerializable bm = new BicicletaManagerSerializable();
		bm.dummy(numBicis);
		// bm.imprimir();

		// prueba buscar
		int id = numBicis-1;
		bici = new Bicicleta(id, false, "01/01/1900", 0);
		bici = bm.obtenerBici(bici);
		if (bici.getId() != 0)
			System.out.println("Encontrada bici: "+bici.toString());
		else
			System.out.println("la bici con id " + id + " no existe");

		// prueba modificar
		bici = new Bicicleta(numBicis-1, false, "01/1/2013", 33);

		if (bm.modificarBici(bici))
			System.out.println("Modificada bici "+bici.getId()+" : "+bici.toString()  );
		else
			System.out.println("No se ha podido modificar");

		//bm.imprimir();

		// nueva bici
		bici = new Bicicleta(numBicis, true, "01/01/2014", 80);

		if (bm.guardarBici(bici)) {
			System.out.println("Añadida correctamente "+bici.getId() );
		} else {
			System.out.println("No se ha podido añadir " + bici.getId());
		}

		//bm.imprimir();

		// eliminar bici
		id = numBicis-2;
		bici = new Bicicleta(id, false, "01/01/1900", 0);

				if (bm.eliminarBici(bici)) {
					System.out.println(bici.getId() + " borrada correctamente");
				} else {
					System.out.println("no se ha podido borrar " + bici.getId());
				}

		//bm.imprimir();
		// tiempo en ejecutarse
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Tiempo tardado en ejecutarse " + elapsedTime
				+ " ms");

		// Memoria utilizada
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		long memory = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Memoria utilizada : " + memory / 1024 + " KB");
		
		//Tiempo tardado en ejecutarse 36284 ms
		//Memoria utilizada : 728 KB

	}
}
