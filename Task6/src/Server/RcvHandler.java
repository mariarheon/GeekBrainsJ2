
package Server;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RcvHandler implements Runnable{
    Server srv;

    public RcvHandler(Server srv) {
        this.srv = srv;
    }
       
    @Override
    public void run() {
        while(!srv.socket.isClosed()){
            srv.getMsg();
                   
        }
    }
        
    
}
