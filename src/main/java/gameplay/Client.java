package gameplay;

import screens.classes.Field;
import screens.controllers.FirstScreenController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20161211
 */
public class Client {
    public static BufferedReader in;
    public static PrintWriter out;
    private Socket socket;
    public static int index;
    public static Field myField = new Field();
    public static Field enemyField = new Field();

    public static BlockingQueue<String> q = new LinkedBlockingQueue<>(10);

    public static String status = "";

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        String ip = FirstScreenController.ip;
        Scanner scanner = new Scanner(System.in);
        try {
            try {
                System.out.println(ip + " : ip");
                socket = new Socket(ip, 5432);
            } catch (UnknownHostException e) {
                System.out.println("No such host!");
                close();
            }
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Client created in client");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.err.println("Error in close()");
        }
    }

    public PrintWriter getOut() {
        return out;
    }

    public BufferedReader getIn() {
        return in;
    }

    public Socket getSocket() {
        return socket;
    }
}
