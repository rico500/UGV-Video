package Server;

public class BAKRequestHandler implements RequestHandler {

	@Override
	public void handleRequest(String opt) {
		Server.serial.write("b,"+opt+"|");
	}

}
