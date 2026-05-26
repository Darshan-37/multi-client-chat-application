import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class ChatClientGUI {

    JFrame frame;
    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;

    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public ChatClientGUI() throws Exception {

        socket = new Socket("localhost", 6969);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        String username = JOptionPane.showInputDialog("Enter username:");
out.println(username);

        frame = new JFrame("Chat App");
        chatArea = new JTextArea();
        inputField = new JTextField();
        sendButton = new JButton("Send");
        sendButton.addActionListener(e -> {
    String msg = inputField.getText();
    out.println(msg);
    inputField.setText("");
});
Thread readerThread = new Thread(() -> {
    try {
        String msg;
        while ((msg = in.readLine()) != null) {
            chatArea.append(msg + "\n");
        }
    } catch (Exception e) {
        chatArea.append("Disconnected\n");
    }
});

readerThread.start();

        chatArea.setEditable(false);

        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(chatArea), BorderLayout.CENTER);
      JPanel bottomPanel = new JPanel(new BorderLayout());

bottomPanel.add(inputField, BorderLayout.CENTER);
bottomPanel.add(sendButton, BorderLayout.EAST);

frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
inputField.requestFocusInWindow();
    }

    public static void main(String[] args) throws Exception {
        new ChatClientGUI();
    }
}