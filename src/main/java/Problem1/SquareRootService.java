package Problem1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SquareRootService implements Runnable{
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    public SquareRootService(Socket s){
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
                out = new PrintWriter(socket.getOutputStream());
                doService();
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

    public void doService() throws IOException
    {
        while (true)
        {
            int number = in.nextInt();
        executeCommand(number);
        }
    }

    public void executeCommand(Integer number)
    {
        Double squareRoot = Math.sqrt(number);
        out.println(number + " has square root of " + squareRoot);
        out.flush();
    }
}
