import org.jetbrains.annotations.NotNull;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20161211
 */
public class Field {
    final byte SIZE = 10;
    private byte[][] map = new byte[SIZE][SIZE];

    private void initMap(byte[][] map) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = 0;
            }
        }
    }

    @NotNull
    private String checkShip(Ship ship) {
        for (Coordinates coordinates : ship.getCoordinates()) {
            byte x = coordinates.getX();
            byte y = coordinates.getY();

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

    private boolean addShip(Ship ship) {
        if (checkShip(ship).equals("")) {
            for (Coordinates coordinates : ship.getCoordinates()) {
                byte x = coordinates.getX();
                byte y = coordinates.getY();
                map[x][y] = 1;
            }
        }
        return true;
    }
}
