package ut01.act07;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bicicleta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private boolean activa;
	private Date fechaRevision;
	private int idTotem;
	
	//Este string te convierte un string en date
	private SimpleDateFormat dateFormat;
	
	//me cro como quiero que salga el formato fecha
	private static final String FORMATO_FECHA ="dd/MM/YYY";	
	
	/*
	 * Constructor por defecto
	 * 
	 */
	public Bicicleta() {
		dateFormat = new SimpleDateFormat(FORMATO_FECHA);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//cuando es boolinao en vez de getes IS
	public boolean isactiva() {
		return activa;
	}
	public void setactiva(boolean activa) {
		this.activa = activa;
	}
	public String getfechaRevision() {
		return dateFormat.format( fechaRevision);
	}
	public void setFechaRevision(String fechaRevision) {
		
		try{
		//transformamos una fecha en formato dd/MM/YYYY en tipo DATE
		
		this.fechaRevision = dateFormat.parse(fechaRevision);
		}catch (ParseException e){
			
			//Si el formato esta mal ponemos una fecha por defecto
		}
		try{
			this.fechaRevision = dateFormat.parse("01/01/1900");		
		
	} catch(ParseException e1){
		this.fechaRevision = new Date();
	}
	
	}
	public int getIdTotem() {
		return idTotem;
	}
	public void setIdTotem(int idTotem) {
		this.idTotem = idTotem;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fechaRevision == null) ? 0 : fechaRevision.hashCode());
		result = prime * result + (activa ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + idTotem;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bicicleta other = (Bicicleta) obj;
		if (fechaRevision == null) {
			if (other.fechaRevision != null)
				return false;
		} else if (!fechaRevision.equals(other.fechaRevision))
			return false;
		if (activa != other.activa)
			return false;
		if (id != other.id)
			return false;
		if (idTotem != other.idTotem)
			return false;
		return true;
	}
	@Override
	//para pasar los objetos a string automaticamente, pero todos los q esten en este metodo
	public String toString() {
		return "Bicicleta [id=" + id + ", activa=" + activa
				+ ", fechaRevision=" + dateFormat.format(fechaRevision) + ", idTotem=" + idTotem
				+ "]";
	}
	
	public Bicicleta(int id, boolean activa, String fechaRevision, int idTotem) {
		this();
		this.id = id;
		this.activa = activa;
		setFechaRevision(fechaRevision);
		this.activa = activa;
		this.idTotem = idTotem;
	}

	
}
