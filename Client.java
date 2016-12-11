import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20161211
 */
public class Client {
    public static void main(String[] args) throws IOException {
        int port = 3456;
        String host = "localhost";
        Socket s = new Socket(host, port);

        String myString = "";
        OutputStream os = s.getOutputStream();
        PrintWriter out = new PrintWriter(os, true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        Scanner sc = new Scanner(System.in);

        String userName = sc.nextLine();
        out.println(userName);
        while (!myString.equals("-1")) {
            String x = in.readLine();
            System.out.println("Server: " + x);

            System.out.print(userName + ": ");
            myString = sc.nextLine();
            out.println(myString);
        }
    }
}
