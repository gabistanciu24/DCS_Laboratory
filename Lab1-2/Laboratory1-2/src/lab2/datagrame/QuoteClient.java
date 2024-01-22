/*
 * QuoteClient.java
 */
package lab2.datagrame;

import java.io.*;
import java.net.*;


public class QuoteClient {
    
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket();

        byte[] buf = new byte[256];
        InetAddress address = InetAddress.getByName("192.168.88.243");
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
        socket.send(packet);

        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

        String received = new String(packet.getData());
        System.out.println("Quote of the Moment: " + received);
    
        socket.close();
    }
    
   
}