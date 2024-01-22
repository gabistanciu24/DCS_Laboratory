package lab1;
import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;



public class ServerSimplu {
  public static void main(String[] args) throws IOException{

    ServerSocket ss=null;
    Socket s=null;
    
    try{
      String line="";
      ss = new ServerSocket(1900);
      System.out.println("Serverul asteapta conexiuni...");
      s = ss.accept();
      BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));

      PrintWriter out = new PrintWriter(
            new BufferedWriter(new OutputStreamWriter(
              s.getOutputStream())),true);

      InetSocketAddress remoteadr = (InetSocketAddress)s.getRemoteSocketAddress();
      String remotehost = remoteadr.getHostName();
      int remoteport = remoteadr.getPort();
      
      System.out.println("Client nou conectat: "+remotehost+":"+remoteport);
      
      while(!line.equals("END")){
        line = in.readLine();
        System.out.println("Server a receptionat:"+line);
        out.println("ECHO "+line);
        out.flush();
      }
      
      System.out.println("Aplicatie server gata.");
      
    }catch(Exception e){e.printStackTrace();}
     finally{
      ss.close();
      if(s!=null) s.close();
     }
  }
}
