package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Calendar;
import java.util.StringTokenizer;



public class ServerThread 
extends Thread 
{

	private Socket clientSocket; // Socket client
	
	public boolean serverThreadActive;
	public PrintStream out;
	public BufferedReader in;
	
	public StringTokenizer messageFromClient;
	public String message;
	public String messageToClient;
	
	
	public ServerThread(Socket clientSocket ){
    	this.clientSocket = clientSocket;
    	serverThreadActive = true;
    }
	
	
	public void run(){
		
		Calendar time = Calendar.getInstance();
		
		try {
			
			out = new PrintStream(clientSocket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		} catch (IOException e) {
			System.err.println("ERROR: could not open communication streams with client.");
		}
		
		
		System.out.println("-----> Le client " + clientSocket.getInetAddress().getHostName() 
				+" est connecte <------");
		//Welcome message
		out.println("|WEL|Successfully connected to server! Date: "+ time.getTime().toString());
		System.out.println("WEL|Successfully connected to server! Date: "+ time.getTime().toString());
		
		
		//listen to new messages coming from the BufferedReader
		StreamListenerThread slt = new StreamListenerThread(this, new StreamListener(){

			@Override
			public void onStreamEvent() {
				
				System.out.println("-----> Le client " + clientSocket.getInetAddress().getHostName() 
						+" a envoyé un message<------");
				
				//Get message out of StringTokenizer. The first message will be the request.
				message = messageFromClient.nextToken();
				System.out.println(message);
				
				//if valid the request is handled
				if(Server.RequestHandlers.containsKey(message)){
					Server.RequestHandlers.get(message).handleRequest(messageFromClient.nextToken());
				}
			}
			
		}); 
		
		slt.start();
	}
}
