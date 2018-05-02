package bot;

public class EcoResponse {
	
	public String devolverSaludo(String user, String asist) {
		return "Buen dia "+user+", mi nombre es "+asist+", en que puedo ayudarte?";
	}
	
	public String devolverAgradecimiento(String user) {
		return "De nada "+ user +"!";
	}
	
	public String devolverDespedida(String user) {
		return "Goodbye "+ user +", may the force be with you.";
	}

}
