package gameplay.models;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20161211
 */
public class Field {
    final int SIZE = 10;
    private int[][] map = new int[SIZE][SIZE];
    private int [] shipsLengths = new int[10];

    public Field() {

        this.map = new int[][]
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

        this.shipsLengths = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
    }

    private void initMap(int[][] map) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = 0;
            }
        }
    }

    @NotNull
    private String checkShip(Ship ship) {
        for (Coordinates coordinates : ship.getCoordinates()) {
            int x = coordinates.getX();
            int y = coordinates.getY();

            if (x > SIZE - 1 || y > SIZE - 1 || x < SIZE - 1 || y < SIZE - 1) {
                return "Index out of bounds";
            } else {
                if (map[x][y] == 1) {
                    return "This cell is busy";
                }
                // checking if ships near exist
                else {
                    if (x > 0) {
                        if (map[x - 1][y] == 1) {
                            return "Impossible to add ship there.";
                        }
                    }
                    if (x < SIZE - 1) {
                        if (map[x + 1][y] == 1) {
                            return "Impossible to add ship there.";
                        }
                    }
                    if (y > 0) {
                        if (map[x][y - 1] == 1) {
                            return "Impossible to add ship there.";
                        }
                    }
                    if (y < SIZE - 1) {
                        if (map[x][y + 1] == 1) {
                            return "Impossible to add ship there.";
                        }
                    }
                }
            }
        }
        return "";
    }

    private int addShip(Ship ship) {
        int length = 0;
        if (checkShip(ship).equals("")) {
            for (Coordinates coordinates : ship.getCoordinates()) {
                int x = coordinates.getX();
                int y = coordinates.getY();
                map[x][y] = 1;
                length++;
            }
        }
        boolean added = false;
        for (int i = 0; i < shipsLengths.length && !added; i++) {
            if (shipsLengths[i] == 0) {
                added = true;
                shipsLengths[i] = length;
            }
        }
        return length;
    }
    
    private boolean checkAllShips(int[][] map) {
        for (int length : shipsLengths) {
            if (length == 0)
                return false;
        }
        return true;
    }

    public boolean checkCell(Coordinates coordinates) {
        return map[coordinates.getX()][coordinates.getY()] == 1;
    }

    public byte checkShot(Coordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        if (map[x][y] == 1)
            return 1;
        else if (map[x][y] == 0)
            return 0;
        else if (map[x][y] == -1)
            return -1;
        else if(map[x][y] == 2)
            return 2;
        return 3;
    }

    public boolean checkIfSank(Coordinates coordinates) {
        if (checkShot(coordinates) == 2) {
            int x = coordinates.getX();
            int y = coordinates.getY();
            List<Coordinates> nearCells = new ArrayList<>();
            if (x > 0)
                nearCells.add(new Coordinates(x - 1, y));
            if (x < 9)
                nearCells.add(new Coordinates(x + 1, y));
            if (y > 0)
                nearCells.add(new Coordinates(x, y - 1));
            if (y < 9)
                nearCells.add(new Coordinates(x, y + 1));

            for (Coordinates c : nearCells) {
                if (checkCell(c))
                    return false;
            }
            return true;
        }
        return false;
    }

    public byte heatShip(Coordinates coordinates) {
        if (checkShot(coordinates) == 1) {
            map[coordinates.getX()][coordinates.getY()] = 2;
            return 2;
        }
        else {
            return checkShot(coordinates);
        }

    }



}
