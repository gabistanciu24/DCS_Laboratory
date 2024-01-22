package lab1;/*
 * lab1.ClientSimplu.java
 */


import java.net.*;
import java.io.*;

public class ClientSimplu {

  public static void main(String[] args)throws Exception{
    Socket socket=null;
    try {

      InetAddress server_address =InetAddress.getByName("10.132.67.51");

      
      socket = new Socket(server_address,1900);

      BufferedReader in =
        new BufferedReader(
          new InputStreamReader(
            socket.getInputStream()));

      PrintWriter out =
        new PrintWriter(
          new BufferedWriter(
            new OutputStreamWriter(
              socket.getOutputStream())),true);

      
      for(int i = 0; i < 10; i ++) {
        out.println("mesaj " + i);
        out.flush();
        
        String str = in.readLine();
        System.out.println(str);
      }
      out.println("END");

    }
    catch (Exception ex) {ex.printStackTrace();}
    finally{
      socket.close();
    }
  }
}

