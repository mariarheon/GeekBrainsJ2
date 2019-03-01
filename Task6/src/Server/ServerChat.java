
package Server;

/** Java 2. Lesson 6. Connections.
 *
 * @author Maria Mikhaleva
 * @version dated Feb 28 2019
 */
public class ServerChat {

    public static void main(String[] args){
        Server server = new Server();
        server.startServer();
        server.connectClient();
        
        Thread send = new Thread(new SendHandler(server));
        send.start();
        Thread rcv = new Thread(new RcvHandler(server));
        rcv.start();
    }

}
