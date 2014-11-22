package ut01.act07;

public interface InterfazFicheroBicicleta {
	
	/**
	 * Almacena un objeto bicicleta 
	 * @param bici
	 * @return devuelve verdadero si se ha guardado con éxito
	 */
	public boolean guardarBici(Bicicleta bici);
	
	/**
	 * Busca una bicicleta
	 * @param bici Objeto con un id de la bicicleta
	 * @return Devuelve un objeto Bicicleta, si no la encuentra
	 * devolverá un objeto Bicicleta vacio
	 */
	public Bicicleta obtenerBici(Bicicleta bici);
	
	/**
	 * Modifica una bicicleta
	 * @param bici Busca por id la bicicleta
	 * @return Devuelve verdadero si ha modificado con éxito
	 */
	public boolean modificarBici(Bicicleta bici);
	
	/**
	 * Elimina una bicicleta 
	 * @param bici
	 * @return Devueve verdadero si lo ha eliminado con éxito
	 */
	public boolean eliminarBici(Bicicleta bici);
	
	


}
