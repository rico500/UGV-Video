package Client;

import java.util.StringTokenizer;

public class SESRequestHandler implements ClientRequestHandler {

	@Override
	public void handleRequest(String s) {
		StringTokenizer st = new StringTokenizer(s, ",");
		
		Client.sensor1 = Integer.parseInt(st.nextToken());
		Client.sensor2 = Integer.parseInt(st.nextToken());
		Client.sensor3 = Integer.parseInt(st.nextToken());
		
		GUI.sensor1.setText(Integer.toString(Client.sensor1));
		GUI.sensor2.setText(Integer.toString(Client.sensor2));
		GUI.sensor3.setText(Integer.toString(Client.sensor3));
		
		System.out.println("Sensor UP: "+Client.sensor1+", "+Client.sensor2+", "+Client.sensor3);
	}

}
