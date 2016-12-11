import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20161211
 */
public class Server {
    public static void main(String[] args) throws IOException {
        final int PORT = 3456;
        ServerSocket s = new ServerSocket(PORT);
        Socket client = s.accept();

        OutputStream os = client.getOutputStream();
        PrintWriter out = new PrintWriter(os, true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        System.out.print("Enter your name: ");
        String userName = in.readLine();

        while (true) {
            String message = "";
            out.println(message);
            System.out.println("Server: " + message);

            System.out.print(userName + ": ");
            String x = in.readLine();
            System.out.println(x);
        }
    }
}
