package gameplay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20161211
 */
public class Client {
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите IP адрес сервера (xxx.xxx.xxx.xxx)");
        String ip = scanner.nextLine();

        try {
            try {
                socket = new Socket(ip, 5432);
            } catch (UnknownHostException e) {
                System.out.println("No such host!");
                close();
            }
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

//            Resender resender = new Resender(in);
//            resender.start();

            while (true) {
                String input = in.readLine();
                if (input.equals("you")) {
                    System.out.println("your turn: ");
                    String coord = scanner.nextLine();
                    out.println(coord);
                }

                else if (input.equals("3")){
                    System.out.println("Соперник потопил ваш корабль");
                }

                else if (input.equals("2")){
                    System.out.println("Соперник попал");
                }

                else if (input.equals("-1")){
                    System.out.println("Соперник промахнулся");
                }

                else if (input.equals("30")){
                    System.out.println("Вы потопили корабль!");
                }

                else if (input.equals("20")){
                    System.out.println("Вы попали!");
                }

                else if (input.equals("-10")){
                    System.out.println("Вы промахнулись!");
                }

                else {
                    System.out.println(input);
                }

            }


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
