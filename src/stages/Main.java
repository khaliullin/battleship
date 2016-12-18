package stages;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxmls/firstScreen.fxml"));
        primaryStage.setTitle("First Stage");
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setResizable(false);
        scene.getStylesheets().add(0, "css/mycss.css");
        primaryStage.setScene(scene);
        primaryStage.show();

//        Parent root2 = FXMLLoader.load(getClass().getResource("../fxmls/mainScreen.fxml"));
//        Scene scene2 = new Scene(root2, 400, 300);
//        scene.setOnMouseClicked(event -> primaryStage.getScene().setRoot(root2));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
