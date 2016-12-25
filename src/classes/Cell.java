package classes;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

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
                if (!isShip) {//пусто
                    setColor(Color.GREY);

                    field.getCells()[i][j] = 1;//1 - miss
                    for (int k = 0; k < 10; k++) {
                        for (int z = 0; z < 10; z++) {
                            System.out.print(field.getCells()[k][z]);
                        }
                        System.out.println();
                    }
                    System.out.println("-----------------------");
                } else {//корабль
                    setColor(Color.BLUE);

                    field.getCells()[i][j] = 3;//3 - damaged
                    for (int k = 0; k < 10; k++) {
                        for (int z = 0; z < 10; z++) {
                            System.out.print(field.getCells()[k][z]);
                        }
                        System.out.println();
                    }
                    System.out.println("-----------------------");
                }
            }
            else if (color == Color.GREY && !isGame){
                setColor(Color.ORANGE);
                field.getCells()[i][j] = 0;
                for (int k = 0; k < 10; k++) {
                    for (int z = 0; z < 10; z++) {
                        System.out.print(field.getCells()[k][z]);
                    }
                    System.out.println();
                }
                System.out.println("-----------------------");
            }
        });
    }

    public void setColor(Color color) {
        super.setFill(color);
        this.color = color;
    }
}
