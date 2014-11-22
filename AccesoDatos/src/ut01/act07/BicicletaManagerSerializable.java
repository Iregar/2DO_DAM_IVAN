package ut01.act07;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BicicletaManagerSerializable implements InterfazFicheroBicicleta {

	final static String FICHERO = "./resources/bicicleta.dat";

	public void dummy(int num) {

		ArrayList<Bicicleta> bicis = new ArrayList<Bicicleta>();
		for (int i = 1; i < num; i++) {
			bicis.add(new Bicicleta(i, true, "01/01/2014", (i % 10) + 1));

		}
		ObjectOutputStream streamOut = null;

		try {
			// abrimos el flujo de salida para escribir un fichero
			// de objetos serializables
			streamOut = new ObjectOutputStream(new FileOutputStream(FICHERO));

			for (Bicicleta bici : bicis) {
				streamOut.writeObject(bici);
			}

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error E/S " + e.getMessage());
		} finally {
			if (streamOut != null)
				try {
					streamOut.close();
				} catch (IOException e) {
					System.err.println("Error E/S " + e.getMessage());
				}
		}
	}

	public void imprimir() {

		ObjectInputStream streamIn = null;

		try {
			// abrimos el flujo de salida para escribir un fichero
			// de objetos serializables
			streamIn = new ObjectInputStream(new FileInputStream(FICHERO));
			try {
				while (true) {
					Bicicleta bici = (Bicicleta) streamIn.readObject();
					System.out.println(bici.toString());
				}
			} catch (EOFException e) {
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error E/S " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("Clase no encontrada" + e.getMessage());
		} finally {
			if (streamIn != null)
				try {
					streamIn.close();
				} catch (IOException e) {
					System.err.println("Error E/S " + e.getMessage());
				}
		}
	}

	@Override
	public boolean guardarBici(Bicicleta bici) {

		ObjectOutputStream streamOut = null;
		ObjectInputStream streamIn = null;
		File ficheroTemp = new File("./resources/temp");
		File fichero = new File(FICHERO);
		boolean guardado = false, noExiste = true;
		

		try {

			streamOut = new ObjectOutputStream(
					new FileOutputStream(ficheroTemp));
			streamIn = new ObjectInputStream(new FileInputStream(fichero));

			// copiar el contenido del fichero original en el fichero temporal
			try {
				while (true) {
					Bicicleta b = (Bicicleta) streamIn.readObject();
					if(bici.getId()==b.getId()){
						noExiste = false;
					}
					streamOut.writeObject(b);
				}
			} catch (EOFException e) {

			}
			streamOut.writeObject(bici);
			if (noExiste) guardado = true;

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("Error clase no encontrada " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error E/S " + e.getMessage());
		} finally {
			if (streamOut != null)
				try {
					streamOut.close();
				} catch (IOException e) {
					System.err.println("Error E/S " + e.getMessage());
					guardado = false;
				}
			if (streamIn != null)
				try {
					streamIn.close();
				} catch (IOException e) {
					System.err.println("Error E/S " + e.getMessage());
					guardado = false;
				}
		}

		if (guardado) {
			// borramos el fichero original
			fichero.delete();
			// renombramos el fichero temporal como el original
			ficheroTemp.renameTo(fichero);

		} else {
			ficheroTemp.delete();
		}

		return guardado;
	}

	@Override
	public Bicicleta obtenerBici(Bicicleta bici) {

		ObjectInputStream streamIn = null;
		Bicicleta biciDevuelta = new Bicicleta(0, false, "01/01/1900", 0);

		try {
			streamIn = new ObjectInputStream(new FileInputStream(FICHERO));

			try {
				while (true) {
					Bicicleta biciLeida = (Bicicleta) streamIn.readObject();
					if (biciLeida.getId() == bici.getId()) {
						biciDevuelta = biciLeida;
						break;
					}

				}
			} catch (EOFException e) {

			}
		} catch (ClassNotFoundException e) {
			System.err.println("Clase no encontrado " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error E/S " + e.getMessage());
		} finally {
			if (streamIn != null)
				try {
					streamIn.close();
				} catch (IOException e) {
					System.err.println("Error E/S " + e.getMessage());
				}
		}

		return biciDevuelta;
	}

	@Override
	public boolean modificarBici(Bicicleta bici) {
		ObjectOutputStream streamOut = null;
		ObjectInputStream streamIn = null;
		File ficheroTemp = new File("./resources/temp");
		File fichero = new File(FICHERO);
		boolean modificado = false;

		try {

			streamOut = new ObjectOutputStream(
					new FileOutputStream(ficheroTemp));
			streamIn = new ObjectInputStream(new FileInputStream(fichero));

			// copiar el contenido del fichero original en el fichero temporal
			try {
				while (true) {
					Bicicleta b = (Bicicleta) streamIn.readObject();
					if(b.getId()==bici.getId()){
						modificado = true;
						streamOut.writeObject(bici);
					}
					else
						streamOut.writeObject(b);
				}
			} catch (EOFException e) {

			}

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("Error clase no encontrada " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error E/S " + e.getMessage());
		} finally {
			if (streamOut != null)
				try {
					streamOut.close();
				} catch (IOException e) {
					System.err.println("Error E/S " + e.getMessage());
					modificado = false;
				}
			if (streamIn != null)
				try {
					streamIn.close();
				} catch (IOException e) {
					System.err.println("Error E/S " + e.getMessage());
					modificado = false;
				}
		}

		if (modificado) {
			// borramos el fichero original
			fichero.delete();
			// renombramos el fichero temporal como el original
			ficheroTemp.renameTo(fichero);

		} else {
			ficheroTemp.delete();
		}

		return modificado;
	}

	@Override
	public boolean eliminarBici(Bicicleta bici) {
		ObjectOutputStream streamOut = null;
		ObjectInputStream streamIn = null;
		File ficheroTemp = new File("./resources/temp");
		File fichero = new File(FICHERO);
		boolean eliminado = false;

		try {

			streamOut = new ObjectOutputStream(
					new FileOutputStream(ficheroTemp));
			streamIn = new ObjectInputStream(new FileInputStream(fichero));

			// copiar el contenido del fichero original en el fichero temporal
			try {
				while (true) {
					Bicicleta b = (Bicicleta) streamIn.readObject();
					if(b.getId()==bici.getId()){
						eliminado = true;
					}
					else
						streamOut.writeObject(b);
				}
			} catch (EOFException e) {

			}

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("Error clase no encontrada " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error E/S " + e.getMessage());
		} finally {
			if (streamOut != null)
				try {
					streamOut.close();
				} catch (IOException e) {
					System.err.println("Error E/S " + e.getMessage());
					eliminado = false;
				}
			if (streamIn != null)
				try {
					streamIn.close();
				} catch (IOException e) {
					System.err.println("Error E/S " + e.getMessage());
					eliminado = false;
				}
		}

		if (eliminado) {
			// borramos el fichero original
			fichero.delete();
			// renombramos el fichero temporal como el original
			ficheroTemp.renameTo(fichero);

		} else {
			ficheroTemp.delete();
		}

		return eliminado;
	}

}
