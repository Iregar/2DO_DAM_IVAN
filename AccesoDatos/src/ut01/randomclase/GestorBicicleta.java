package ut01.randomclase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GestorBicicleta implements InterfazFicheroBicicleta {

	final static String FICHERO = "./resources/bicicleta.dat";
	final static int TAM_FECHA = 10;
	final static int TAM_REGISTRO = 4 + 1 + TAM_FECHA*2 + 4; //29
	/**
	 * Generar un archivo de prueba de un ficher ode acceso aleatorio
	 */
	public void dummy() {
		RandomAccessFile streamOut = null;
		// genero bicis aleatoriamente
		ArrayList<Bicicleta> bicis = new ArrayList<Bicicleta>();
		Bicicleta bici;
		for (int i = 1; i < 10; i++) {
			bici = new Bicicleta(i, true, "22/11/2014", (i % 100));
			bicis.add(bici);
		}

		try {
			// hemos abierto el flujo
			streamOut = new RandomAccessFile(FICHERO, "rw");
			for(Bicicleta b:bicis){
				streamOut.writeInt(b.getId());
				streamOut.writeBoolean(b.isActiva());
				// escribimos fecha
				StringBuilder sb = new StringBuilder(b.getFechaRevision());
				sb.setLength(TAM_FECHA);
				streamOut.writeChars(sb.toString());
				
				streamOut.writeInt(b.getIdTotem());
							
				
			}

		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			
		} finally {
			if (streamOut != null)
				try {
					streamOut.close();
				} catch (IOException e) {

				}
		}

	}
	
	public void imprimir(){
		//empezamos a leer
		RandomAccessFile streamIn = null;
		ArrayList<Bicicleta> bicis = new ArrayList<Bicicleta>();
		Bicicleta bici;
		int id, id_totem;
		boolean activa;
		String fecha;
		char[] aFecha = new char[TAM_FECHA] ;
		char caracter;
		try {
			streamIn = new RandomAccessFile(FICHERO,"r");
			do{
			id = streamIn.readInt();
			activa = streamIn.readBoolean();
			
			for(int i=0; i< TAM_FECHA; i++){
				caracter = streamIn.readChar();
				// si no es un caracter de rellno
				if(caracter!=0){
					aFecha[i] = caracter;
				}
				else {
					aFecha[i] = ' ';
				}
			} // fin for
			
			fecha = new String(aFecha);
			
			id_totem = streamIn.readInt();
			
			bici = new Bicicleta(id, activa, fecha,id_totem);
			bicis.add(bici);
			
			}
			// leo el fichero mientras el puntero sea menor que el tam
			// del fichero
			while(streamIn.getFilePointer()<streamIn.length());
			
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} finally {
			if (streamIn != null)
				try {
					streamIn.close();
				} catch (IOException e) {

				}
		}
			
		for(Bicicleta b:bicis)
			System.out.println(b);
	}

	
	//me creo un metodo para no estar todo el rato declarando la variables para añadir
	
	private void escribirRegistro(Bicicleta bici, RandomAccessFile escribirFichero) throws IOException{
	
		
			escribirFichero.writeInt(bici.getId());
			escribirFichero.writeBoolean(bici.isActiva());
			StringBuilder sb = new StringBuilder(bici.getFechaRevision());
			sb.setLength(TAM_REGISTRO);
			escribirFichero.writeChars(sb.toString());
			escribirFichero.write(bici.getIdTotem());
		
		
	}
	
	@Override
	public boolean guardarBici(Bicicleta bici){
		
		
	
		//me creo el fichero y lo creo de la clase RandomAccessFile
		//que lo que hace es coger cualquier datos del fichero
		RandomAccessFile escribirFichero = null;
	
		try {
	//empiezo a leer para luego guardarlo en otro 
			
			escribirFichero = new RandomAccessFile(FICHERO, "rw");
			
			
	//Cojo la posicion del registro para ver si esta llena
			int position = (bici.getId()-1)*TAM_REGISTRO;
		
	//me posiciono si existe un registro
					escribirFichero.seek(position);
			
					escribirRegistro(bici, escribirFichero);
					
				
			//escribo el id 
			
		
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (escribirFichero != null)
			try {
				escribirFichero.close();
			}catch (Exception e2) {
				// TODO: handle exception
			}
				
		}
		
		return false;
	}

	@Override
	public Bicicleta obtenerBici(Bicicleta bici) {
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
