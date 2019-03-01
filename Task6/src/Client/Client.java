
package Client;

import Server.Server;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    String outMsg;
    Socket socket;
    DataOutputStream out;
    DataInputStream in;
    BufferedReader msgConsole;
    
    public Client(){
        try {
            socket = new Socket("localhost", 8080);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            msgConsole = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Connected to localhost 8080");
            
        } catch (IOException ex) {
            System.out.println("Error connecting to server or creating streams");
        }
        
    }
    
     public void sendMsg(){
           try {
                outMsg = msgConsole.readLine();
                out.writeUTF(outMsg);
                out.flush();

           } catch (IOException ex) {
                System.out.println("Error sending message to server");
             }
            if(outMsg.equalsIgnoreCase("quit")) closeConnection();
        
    }
    
    public void getMsg() throws IOException{

            String inpMsg = in.readUTF();
            System.out.println("Server msg: " + inpMsg);
    }
    
    public void closeConnection(){
        try {
            out.close();
            in.close();
            socket.close();
            System.out.println("Disconnected");
        } catch (IOException ex) {
            System.out.println("Error closing client");
        }
    }
}
