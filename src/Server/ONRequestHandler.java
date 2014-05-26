package Server;


public class ONRequestHandler implements RequestHandler {

	public ONRequestHandler() {
	}
	
	public void handleRequest(String opt) {
		Server.serial.write("i");
	}

}
