package screens.classes;

import javafx.geometry.Orientation;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Created by 1 on 18.12.2016.
 */
public class Stick extends Rectangle {
    private final int HEIGHT = 2;
    private final int WIDTH = 25;

    public Stick(Orientation orientation) {
        if (orientation == Orientation.HORIZONTAL) {
            super.setHeight(HEIGHT);
            super.setWidth(WIDTH);
        }
        else {
            super.setHeight(WIDTH);
            super.setWidth(HEIGHT);
        }

        super.setFill(Color.BLACK);
    }
}
