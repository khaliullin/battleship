package gameplay;

import gameplay.helpers.GenerationThread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20161213
 */
public class Room implements Runnable {
    private Thread thread;
    private static List<Player> players;

    public Room(Player player1, Player player2) throws IOException {
        this.players = new ArrayList<>();
        players.add(0, player1);
        players.add(1, player2);
        this.thread = new Thread(this);
        this.thread.start();
    }

    public static Player getPlayer(int index) {
        return players.get(index);
    }

    @Override
    public void run() {
        System.out.println("Room started");
        Player p1 = players.get(0);
        Player p2 = players.get(1);


        GenerationThread gt1 = new GenerationThread(p1);
        gt1.start();

        GenerationThread gt2 = new GenerationThread(p2);
        gt2.start();

        try {
            gt1.join();
            gt2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("fields generated");


        // exchanging with maps
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    p1.getOut().println(p2.getIn().readLine());
                    p2.getOut().println(p1.getIn().readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



        p1.setAlive(true);
        p2.setAlive(true);

        try {
            String c1 = p1.getIn().readLine();
            String c2 = p2.getIn().readLine();

            if (c1.equals("-12") && c2.equals("-12")) {
                System.out.println("they are playing");
                while (p1.isAlive() || p2.isAlive()) {
                    heat(p1, p2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        closeRoom();
        System.out.println("Конец игры");
    }


    private void heat(Player movingPlayer, Player waitingPlayer) throws InterruptedException, IOException {
        movingPlayer.getOut().println("y");
        waitingPlayer.getOut().println("n");

        String res = movingPlayer.getIn().readLine();
        while (res.equals("8")) {
            res = movingPlayer.getIn().readLine();
//            System.out.println("RES: " + res);
        }
        System.out.println("i: " + res);
        String i = movingPlayer.getIn().readLine();
        System.out.println("j: " + i);
        String result = movingPlayer.getIn().readLine();
        System.out.println("New res: " + result);

        while (result.equals("8")) {
            result = movingPlayer.getIn().readLine();
        }
        System.out.println("На сервере res (-1/2): " + result);

        waitingPlayer.getOut().println(res + ":" + i);


        if (result.equals("-1")) {
            System.out.println("missed");
//            waitingPlayer.getOut().println("-10");
            heat(waitingPlayer, movingPlayer);
        }
        else if (result.equals("2")) {
            System.out.println("got it");
//            waitingPlayer.getOut().println("20");
            heat(movingPlayer, waitingPlayer);
        }

    }

    private void closeRoom() {
        try {
            for (Player player : players) {
                player.getSocket().close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}