import java.net.*;
import java.io.*;
import java.util.ArrayList;


public class ClientHandler extends Thread {
    String username;
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    static ArrayList<ClientHandler>clients=new ArrayList<>();

    ClientHandler(Socket socket) throws Exception {

        this.socket = socket;

        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        out = new PrintWriter(
                socket.getOutputStream(),
                true
        );
        username = in.readLine();
broadcast("SYSTEM: " + username + " joined");
System.out.println(username + " connected");
        clients.add(this);
    }

    void broadcast(String msg){
        for(ClientHandler c:clients){
            c.out.println(msg);
        }
    }

    public void run() {
           try {

        while(true) {

            String msg = in.readLine();

            if(msg == null) {
                break;
            }
           if (msg.equals("/users")) {

    out.println("Online users:");

    for (ClientHandler c : clients) {
        out.println("- " + c.username);
    }

    continue;
}
            broadcast(username + ": " + msg);
        }

    } catch(Exception e) {

       
    }
    finally {
    try {
        socket.close();
    } catch (Exception e) {}

    clients.remove(this);

    broadcast("SYSTEM: " + username + " left");
    System.out.println(username + " disconnected");
}
    }
}