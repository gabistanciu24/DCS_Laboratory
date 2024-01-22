package lab.scd.net.socket;
import java.net.*;
import java.io.*;

public class ClientSimplu {

  public static void main(String[] args)throws Exception{
    Socket socket=null;
    try {

      InetAddress server_address =InetAddress.getByName("172.20.10.2");


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

      int x = 5;
      int y = 17;
      //for(int i = 0; i < 10; i ++) {
      out.println(x);
      out.flush();
      out.println(y);
      out.flush();
      out.println("result");
      out.flush();

      String str = "";

      str = in.readLine();
      System.out.println(str);

      str = in.readLine();
      System.out.println(str);

      str = in.readLine();
      System.out.println(str);
      out.println("END");
    catch (Exception ex) {ex.printStackTrace();}
    finally{
      socket.close();
    }
  }
}