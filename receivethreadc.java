import java.io.*;

class thread1 extends Thread {

    BufferedReader in;

    thread1(BufferedReader in) {
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