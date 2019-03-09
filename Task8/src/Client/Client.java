package Client;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Maria Mikhaleva
 */
public class Client extends JFrame {

    private final String SERVER_HOST = "localhost";
    private final int SERVER_PORT = 8080;
    private Socket clientSocket;
    private Scanner inMsg;
    private PrintWriter outMsg;

    private boolean login;
    private long time;

    private JTextField jtfMsg;
    private JTextField jtfName;
    private JTextArea jtaAreaMsg;

    public Client() throws HeadlessException {
        try {
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
            time = System.currentTimeMillis();
            login = false;
            inMsg = new Scanner(clientSocket.getInputStream());
            outMsg = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        setBounds(500, 300, 500, 400);
        setTitle("client of chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jtaAreaMsg = new JTextArea();
        jtaAreaMsg.setEditable(false);
        jtaAreaMsg.setLineWrap(true);

        JScrollPane jScrollPane = new JScrollPane(jtaAreaMsg);
        add(jScrollPane, BorderLayout.CENTER);

        JLabel labelCountOfClients = new JLabel("In our chat client count = ");
        add(labelCountOfClients, BorderLayout.NORTH); //тут мб еще один лэйбл

        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);

        JButton sendButton = new JButton("SEND");
        bottomPanel.add(sendButton, BorderLayout.EAST);

        jtfMsg = new JTextField("Enter your message:");
        bottomPanel.add(jtfMsg, BorderLayout.CENTER);

        jtfName = new JTextField("Login:");
        bottomPanel.add(jtfName, BorderLayout.WEST);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = jtfMsg.getText().trim();
                String name = jtfName.getText().trim();

                if (!msg.isEmpty() && !name.isEmpty()) {
                    sendMsg();
                    jtfMsg.grabFocus();
                }
            }
        });

        jtfMsg.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jtfMsg.setText("");
            }
        });

        jtfName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jtfName.setText("");
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (inMsg.hasNext()) {
                        String msg = inMsg.nextLine();
                        String clientInChat = "In our chat client count = ";
                        if (msg.indexOf(clientInChat) == 0) {
                            labelCountOfClients.setText(msg);
                        } else {
                            jtaAreaMsg.append(msg);
                            jtaAreaMsg.append("\n");
                        }
                    }
                }
            }
        }
        ).start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                String clientName = jtfName.getText();
                if (!clientName.isEmpty() && !clientName.equalsIgnoreCase("Login:")) {
                    outMsg.println(clientName + " exited from chat");
                } else {
                    outMsg.println("Annonymous exited from chat");
                }

                clientClose();
                try {
                    clientSocket.close();
                } catch (IOException ex) {

                    ex.printStackTrace();
                }

            }
        });
        setVisible(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if ((System.currentTimeMillis() - time) >= 120000 && login == false) {
                        clientClose();
                        setVisible(false);
                        clientClose();
                        dispose();
                    }
                    if (login == true) {
                        break;
                    }
                }
            }
        }
        ).start();
    }

    private void clientClose() {
        outMsg.println("quit");
        outMsg.flush();
        outMsg.close();
        inMsg.close();
    }

    private void sendMsg() {
        login = true;
        String msg = jtfName.getText() + ": " + jtfMsg.getText();
        outMsg.println(msg);
        outMsg.flush();
        jtfMsg.setText("");
    }

}
