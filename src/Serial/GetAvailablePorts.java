package Serial;
import gnu.io.*;
import java.io.*;
import java.lang.*;
import java.util.*;


public class GetAvailablePorts {
	/*--------STATIC METHODS--------*/
	   /**
	     * @return    A HashSet containing the CommPortIdentifier for all serial ports that are not currently being used.
	     */
	    public static HashSet<CommPortIdentifier> getAvailableSerialPorts() {
	        HashSet<CommPortIdentifier> h = new HashSet<CommPortIdentifier>();
	        Enumeration thePorts = CommPortIdentifier.getPortIdentifiers();
	        while (thePorts.hasMoreElements()) {
	            CommPortIdentifier com = (CommPortIdentifier) thePorts.nextElement();
	            switch (com.getPortType()) {
	            case CommPortIdentifier.PORT_SERIAL:
	                try {
	                    CommPort thePort = com.open("CommUtil", 50);
	                    thePort.close();
	                    h.add(com);
	                    System.out.println("Port, " + com.getName()+ ", is available.");
	                } catch (PortInUseException e) {
	                    System.out.println("Port, "  + com.getName() + ", is in use.");
	                } catch (Exception e) {
	                    System.err.println("Failed to open port " +  com.getName());
	                    e.printStackTrace();
	                }
	            }
	        }
	        return h;
	    }

	    
	    
	    
	    private static String askForPort() throws IOException{
	    	
	    	//Ask which port the user would like.
		    System.out.println("Enter your choice of available serial ports:");
		    BufferedReader dataIn = new BufferedReader( new InputStreamReader(System.in) );
		    String port = new String(dataIn.readLine());
		    return port;
	    }

	/*---------MAIN METHOD---------*/

	public static void main (String[] args) throws IOException{

		
	    HashSet<CommPortIdentifier> availableSerialPorts = new HashSet<CommPortIdentifier>();
	    
	    //Find available serial ports save them in HashSet and print them out.
	    availableSerialPorts = getAvailableSerialPorts();
	   
	    String selectedPort = askForPort();
	    
	    
	    }
	}

