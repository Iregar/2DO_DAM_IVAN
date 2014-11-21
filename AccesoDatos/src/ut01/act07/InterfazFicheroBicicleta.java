package ut01.act07;

public interface InterfazFicheroBicicleta {

	/*
	 * Obtener una bicicleta
	 * @param: bici
	 * @return: Devuelve verdadero si lo ha eliminado 
	 * 
	 */
	
	public Bicicleta ObtenerBici(int id);
	
	
	/*
	 * modifica una bicicleta
	 * @param: bici
	 * @return: Devuelve verdadero si lo ha eliminado 
	 * 
	 */
	
	
	public boolean guardaBici(Bicicleta bici);
	
	
	/*
	 * modifica una bicicleta
	 * @param: bici
	 * @return: Devuelve verdadero si lo ha eliminado 
	 * 
	 */
	public boolean modificarBici(Bicicleta bici);
	
	 
	 
	/*
	 * Elimina una bicicleta
	 * @param: bici
	 * @return: Devuelve verdadero si lo ha eliminado 
	 * 
	 */
	 
	 public boolean eliminarBici(Bicicleta bici);
		
}
