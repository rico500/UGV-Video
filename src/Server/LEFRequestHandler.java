package Server;

public class LEFRequestHandler implements RequestHandler {

	@Override
	public void handleRequest(String opt) {
		Server.serial.write("l,"+opt+"|");

	}

}
