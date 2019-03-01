
package Client;

import java.util.logging.Level;
import java.util.logging.Logger;

/** Java 2. Lesson 6. Connections.
 *
 * @author Maria Mikhaleva
 * @version dated Feb 28 2019
 */
public class ClientChat {
    
    public static void main(String[] args){
        Client client = new Client();
        
        Thread send = new Thread(new SendHandler(client));
        send.start();
        
        Thread rcv = new Thread(new RcvHandler(client));
        rcv.start();
        
    }
}
