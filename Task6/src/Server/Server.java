
package Server;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server{
    String inpMsg;
    Socket socket; 
    DataOutputStream out;
    DataInputStream in;
    BufferedReader msgConsole;
    ServerSocket serverSocket;

    public void startServer(){
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server is running. Waiting for connections.");
          } catch (IOException ex) {
            System.out.println("Oops. 505. Connection problems.");
        } 
    }
    
    public void closeConnection(){
        try {
            out.close();
            in.close();
            socket.close();
            System.out.println("Disconnected");
        } catch (IOException ex) {
            System.out.println("Error closing connection");
        }
    
    }
    
    public void connectClient(){
        try {
            socket = serverSocket.accept();
            System.out.println("Client connected");
        } catch (IOException ex) {
            System.out.println("Client connection failed");
        }
        try{
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            msgConsole = new BufferedReader(new InputStreamReader(System.in));
        } catch(IOException ex) {
            System.out.println("Error creating streams");
        }

    }
    
    public void sendMsg(String outMsg){
        try {
            out.writeUTF(outMsg);
            out.flush();
        } catch (IOException ex) {
            System.out.println("Error sending message to client");
        }
    }
    
    public void getMsg(){
        try {
            inpMsg = in.readUTF();
            System.out.println("Client msg: " + inpMsg);

        } catch (IOException ex) {
            System.out.println("Error receiving message from client");
        }
         if (inpMsg.equalsIgnoreCase("quit")){
                closeConnection();
            }
    }
    
}
