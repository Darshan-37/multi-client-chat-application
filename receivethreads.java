import java.io.*;
class ServerReceiveThread extends Thread {

    BufferedReader in;

    ServerReceiveThread(BufferedReader in) {
        this.in = in;
    }

    public void run() {

        try {

            while(true) {

                String msg = in.readLine();
                System.out.println(msg);

            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}