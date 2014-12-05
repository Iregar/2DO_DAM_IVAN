package examen2013;

import java.io.Serializable;

public class Bar implements Serializable{

	

	private String name, address, type;

	public Bar (){
		
		String name= null;
		String address= null;
		String type= null;
		
	}
	public Bar(String name, String address, String type) {
		super();
		this.name = name;
		this.address = address;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Bar [name=" + name + ", address=" + address + ", type=" + type
				+ "]";
	}
	
}
