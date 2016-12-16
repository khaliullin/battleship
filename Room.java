package gameplay;

import gameplay.models.Coordinates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20161213
 */
public class Room implements Runnable{
    private Thread thread;
    private List<Player> players;


    public Room(Player player1, Player player2) throws IOException {
        this.players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        System.out.println("Game started");
        players.get(0).generateField();
        players.get(1).generateField();
        players.get(1).setAlive(true);
        players.get(0).setAlive(true);

        boolean flag = true;

        while (players.get(0).isAlive() || players.get(1).isAlive()) {
            try {
                heat(players.get(0), players.get(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        closeRoom();
        System.out.println("Конец игры");
    }


    private void heat(Player movingPlayer, Player waitingPlayer) throws InterruptedException, IOException {
        System.out.println("Ходит " + movingPlayer);
        movingPlayer.getOut().println("you");
        String shot = movingPlayer.getIn().readLine();
        Coordinates coordinates = new Coordinates(Integer.parseInt(shot.charAt(0) + ""), Integer.parseInt(shot.charAt(2) + ""));
        System.out.println(shot.charAt(0) + ";" + shot.charAt(2));
        waitingPlayer.getOut().println(shot.charAt(0) + ";" + shot.charAt(2));

        if (waitingPlayer.getField().heatShip(coordinates)) {
            if (waitingPlayer.getField().checkIfSank(coordinates)) {
                waitingPlayer.getOut().println("3");
                movingPlayer.getOut().println("30");
                System.out.println(movingPlayer + " потопил корабль!");
            }
            else {
                waitingPlayer.getOut().println("2");
                movingPlayer.getOut().println("20");
                System.out.println(movingPlayer + " попал в корабль!");
            }
            heat(movingPlayer, waitingPlayer);
        }
        else {
            waitingPlayer.getOut().println("-1");
            movingPlayer.getOut().println("-10");
            System.out.println(movingPlayer + " промахнулся!");
            heat(waitingPlayer, movingPlayer);
        }
    }

    private void closeRoom() {
        try {
            for (Player player: players) {
                player.getSocket().close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}