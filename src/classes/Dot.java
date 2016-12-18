package classes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by 1 on 18.12.2016.
 */
public class Dot extends Circle {
    private final double RADIUS = 1;
    private final Color color = Color.BLACK;

    public Dot() {
        super.setRadius(RADIUS);
        super.setFill(color);
    }
}
