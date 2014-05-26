package Client;

public class BUTRequestHandler implements ClientRequestHandler{

	public BUTRequestHandler(){}
	
	@Override
	public void handleRequest(String s) {
		System.out.println("Button pressed!");
		
	}
	
}
