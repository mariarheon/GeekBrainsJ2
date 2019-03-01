
package Client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SendHandler implements Runnable{
    Client cl;
    String msg;
    
    public SendHandler(Client cl){
        this.cl = cl;
    }
    
    @Override
    public void run() {
        while(!cl.socket.isClosed())
            cl.sendMsg();
    }
    
}
