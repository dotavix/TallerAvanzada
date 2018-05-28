package bdd;

import javax.persistence.*;

@Entity
@Table (name = "data")
public class Data {
	
	@Id
	@Column(name = "user")
	private String user;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "edad")
	private String edad;

	public Data(String user, String ciudad, String edad) {
		this.user = user;
		this.ciudad = ciudad;
		this.edad = edad;
	}

	public Data() {
		// TODO Auto-generated constructor stub
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	public void save(){
        Conector con = new Conector();
        con.connect();
        con.saveData(this);
        con.close();
    }
	
	public static void main(String[] args) {
		Data data = new Data("raul","san isidro","45");
		data.save();
	}
	
}
