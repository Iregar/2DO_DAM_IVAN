//Ejemplo de escritura en un fichero de texto.
import java.io.*; //Se importan las clases de io (para gestion de ficheros)
public class Escritura
{     
	public static void main(String[] args)
	{         
		FileWriter fichero = null;  
		PrintWriter escriba = null;
		try
		{             
			fichero = new FileWriter("C:\\temp\\prueba.txt");
			escriba = new PrintWriter(fichero);
			for (int i = 0; i < 10; i++)
				{
				 escriba.println("Linea " + i);
				}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{            
			try 
			{
				// Aprovechamos el finally para 
				// asegurarnos que se cierra el fichero. 
				if (null != fichero)
				{
					fichero.close();
				}
			} 
			catch (Exception e2)
			{
				e2.printStackTrace(); 
			} 
		 }
	}
} 
