import java.util.ArrayList;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20161211
 */
public class Ship {
    private byte length;
    private ArrayList<Coordinates> coordinates = new ArrayList<Coordinates>();

    public Ship(byte length, ArrayList<Coordinates> coordinates) {
        this.length = length;
        this.coordinates = coordinates;
    }

    public byte getLength() {
        return length;
    }

    public ArrayList<Coordinates> getCoordinates() {
        return coordinates;
    }
}
