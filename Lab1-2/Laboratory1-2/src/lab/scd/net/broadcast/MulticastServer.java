/*
 * MulticastServer.java
 */
package lab.scd.net.broadcast;


import java.net.*;

public class MulticastServer extends Thread {

    DatagramSocket socket;
    boolean alive=true;
    
    public MulticastServer() throws SocketException{
        socket = new DatagramSocket(1977);
    }
    
    public void run(){
        
        try{
            System.out.println("Multicast server started.");
	        while(alive){
	            byte[] buf = new byte[256];
	

	            DatagramPacket rcvdPacket = new DatagramPacket(buf, buf.length);
	            

	            socket.receive(rcvdPacket);

	            InetAddress group = InetAddress.getByName("230.0.0.1");

	            DatagramPacket packet = new DatagramPacket(buf, buf.length, 
                        group, 4446);
	            
	            packet.setData(rcvdPacket.getData());

	            socket.send(packet);
                
	        }
        
        }catch(Exception e){
            System.err.println("Server error: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args)throws Exception {
        MulticastServer ms = new MulticastServer();
        ms.start();

        
    }
}
