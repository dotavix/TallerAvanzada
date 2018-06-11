package bdd;

import java.sql.*;
import java.util.logging.*;

public class Conector {

	private String url = "src/main/resources/test.db";
	Connection connect;

	public void connect() {
		try {
			connect = DriverManager.getConnection("jdbc:sqlite:" + url);
			if (connect != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException ex) {
			System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
		}
	}

	public void close() {
		try {
			connect.close();
		} catch (SQLException ex) {
			Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void saveData(Data data) {
		try {
			PreparedStatement st = connect.prepareStatement("insert into data (user, password ,ciudad, edad) values (?,?,?,?)");
			st.setString(1, data.getUser());
			st.setString(2, data.getPassword());
			st.setString(3, data.getCiudad());
			st.setString(4, data.getEdad());
			st.execute();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

	}

	public void mostrarData() {
		ResultSet result = null;
		try {
			PreparedStatement st = connect.prepareStatement("select * from data");
			result = st.executeQuery();
			while (result.next()) {
				System.out.print("User: ");
				System.out.println(result.getString("user"));

				System.out.print("Ciudad: ");
				System.out.println(result.getString("ciudad"));

				System.out.print("Edad: ");
				System.out.println(result.getString("edad"));

				System.out.println("=======================");
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public boolean mostrarUsuario(String user) {

		ResultSet result = null;
		try {
			PreparedStatement st = connect.prepareStatement("select * from data where user = '" + user + "'");
			result = st.executeQuery();
			while (result.next()) {
				return true;
			}

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return false;
	}
	
	
	public static void main(String[] args) throws Exception {
		Conector con = new Conector();
		con.connect();

		
		con.close();
	}
}
