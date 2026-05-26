import java.util.*;
import java.io.*;
import java.net.*;
public class server {
     public static void main(String[] args)throws Exception 
     {
       Scanner sc=new Scanner(System.in);
        System.out.println("Waiting for client");
        ServerSocket ss=new ServerSocket(6969);
           while(true) {

        Socket s = ss.accept();

        System.out.println("Client connected");

        ClientHandler ch = new ClientHandler(s);

        ch.start();
    }
//         PrintWriter out = new PrintWriter(s.getOutputStream(), true);
//         BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
//         ServerReceiveThread t = new ServerReceiveThread(in);
// t.start();
//   System.out.println("enter username: ");
//         String username=sc.nextLine();
//        while (true) {
       
//         String message=sc.nextLine();
//         out.println(username+": "+message);
//        }
     }
    
}