package bdd;

public class Data {

	private String user, ciudad, edad;

	public Data(String user, String ciudad, String edad) {
		this.user = user;
		this.ciudad = ciudad;
		this.edad = edad;
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
