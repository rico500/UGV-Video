package Server;

public class FORRequestHandler implements RequestHandler {

	@Override
	public void handleRequest(String opt) {
		Server.serial.write("f,"+ opt+"|");

	}

}
