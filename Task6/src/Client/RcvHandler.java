/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Univer
 */
public class RcvHandler implements Runnable{
    Client cl;

    
    public RcvHandler(Client cl){
        this.cl = cl;
    }
    
    @Override
    public void run() {
        while(!cl.socket.isClosed())
            try {
                cl.getMsg();
            } catch (IOException ex) {
                System.out.println("Client disconnected");
            }

        
    }
    
}
