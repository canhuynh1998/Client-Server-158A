package Problem1;
import java.net.*;
import java.io.*;

public class SquareRootServer {
    public static void main(String [] args) throws IOException{
        ServerSocket server = new ServerSocket(8888);
        Socket clientSocket;
        while(true){
            clientSocket = server.accept();
            System.out.println("Client connected");
            SquareRootService service = new SquareRootService(clientSocket);
            Thread t = new Thread(service);
            t.start();
        }
    }
}
