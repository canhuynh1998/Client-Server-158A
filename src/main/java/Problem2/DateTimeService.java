package Problem2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class DateTimeService implements Runnable{
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    public DateTimeService(Socket s){
        socket = s;

    }
    @Override
    public void run()
    {
        try
        {
            try
            {
                in = new Scanner(socket.getInputStream());
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println(new Date().toString());
            }
            finally
            {
                socket.close();
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
