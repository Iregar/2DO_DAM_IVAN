package ut01.act07;

import java.util.Scanner;

public class Main implements InterfazFicheroBicicleta{
public static void main (String[] args) {
	
//Bicicleta bici = new Bicicleta (1,true,"01/01/2014",10);
	//System.out.println(bici.toString() );
	
	//BicicletaManager bici1 = new BicicletaManager();
	//bici1.dummy();
	//bici1.imprimir();
	Scanner sc= new Scanner(System.in);
	
	//me creo un objeto de la clase Bicleta
	Bicicleta bike= new Bicicleta();
	
	String opcion = null;
	do{
		System.out.println("Menu");
		System.out.println("1. Obtener bicicleta");
		
		//recojo la opcion por teclado
	opcion=sc.nextLine();
	
	switch (opcion)
	{
	case "1": System.out.println("introduce una biclicleta");
		bike.
	}
		
	}while (!opcion.equals ("4"));
	
	
	}

}