import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static final int PORT = 8100;

    public GameServer() throws IOException {
        ServerSocket serverSocket = null ;
        try {
            serverSocket = new ServerSocket(PORT);

            while (true) {
                System.out.println ("Waiting for a client ...");

                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                ClientThread clt=new ClientThread(socket);
                Thread third=new Thread(clt);
                third.start();
                third.join();
                System.out.println(clt.getValue());
                if(clt.getValue()==1)
                serverSocket.setSoTimeout(1);



            }
        } catch (IOException | InterruptedException e) {
            if(e.getMessage().equals("Accept timed out"))
            System.out.println("gata");
            else

            System.err. println ("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }
    public static void main ( String [] args ) throws IOException {
        GameServer server = new GameServer ();
    }

}
