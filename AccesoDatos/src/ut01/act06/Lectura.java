package ut01.act06;

//Ejemplo de lectura de un fichero de texto.
import java.io.*; //Se importan las clases de io (para gestion de ficheros)

public class Lectura 
{
	public static void main(String [] arg)
	{
		File archivo = null;
		FileReader lector = null;
		BufferedReader leyendo = null;
		try 
		{          
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File ("C:\\Temp\\archivo.txt");
			lector = new FileReader (archivo);
			leyendo = new BufferedReader(lector);
			// Lectura del fichero
			String linea;
			while((linea=leyendo.readLine())!=null)
				System.out.println(linea);
		}
		catch(Exception e) //Capturamos una excepcion si se produce al abrir el archivo
		{          
			e.printStackTrace();
		}
		finally
		{          
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try
			{                                 
				if( null != lector )
				{                   
					lector.close();
				}
			}
			catch (Exception e2)
			{              
				e2.printStackTrace();
			}
		}
	}
} 
