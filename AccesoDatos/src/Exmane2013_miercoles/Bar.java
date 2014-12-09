package Exmane2013_miercoles;

import java.io.Serializable;

public class Bar implements Serializable{
	
	
	String name, address, tipo;
	int id;
	
	
	//Constructor vacio para JavaBeans (obligatorio)
	public Bar() {
		name = null;
		address = null;
		tipo = null;
	}
	
	public Bar(String name, String address, String tipo) {
		
		this.name = name;
		this.address = address;
		this.tipo = tipo;
	}
	
	//metodo para sobrecargar
	public Bar(String name, String address, String tipo, int id) {
		
		this.name = name;
		this.address = address;
		this.tipo = tipo;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Bar [name=" + name + ", address=" + address + ", tipo=" + tipo
				+ ", id=" + id + "]";
	}


}
