/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;


public class SendHandler implements Runnable{
    String msg;
    Server srv;
    
    public SendHandler(Server srv){
        this.srv= srv;
    }
    @Override
    public void run() {
        while(!srv.socket.isClosed()){
            try {
                msg = srv.msgConsole.readLine();
            } catch (IOException ex) {
                System.out.println("Error getting message from console");
            }
            if (msg != null)
                srv.sendMsg(msg);
        }
    }
    
}
