package Problem2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class DateTimeClient {
    public static void main(String[] args) throws IOException{
        System.out.println("Welcome to the Square Root Converter!\n");
        Socket s = new Socket("localhost", 8888);
        InputStream instream = s.getInputStream();
        OutputStream outstream = s.getOutputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(instream));

            String response = reader.readLine();
            System.out.println(response+"\n");

    }
}
