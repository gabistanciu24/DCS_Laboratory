package lab.scd.net.socket;
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
      ss = new ServerSocket(1900); //creaza obiectul serversocket
      System.out.println("Serverul asteapta conexiuni...");
      s = ss.accept(); //incepe asteptarea de conexiuni  pe portul 1900
      //in momentul in care un client s-a  conectat ss.accept() returneaza
      //un obiect de tip Socket care identifica conexiunea

      //creaza fluxurile de intrare iesire
      BufferedReader in = new BufferedReader(
              new InputStreamReader(s.getInputStream()));

      PrintWriter out = new PrintWriter(
              new BufferedWriter(new OutputStreamWriter(
                      s.getOutputStream())),true);

      //extrage adresa de ip si portul de pe care clientul s-a conectat
      InetSocketAddress remoteadr = (InetSocketAddress)s.getRemoteSocketAddress();
      String remotehost = remoteadr.getHostName();
      int remoteport = remoteadr.getPort();

      System.out.println("Client nou conectat: "+remotehost+":"+remoteport);

      int intArray[] = new int[2];
      int i=0;
      float p=0.0f;

      while(!line.equals("END")){
        line = in.readLine(); //citeste datele de la client
        if(i<2) {
          intArray[i]=Integer.parseInt(line);
          i++;
          System.out.println("Server a receptionat:"+line);
          out.println("ECHO "+line); //trimite date la client
          out.flush();
        }
        else
        {
          p=(float)intArray[1]/((float)intArray[0]*100);
          out.println(Float.toString(p)); //trimite date la client
          out.flush();
        }


      }
      //float p=(float)intArray[1]/((float)intArray[0]*100);


      System.out.println("p= "+p);
      System.out.println("Aplicatie server gata.");


    }catch(Exception e){e.printStackTrace();}
    finally{
      ss.close();
      if(s!=null) s.close();
    }
  }
}