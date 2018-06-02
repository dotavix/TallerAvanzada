package bdd;

import java.io.IOException;
import java.io.Serializable;

import javax.persistence.*;

import com.didisoft.pgp.PGPException;

import bot.PGP;

@Entity
@Table (name = "data")
public class Data implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "user")
	private String user;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "edad")
	private String edad;
	
	@Column(name = "chuck")
	private Integer chuck = 0;
	
	@Column(name = "passwordRSA")
	private String passwordRSA = "1234";

	public Data() {
	}

	public Data(String user) throws PGPException, IOException {
		this.user = user;
		PGP.GenerateKeyPairRSA(this.user,this.passwordRSA);
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
	
	public Integer getChuck() {
		return chuck;
	}

	public void setChuck(Integer chuck) {
		this.chuck = chuck;
	}
	
	public String getPasswordRSA() {
		return passwordRSA;
	}

	public void setPassword(String password) throws Exception {
		this.passwordRSA = password;
		PGP.GenerateKeyPairRSA(this.user,this.passwordRSA);
	}

	public void save(){
        HibernateApp ha = new HibernateApp();
        ha.connect();
        ha.saveData(this);
        ha.close();
    }
	
	public void obtain() throws Exception{
        HibernateApp ha = new HibernateApp();
        ha.connect();
        Data d = ha.obtainData(this.user);
        this.ciudad = d.ciudad;
        this.edad = d.edad;
        this.chuck = d.chuck;
        this.passwordRSA = d.passwordRSA;
        ha.close();
    }

	@Override
	public String toString() {
		return "Data [user=" + user + ", ciudad=" + ciudad + ", edad=" + edad + ", chuck=" + chuck + ", passwordRSA="
				+ passwordRSA + "]";
	}
	
}
