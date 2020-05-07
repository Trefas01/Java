import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable {
    private Socket socket = null ;
    private volatile int value;

    public int getValue() {
        return value;
    }

    public ClientThread (Socket socket) { this.socket = socket ;}
    @Override
    public void run () {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String request;
            String raspuns;
            while(true) {
               request = in.readLine();
                // Send the response to the oputput stream: server → client
                if(request.equals("stop"))
                {raspuns = "Server stopped";
                System.out.println("opresc");
                value=1;

                    out.println(raspuns);
                    out.flush();
                    break;

                }

                raspuns = "Server recieved the request...";
                out.println(raspuns);
                out.flush();
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }

}
