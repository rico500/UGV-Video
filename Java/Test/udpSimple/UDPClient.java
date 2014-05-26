import java.io.*;
import java.net.*;
public class UdpClient 
{
	public static void main(String args[])throws Exception
	{
		BufferedReader FromUser = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket SocketClient = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		
		byte[] SendData = new byte[1024];
		byte[] ReceiveData = new byte[1024];
		String Sentense = FromUser.readLine();
		SendData = Sentense.getBytes();
		
		DatagramPacket SendPacket = new DatagramPacket(SendData, SendData.length, IPAddress, 5874);
		SocketClient.send(SendPacket);
		
		DatagramPacket ReceivePacket = new DatagramPacket(ReceiveData, ReceiveData.length);
		SocketClient.receive(ReceivePacket);
		
		String NewSentense = new String(ReceivePacket.getData());
		SocketClient.close();
	}
}
