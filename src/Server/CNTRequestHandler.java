package Server;

public class CNTRequestHandler implements RequestHandler {

	@Override
	public void handleRequest(String opt) {
		Server.serial.write("c|");
	}

}
