package bdd;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name = "data")
public class Data implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Data [user=" + user + ", ciudad=" + ciudad + ", edad=" + edad + ", chuck=" + chuck + "]";
	}

	@Id
	@Column(name = "user")
	private String user;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "edad")
	private String edad;
	
	@Column(name = "chuck")
	private Integer chuck;

	public Integer getChuck() {
		return chuck;
	}

	public void setChuck(Integer chuck) {
		this.chuck = chuck;
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
	
//	public void save(){
//        Conector con = new Conector();
//        con.connect();
//        con.saveData(this);
//        con.close();
//    }
//	
	public static void main(String[] args) {
//		Data data = new Data("raul","san isidro","45");
//		data.save();
		
//		Data d = new Data("test1","merle","23");
//		HibernateApp.saveData(d);
//		
//		System.out.println(HibernateApp.obtainData("test1").toString());
	}
	
}
