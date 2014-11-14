package ut01.act06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/*
 * Ejemplo de Java bean
 * Coger datos a fichero Binario
 */

public class Players {

	public static void printFilePlayers(String file) {
		DataInputStream fileIn = null;
		String player;
		int dorsal;
		try {
			
			// con la clase DataImputScream es para coger datos binarios
			fileIn = new DataInputStream(new FileInputStream(file));
			while (true) {
				player = fileIn.readUTF();
				dorsal = fileIn.readInt();
				System.out.println(player+":"+dorsal);
			}
		} catch (EOFException e) {

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} finally {
			if (fileIn != null) {
				try {
					fileIn.close();
				} catch (IOException e) {

				}
			}
		}

	}

	public static void writeFilePlayers(String file, String[] players,
			int[] dorsals) {

		DataOutputStream fileOut = null;

		try {
			fileOut = new DataOutputStream(new FileOutputStream(file));
			for (int i = 0; i < players.length; i++) {
				fileOut.writeUTF(players[i]);
				fileOut.writeInt(dorsals[i]);

			}

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} finally {
			if (fileOut != null)
				try {
					fileOut.close();
				} catch (IOException e) {

				}
		}

	}

}