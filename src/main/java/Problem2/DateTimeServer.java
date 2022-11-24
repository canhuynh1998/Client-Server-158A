package Problem2;

import Problem2.DateTimeService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DateTimeServer {
    public static void main(String [] args) throws IOException{
        ServerSocket server = new ServerSocket(8888);
        Socket clientSocket;
        while(true){
            clientSocket = server.accept();
            System.out.println("Client connected");
            DateTimeService service = new DateTimeService(clientSocket);
            Thread t = new Thread(service);
            t.start();
        }
    }
}
