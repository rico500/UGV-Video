import java.io.*;
import java.net.*;
public class UdpServer 
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket SocketServer = new DatagramSocket(5874);
		byte[] ReceiveData = new byte[1024];			//String vers byte
		byte[] SendData = new byte[1024];
		while(true)
		{
			DatagramPacket ReceivePacket = new DatagramPacket(ReceiveData, ReceiveData.length);
			SocketServer.receive(ReceivePacket);
			
			String Sentense = new String(ReceivePacket.getData());
			InetAddress IPAddress = ReceivePacket.getAddress();
			int port = ReceivePacket.getPort();
			String CapsSentense = Sentense.toUpperCase();
			SendData = CapsSentense.getBytes();
			
			DatagramPacket SendPacket = new DatagramPacket(SendData, SendData.length, IPAddress, port);
			SocketServer.send(SendPacket);
		}
		
		
	}

}
