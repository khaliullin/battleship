package gameplay;

import screens.classes.Field;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20161222
 */
public class Player {
    private Socket socket;
    public static Field field = new Field();
    private boolean alive;
    private BufferedReader in;
    private PrintWriter out;
    public static int index = 0;

    public Player(Socket socket, int index) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.index = index;
    }

    public Field getField() {
        return field;
    }

    public BufferedReader getIn() {
        return in;
    }

    public PrintWriter getOut() {
        return out;
    }

    public Socket getSocket() {
        return socket;
    }

    public int[][] generateField() {
        System.out.println("generating field in Player");
        return field.generateField().getCells();
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}