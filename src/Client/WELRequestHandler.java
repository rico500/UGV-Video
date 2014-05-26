package Client;

public class WELRequestHandler implements ClientRequestHandler {

	public WELRequestHandler(){};
	
	@Override
	public void handleRequest(String s) {
		GUI.connectionMessage.setVisible(true);
		GUI.connectionMessage.setText("<html>"+s+"</p><html>");
		System.out.println(s);
	}

}
