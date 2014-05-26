package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;



public class ClientStreamListenerThread extends Thread {
	
	//public ClientStreamListenerThread(){}

	public void run(){
		
		StringTokenizer messageFromServer;
		
		try{
		while(true){
			
			messageFromServer = new StringTokenizer(Client.getMessage(), "|");
			System.out.println("-----> Le serveur a envoyé un message<------");
			
			
			Client.RequestHandlers.get(messageFromServer.nextToken()).handleRequest(messageFromServer.nextToken());
		}
		}catch(IOException e){
			System.err.println("ERROR: Can't retreive message from server");
		}
	}
}
