package classes;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Created by 1 on 18.12.2016.
 */
public class Cell extends Rectangle{
    private final int SIDE = 50;
    private int i;
    private int j;


    public Cell(Field field, int i, int j) {
        super.setFill(Color.WHITE);
        super.setHeight(SIDE);
        super.setWidth(SIDE);
        this.i = i;
        this.j = j;

        super.setOnMouseEntered(event -> {
            if(super.getFill() == Color.WHITE){
                super.setFill(Color.ORANGE);
            }
        });

        super.setOnMouseExited(event -> {
            if(super.getFill() == Color.ORANGE){
                super.setFill(Color.WHITE);
            }
        });

        super.setOnMousePressed(event -> {
            if(super.getFill() == Color.ORANGE){
                super.setFill(Color.BLUE);
                field.getCells()[i][j] = 1;
                for(int k = 0; k < 10; k++){
                    for(int z = 0; z < 10; z++){
                        System.out.print(field.getCells()[k][z]);
                    }
                    System.out.println();
                }
                System.out.println("-----------------------");
            }
        });
    }

}
