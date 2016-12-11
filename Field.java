import org.jetbrains.annotations.NotNull;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20161211
 */
public class Field {
    final byte SIZE = 10;
    private byte [][] map = new byte[SIZE][SIZE];

    private void initMap(byte[][] map) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = 0;
            }
        }
    }

    @NotNull
    private String addShip(Ship ship) {
        String result = "";
        for (Coordinates coordinates : ship.getCoordinates()) {
            byte x = coordinates.getX();
            byte y = coordinates.getY();

            if (x > 10 || y > 10 || x < 0 || y < 0) {
                result = "Index out of bounds";
            }
            else {
                // TODO: 17.12.16 check with near ships
            }
        }
         return result;
    }
}
