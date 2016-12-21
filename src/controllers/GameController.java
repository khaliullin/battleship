package controllers;

import classes.Field;
import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by 1 on 21.12.2016.
 */
public class GameController implements Initializable{
    public Label lblMyName;
    public Label lblEnemyName;
    public Label lblTime;
    public Pane paneEnemyField;
    public Pane paneMyField;
    private Stage prevStage;



    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }


    public void goToMainScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("../fxmls/mainScreen.fxml"));
        Parent root = myLoader.load();
        MainScreenController controller = myLoader.getController();
        controller.setPrevStage(prevStage);

        Helper.goTo(prevStage, "Main Screen", root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paneMyField.getChildren().add(new Field());
        paneEnemyField.getChildren().add(new Field());
        paneEnemyField.setDisable(true);
    }
}
