package Server;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TooManyListenersException;

import Client.GUI;
import Serial.SerialCommunication;


public class Server {
	
	public static SerialCommunication serial = new SerialCommunication();
	public static HashMap<String, RequestHandler> RequestHandlers = new HashMap<String, RequestHandler>(); 
	
	public static ArrayList<ServerThread> serverThreads = new ArrayList<ServerThread>();
	
	//get message from Client and returns StringTokenizer
	public static StringTokenizer getMessage(BufferedReader in) throws IOException{
		return new StringTokenizer(in.readLine(), "|");
		
	}
		
	//send message to Client
	public static void sendMessage(String message){
		int i;
		for(i=0; i < serverThreads.size(); i++){
			serverThreads.get(i).out.println(message);
		}
	}
	
	public static boolean isRequest(String request){
		
		if(RequestHandlers.containsKey(request)){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	//TODO handle speed option (second token)
//	public static void dispatchRequest(String request){
//		
//		RequestHandler handler = (RequestHandler)RequestHandlers.get(request);
//		
//		handler.handleRequest();
//	}
	
	
	
	private static void init() throws TooManyListenersException{
//		serial.connect("/dev/ttyS33", 9600);
//		
//		serial.serialPort.addEventListener(new SerialPortEventListener(){
//
//			@Override
//			public void serialEvent(SerialPortEvent arg0) {
//				System.out.println("Serial Event!");
//				
//				SerialMessage arduino = new SerialMessage();
//				arduino.dispatchMessage(arduino.getSerialMessage());
//			}
//			
//		});
//		
//		serial.serialPort.notifyOnDataAvailable(true);
		
		RequestHandlers.put("ON", new ONRequestHandler());
		RequestHandlers.put("OFF", new OFFRequestHandler());
		RequestHandlers.put("FOR", new FORRequestHandler());
		RequestHandlers.put("BAK", new BAKRequestHandler());
		RequestHandlers.put("STO", new STORequestHandler());
		RequestHandlers.put("LEF", new LEFRequestHandler());
		RequestHandlers.put("RIG", new RIGRequestHandler());
		RequestHandlers.put("CNT", new CNTRequestHandler()); 
	}

	public static void main(String[] args) throws TooManyListenersException{
		
		Calendar time = Calendar.getInstance();
		init();
		
		try {
			ServerSocket welcomeSocket = new ServerSocket(4444);
			
		
		
		System.out.println("Server is running...");
		
		while (true){
			final Socket clientSocket = welcomeSocket.accept(); // Socket de transfert de donnees
			
			ServerThread st = new ServerThread( clientSocket ); // Creation d'un nouveau Thread
			st.start();
			serverThreads.add(st);
			
		    }
		
		} catch (IOException e) {
		    System.err.println(e.getMessage());

		}
	}
	
}
