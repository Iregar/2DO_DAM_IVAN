package ut01.act07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BicicletaManager implements InterfazFicheroBicicleta {

	final static String FICHERO = "./resources/bicicleta.dat";

	public void dummy() {
		// me creo un array de la clase Bicicleta y la llamo bicis
		//uso una clave generica
		
		ArrayList<Bicicleta> bicis = new ArrayList<Bicicleta>();

		// añado bicis a esa array
		bicis.add(new Bicicleta(1, true, "01/01/2014", 10));
		bicis.add(new Bicicleta(2, true, "01/01/2014", 10));
		bicis.add(new Bicicleta(1, true, "01/01/2014", 10));
		bicis.add(new Bicicleta(1, true, "01/01/2014", 10));
		bicis.add(new Bicicleta(1, true, "01/01/2014", 10));
		
		//Preparo el flujo de escritura
		ObjectOutputStream streamOut = null;
		try {

			//Escribo el fichero bicleta.dat
			// con un true no os machaca el fichero
			
			//FileOutputStream = abrir el flujo de escritura 
			//ObjectOutputStream= escribo (solo objetos)
			
			streamOut = new ObjectOutputStream(new FileOutputStream(FICHERO));

			// Me recorro  el a la qie llame bicis con un for each
			
			for (Bicicleta bicicleta : bicis) {

				System.out.println(bicicleta);

			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encotrado " + e.getMessage());

		} catch (IOException e) {

			System.err.println("Error E/S" + e.getMessage());

		} finally {

			if (streamOut != null)

				try {

					streamOut.close();

				} catch (IOException e) {

					System.err.println("Error E/S" + e.getMessage());
				}
		}
	}

	public void imprimir() {
		ObjectInputStream streamIn = null;

		try {

			streamIn = new ObjectInputStream(new FileInputStream(FICHERO));

			try {

				Bicicleta bici = (Bicicleta) streamIn.readObject();

				System.out.println(bici.toString());

			} catch (ClassNotFoundException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encotrado " + e.getMessage());

		} catch (IOException e) {

			System.err.println("Error E/S" + e.getMessage());

		} finally {

			if (streamIn != null)

				try {

					streamIn.close();

				} catch (IOException e) {

					System.err.println("Error E/S" + e.getMessage());
				}
		}
	}

	@Override
	public boolean guardaBici(Bicicleta bici) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Bicicleta ObtenerBici(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificarBici(Bicicleta bici) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarBici(Bicicleta bici) {
		// TODO Auto-generated method stub
		return false;
	}

}
