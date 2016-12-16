package gameplay;

import gameplay.models.Field;

import java.io.*;
import java.net.Socket;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20161222
 */
public class Player {
    private Socket socket;
    private Field field;
    private boolean alive;
    private BufferedReader in;
    private PrintWriter out;

    public Player(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
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

    public static void main(String[] args) {
        new Client();
    }

    public void generateField() {
        field = new Field();
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}