import gnu.io.*;
import java.io.*;
import java.lang.*;
import java.util.*;

public class GetAvailablePorts{

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


/*---------MAIN METHOD---------*/

public static void main (String[] args){

    HashSet availableSerialPorts = new HashSet();
    
    availableSerialPorts = getAvailableSerialPorts();
}

}
