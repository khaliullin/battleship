package gameplay;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20161211
 */

public class Server {

    private final int PORT = 5432;

    public  Server() {
    }

    private void start() {

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            while (true) {
                Socket socket1 = serverSocket.accept();
                System.out.println("Player 1 connected");
                Player player1 = new Player(socket1);

                Socket socket2 = serverSocket.accept();
                System.out.println("Player 2 connected");
                Player player2 = new Player(socket2);

                new Room(player1, player2);
                System.out.println("Room created");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        (new Server()).start();
    }
}