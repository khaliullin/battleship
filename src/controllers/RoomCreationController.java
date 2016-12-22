package controllers;

import classes.Field;
import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by 1 on 18.12.2016.
 */
public class RoomCreationController implements Initializable{

    @FXML
    public ChoiceBox choiseBoxTime;
    @FXML
    private Pane paneField;

    private Stage prevStage;

    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paneField.getChildren().add(new Field());
        choiseBoxTime.getItems().addAll("0:30", "1:00", "1:30");
    }

    public void goToMainScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("../fxmls/mainScreen.fxml"));
        Parent root = myLoader.load();
        MainScreenController controller = myLoader.getController();
        controller.setPrevStage(prevStage);

        Helper.goTo(prevStage, "Connection", root);
    }
}
