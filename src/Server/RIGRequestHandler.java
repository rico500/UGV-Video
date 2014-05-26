package Server;

public class RIGRequestHandler implements RequestHandler {

	@Override
	public void handleRequest(String opt) {
		Server.serial.write("r,"+opt+"|");

	}

}
