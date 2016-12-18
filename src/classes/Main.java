package classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxmls/firstScreen.fxml"));
        primaryStage.setTitle("First Screen");
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setResizable(false);
//        scene.getStylesheets().add(int index, css link);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
