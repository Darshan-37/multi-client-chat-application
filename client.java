
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class client {
    public static void main(String[] args) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        Socket s=new Socket("localhost",6969);
        BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
        thread1 t=new thread1(in);
        t.start();
        PrintWriter out=new PrintWriter(s.getOutputStream(),true);
         System.out.println("Enter username");
        String username=sc.nextLine();
        out.println(username);
      while (true) {
        
       
        String msg=sc.nextLine();
       out.println(msg);
      }
    }
}
