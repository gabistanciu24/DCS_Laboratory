package lab1;
import java.io.*;
import java.net.*;

public class SerialTest extends Thread{

      public void run(){

      try{
        ServerSocket ss = new ServerSocket(1977);
        Socket s = ss.accept();
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        Pers p = (Pers)ois.readObject();
        System.out.println("Serverul a receptionat obiectul:"+p);
        s.close();
        ss.close();	
      }catch(Exception e){e.printStackTrace();}

      }

  public static void main(String[] args) throws Exception{


        (new SerialTest()).start();

        Socket s = new Socket(InetAddress.getByName("localhost"),1977);

        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        Pers p = new Pers("Alin",14);
        System.out.println("Clientul trimite obiectul: "+p);
        oos.writeObject(p);
        s.close();	

  }
}

class Pers implements Serializable{

  transient String nume;
  int varsta;

  Pers(String n, int v){
    nume = n; varsta = v;
  }

  public String toString(){
    return "Persoana: "+nume+" vasrta: "+varsta;
  }
}
