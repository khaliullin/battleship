package screens.classes;

import gameplay.Client;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by 1 on 18.12.2016.
 */
public class Cell extends Rectangle {
    private final int SIDE = 25;
    private int i;
    private int j;
    private Color color = Color.WHITE;
    private boolean isShip = false;
    private boolean isGame = false;

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public boolean isGame() {
        return isGame;
    }

    public void setGame(boolean game) {
        isGame = game;
    }

    public boolean isShip() {
        return isShip;
    }

    public void setShip(boolean ship) {
        isShip = ship;
    }

    public Color getColor() {
        return color;
    }

    public Cell(Field field, int i, int j) {

//        if (Client.status.startsWith("s")) {
//            this.j = Integer.parseInt(Client.status.charAt(1) + "");
//            this.i = Integer.parseInt(Client.status.charAt(3) + "");
//
//            if (field.getCells()[i][j] == 1)
//                setColor(Color.ORANGE);
//            else if (field.getCells()[i][j] == 0)
//                setColor(Color.BLUE);
//            else {
//                System.out.println("WTF??????");
//            }
//        }

        super.setFill(Color.WHITE);
        super.setHeight(SIDE);
        super.setWidth(SIDE);
        this.i = i;
        this.j = j;

        super.setOnMouseEntered(event -> {
            if (super.getFill() == Color.WHITE) {
                setColor(Color.ORANGE);
            }
        });

        super.setOnMouseExited(event -> {
            if (super.getFill() == Color.ORANGE) {
                setColor(Color.WHITE);
            }
        });

        super.setOnMousePressed(event -> {
            if (color == Color.ORANGE) {
                Client.out.println(j);
                Client.out.println(i);

                System.out.println("Sending " + j + " and " + i + "from Cell");

                if (Client.enemyField.cells[i][j] == 1) {
                    Client.status = "2";
                    isShip = true;
                } else if (Client.enemyField.cells[i][j] == 0) {
                    Client.status = "-1";
                    isShip = false;
                }
                System.out.println("Cell Client.status is " + Client.status);


                // пусто
                if (!isShip) {
                    setColor(Color.GREY);
                    // -1 - miss
                    field.getCells()[j][i] = -1;
//                    for (int k = 0; k < 10; k++) {
//                        for (int z = 0; z < 10; z++) {
//                            System.out.print(field.getCells()[z][k]);
//                        }
//                        System.out.println();
//                    }
//                    System.out.println("------------------");
                }
                //корабль
                else {
                    setColor(Color.BLUE);
                    //2 - damaged
                    field.getCells()[j][i] = 2;
//                    for (int k = 0; k < 10; k++) {
//                        for (int z = 0; z < 10; z++) {
//                            System.out.print(field.getCells()[z][k]);
//                        }
//                        System.out.println();
//                    }
//                    System.out.println("------------------");
                }



                // генерация
            } else if (color == Color.GREY && !isGame) {
                setColor(Color.ORANGE);
                field.getCells()[j][i] = 0;
//                for (int k = 0; k < 10; k++) {
//                    for (int z = 0; z < 10; z++) {
//                        System.out.print(field.getCells()[z][k]);
//                    }
//                    System.out.println();
//                }
//                System.out.println("------------------");
            }




        });
    }

    public void setColor(Color color) {
        super.setFill(color);
        this.color = color;
    }
}
