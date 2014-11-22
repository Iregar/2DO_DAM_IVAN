package ut01.randomclase;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Bicicleta implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private int id;
	private boolean activa;
	private Date fechaRevision;
	private int idTotem; // parking donde está anclada
	
	private SimpleDateFormat dateFormat; 
	private static final String FORMATO_FECHA ="dd/MM/yyyy";
	
	/**
	 * Constructor por defecto
	 */	
	Bicicleta(){
		dateFormat = new SimpleDateFormat(FORMATO_FECHA);
		id = 0;
		activa  =false;
		setFechaRevision("01/01/1900");
		idTotem = 0; 
	}
	

	
	/**
	 * @param id
	 * @param activa
	 * @param fechaRevision
	 * @param idTotem
	 */
	public Bicicleta(int id, boolean activa, String fechaRevision, int idTotem) {
		dateFormat = new SimpleDateFormat(FORMATO_FECHA);
		this.id = id;
		this.activa = activa;
		setFechaRevision(fechaRevision);
		this.idTotem = idTotem;
	}



	public int getId() {
		return id;
	}
	public boolean isActiva() {
		return activa;
	}
	public String getFechaRevision() {
		// trasnformamos la fecha en un String
		String fecha = dateFormat.format(fechaRevision);
		return fecha;
	}
	public int getIdTotem() {
		return idTotem;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	public void setFechaRevision(String fechaRevision) {
		
		try {
			// transformamos una fecha en formato dd/MM/YYYY en tipo Date
			this.fechaRevision = dateFormat.parse(fechaRevision);
		} catch (ParseException e) {
			// si el formato está mal ponemos una fecha por defecto
			GregorianCalendar calendario = new GregorianCalendar(1900,01,01);
				this.fechaRevision = calendario.getTime();
			
			
		}
	}
	public void setIdTotem(int idTotem) {
		this.idTotem = idTotem;
	}



	@Override
	public String toString() {
		return "Bicicleta [id=" + id + ", activa=" + activa
				+ ", fechaRevision=" + dateFormat.format(fechaRevision) + ", idTotem=" + idTotem
				+ "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (activa ? 1231 : 1237);
		result = prime * result
				+ ((fechaRevision == null) ? 0 : fechaRevision.hashCode());
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
		if (activa != other.activa)
			return false;
		if (fechaRevision == null) {
			if (other.fechaRevision != null)
				return false;
		} else if (!fechaRevision.equals(other.fechaRevision))
			return false;
		if (id != other.id)
			return false;
		if (idTotem != other.idTotem)
			return false;
		return true;
	}
	
	
	
	
	

}
