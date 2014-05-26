package Server;

import java.io.IOException;
import java.util.StringTokenizer;

public class SerialMessage {
	
	public String serialMessage;
	
	public SerialMessage(){}
	
	public String getSerialMessage(){
		 byte[] buffer = new byte[1024];
		 int data;
         
		 try
         {
             int len = 0;
             while ( ( data = Server.serial.in.read()) > -1 )
             {
                 if ( data == '\n' ) {
                     break;
                 }
                 buffer[len++] = (byte) data;
             }
             serialMessage = new String(buffer, 0, len);
             System.out.print(serialMessage);
         }
         catch ( IOException e )
         {
             e.printStackTrace();
         }             
    	
    	return serialMessage;
	}
	
	
	public void dispatchMessage(String s){
		
		StringTokenizer st = new StringTokenizer(s,"|");
		
		switch (st.nextToken()){
		case "s":
			
			Server.sendMessage("SES|"+st.nextToken()
					+","+st.nextToken()
					+","+st.nextToken());
		}
	}
}
