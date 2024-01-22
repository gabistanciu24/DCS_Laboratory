/*
 * Created on Jan 13, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package lab.scd.net.neblocant1;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.channels.spi.*;
import java.nio.charset.*;
import java.net.*;
import java.util.*;

public class NonBlockingClient {
	
	
	public static void main(String[] args) throws IOException {

		SocketChannel client = SocketChannel.open();

		client.configureBlocking(false);

		client.connect(new InetSocketAddress("localhost",8000));

		Selector selector = Selector.open();


		SelectionKey clientKey = client.register(selector, SelectionKey.OP_CONNECT);


		while (selector.select(500)> 0) {
			
		  System.err.println("Start communication...");
		  

		  Set keys = selector.selectedKeys();
		  Iterator i = keys.iterator();


		  while (i.hasNext()) {
		    SelectionKey key = (SelectionKey)i.next();


		    i.remove();

		    SocketChannel channel = (SocketChannel)key.channel();


		    if (key.isConnectable()) {


		      System.out.println("Server Found");


		      if (channel.isConnectionPending())
		        channel.finishConnect();

		      ByteBuffer buffer = null;
		      int x=0;
		      for (;x<7;) {
		      	x++;
		        buffer = 
		          ByteBuffer.wrap(
		            new String(" Client " + x + " "+x).getBytes());
		        channel.write(buffer);
		        buffer.clear();
		        try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		      }
		      channel.finishConnect();
		      client.close();
		    }
		  }
		}
		System.err.println("Client terminated.");
	}
}
