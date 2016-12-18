package classes;

import javafx.geometry.Orientation;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;



/**
 * Created by 1 on 18.12.2016.
 */
public class Field extends GridPane {

    private int [][]cells = new int[10][10];

    public int[][] getCells() {
        return cells;
    }

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    public boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public Field() {
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                cells[i][j] = 0;
            }
        }
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                if (isEven(i) && isEven(j)) {
                    super.add(new Dot(), i, j);
                }
                if (isEven(i) && isOdd(j)) {
                    super.add(new Stick(Orientation.VERTICAL), i, j);
                }
                if (isOdd(i) && isEven(j)) {
                    super.add(new Stick(Orientation.HORIZONTAL), i, j);
                }
                if (isOdd(i) && isOdd(j)) {
                    super.add(new Cell(this, (i + 1) / 2 - 1, (j + 1) / 2 - 1), i, j);
                }
            }
        }
    }

}