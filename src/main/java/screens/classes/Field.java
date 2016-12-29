package screens.classes;

import gameplay.models.Coordinates;
import javafx.geometry.Orientation;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.Random;


/**
 * Created by 1 on 18.12.2016.
 */
public class Field extends GridPane {

    public int[][] cells = new int[10][10];

    private Cell[][] cellsMatrix = new Cell[10][10];

    public void paint(int i, int j, Color color) {
        cellsMatrix[i][j].setColor(color);
    }

    public int[][] getCells() {
        return cells;
    }

    public int getCell(int i, int j) {
        return cells[i][j];
    }

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    public boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public synchronized Cell[][] getCellsMatrix() {
        return cellsMatrix;
    }

    public Field() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[j][i] = 0;
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
                    Cell cell = new Cell(this, (i + 1) / 2 - 1, (j + 1) / 2 - 1);
                    super.add(cell, i, j);
                    cellsMatrix[(i + 1) / 2 - 1][(j + 1) / 2 - 1] = cell;

                }
            }
        }
    }

    public Field generateField() {
        Field field = new Field();
        Random random = new Random();
        int variant = random.nextInt(7);

        if (variant == 0) {
            field.cells = new int[][]
                    {{0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 1, 0, 1, 1, 1, 0, 0, 1, 0},
                            {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 1, 1, 0}};
        }

        if (variant == 1) {
            field.cells = new int[][]
                    {{1, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        }

        if (variant == 2) {
            field.cells = new int[][]
                    {{0, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 1, 0, 0, 0, 0, 1, 1, 1, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 1, 0, 1, 1, 1, 1},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                            {0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                            {0, 0, 0, 1, 0, 0, 1, 0, 0, 0}};
        }

        if (variant == 3) {
            field.cells = new int[][]
                    {{0, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 1, 0, 0, 0, 0, 1, 1, 1, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                            {0, 0, 0, 1, 0, 0, 1, 0, 0, 1}};

        }

        if (variant == 4) {
            field.cells = new int[][]
                    {{1, 1, 1, 1, 0, 0, 0, 1, 1, 1},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {1, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0}};
        }

        if (variant == 5) {
            field.cells = new int[][]
                    {{0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {0, 0, 1, 1, 1, 0, 1, 0, 0, 1},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        }

        if (variant == 6) {
            field.cells = new int[][]
                    {{0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 1, 1, 1, 0, 1, 0, 0, 1},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {0, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(cells[i][j]);
            }
            System.out.println();
        }
        return field;
    }

    public byte checkShot(Coordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        if (cells[x][y] == 1) // корабль
            return 1;
        else if (cells[x][y] == 0) // пусто
            return 0;
        else if (cells[x][y] == -1) // уже стрелял мимо
            return -1;
        else if (cells[x][y] == 2) // уже стрелял в корабль
            return 2;
        return 3;
    }

    public byte heatShip(Coordinates coordinates) {
        if (checkShot(coordinates) == 1) {
            cells[coordinates.getX()][coordinates.getY()] = 2; // попал
            return 2;
        } else {
            if (checkShot(coordinates) == 0) {
                cells[coordinates.getX()][coordinates.getY()] = -1;
                return -1;
            }
            return checkShot(coordinates);
        }

    }

}