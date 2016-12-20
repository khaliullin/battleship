package stages;

import controllers.FirstScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("../fxmls/firstScreen.fxml"));
        Parent root = myLoader.load();
        primaryStage.setResizable(false);
        FirstScreenController controller = (FirstScreenController)myLoader.getController();
        controller.setPrevStage(primaryStage);

        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add(0, "css/mycss.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
