package controllers;

import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by 1 on 20.12.2016.
 */
public class SettingsController {
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
}
