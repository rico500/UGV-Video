package Server;

public class STORequestHandler implements RequestHandler {

	@Override
	public void handleRequest(String opt) {
		Server.serial.write("s|");

	}

}
