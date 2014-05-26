package Server;


public class OFFRequestHandler implements RequestHandler {

	public OFFRequestHandler(){
	}
		
	public void handleRequest(String opt) {
		Server.serial.write("o");
	}

}
