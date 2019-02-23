
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maria Mikhaleva
 * @version dated Feb 23 2019
 */
public class ClientWindow extends JFrame{
    
    private JTextArea chatArea;
    private JTextField messageArea;
    private JTextField clientNameArea;
    
    private String clientName = "";

    
    public ClientWindow(){
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        JScrollPane mainArea = new JScrollPane(chatArea);
        add(mainArea, BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        
        messageArea = new JTextField("Enter your message: ");
        bottomPanel.add(messageArea, BorderLayout.CENTER);
        
        clientNameArea = new JTextField("Your name: ");
        bottomPanel.add(clientNameArea, BorderLayout.WEST);
        
        JButton sendMessage = new JButton("Send");
        bottomPanel.add(sendMessage, BorderLayout.EAST);
        sendMessage.addActionListener(new SendEventListener());
        
        messageArea.addFocusListener(new fieldFocus(messageArea));
        clientNameArea.addFocusListener(new fieldFocus(clientNameArea));
        
        //по нажатию Enter срабатывает кнопка
        JRootPane rootPane = SwingUtilities.getRootPane(sendMessage);
        rootPane.setDefaultButton(sendMessage);
        setVisible(true);
    }
    
    class SendEventListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(!clientNameArea.getText().trim().isEmpty() && !messageArea.getText().trim().isEmpty()){
                //clientName = clientNameArea.getText
                sendMessage();
            } else if (clientNameArea.getText().trim().isEmpty() && messageArea.getText().trim().isEmpty()){
                popUp("Enter your name and message");
            } else if (messageArea.getText().trim().isEmpty()){
                popUp("Enter your message");
            } else popUp("Enter your name");
        }
    }
    
    class fieldFocus extends FocusAdapter{
        JTextField focusedField;
        
        public fieldFocus(JTextField focusedField){
            this.focusedField = focusedField;
        }
       
        @Override
        public void focusGained(FocusEvent e){
            this.focusedField.setText("");
        }
    }
    
    public void sendMessage(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM HH:mm");
        Date date = new Date();
        String msg = dateFormat.format(date) + ". " + clientNameArea.getText() + ": " + messageArea.getText();
        System.out.println(msg);
        chatArea.append(msg);
        chatArea.append("\n");
        //messageArea.setText("");
    }
    
    public void popUp(String s){
        JOptionPane.showMessageDialog(null, s);
    }
}
