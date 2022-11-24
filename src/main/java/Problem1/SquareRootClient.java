package Problem1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SquareRootClient {
    public static void main(String[] args) throws IOException{
        System.out.println("Welcome to the Square Root Converter!\n");
        System.out.println("Please enter your target number and press ENTER to send the number");
        Socket s = new Socket("localhost", 8888);
        InputStream instream = s.getInputStream();
        OutputStream outstream = s.getOutputStream();
        Scanner in = new Scanner(instream);
        PrintWriter out = new PrintWriter(outstream);
        Scanner console = new Scanner(System.in);
        class InputRunnable implements Runnable{
            @Override
            public void run() {

                while(!Thread.interrupted()){
                    String line = console.nextLine();
                    out.println(line);
                    out.flush();
                }
            }
        }
        InputRunnable runnable = new InputRunnable();
        Thread t = new Thread(runnable);
        t.start();
        while(in.hasNextLine()){
            String response = in.nextLine();
            System.out.println(response+"\n");
            System.out.println("Please enter your target number and press ENTER to send the number");
        }
        t.interrupt();
    }
}
