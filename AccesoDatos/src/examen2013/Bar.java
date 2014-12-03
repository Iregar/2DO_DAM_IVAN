package examen2013;

public class Bar {

	private String name ;
	private String address;
	private String tipo  ;
	
	Bar(){
		 name ="null";
		 address = "null";
		 tipo = "null";
		
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
	public Bar(String name, String address, String tipo) {
		super();
		this.name = name;
		this.address = address;
		this.tipo = tipo;
	}
	
	
}
