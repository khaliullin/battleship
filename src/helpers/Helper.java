package helpers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by 1 on 20.12.2016.
 */
public class Helper {

    public static void goTo(Stage prevStage, String title, Parent root){
        prevStage.setTitle(title);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(0, "css/mycss.css");
        prevStage.setScene(scene);
    }

    public static void goTo(Stage prevStage, String title, Parent root, double width, double height){
        prevStage.setTitle(title);
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(0, "css/mycss.css");
        prevStage.setScene(scene);
    }
}
