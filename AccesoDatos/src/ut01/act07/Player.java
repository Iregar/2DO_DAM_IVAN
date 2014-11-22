package ut01.act07;

import java.io.Serializable;

public class Player implements Serializable{

	private String name;
	private int dorsal;
	private String Equipo;
	
	/**
	 * Versión del JavaBEan
	 */
	private static final long serialVersionUID = 1L;
	
	// Constructor sin argumentos
	Player(){
		
	}

	public String getName() {
		return name;
	}

	public int getDorsal() {
		return dorsal;
	}

	public String getEquipo() {
		return Equipo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public void setEquipo(String equipo) {
		Equipo = equipo;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", dorsal=" + dorsal + ", Equipo="
				+ Equipo + "]";
	}
	
	@Override
	public boolean equals(Object o){
		// si es objeto apunta a la misma direccion de memoria
		// es el mismo
		if(o==this)
			return true;
		
		// si el objeto que me pasa es de la clase Player
		if(o instanceof Player){
			Player player = (Player) o;
			// si tienen el mismo nombre, son iguales
			if (player.getName().equals(this.name))
					return true;
		}
		
		return false;
		
	}
	
	
	

}
