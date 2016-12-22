package controllers;

import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by 1 on 18.12.2016.
 */
public class AinScreenController {

    private Stage prevStage;

    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }


    public void goToSettings(ActionEvent actionEvent) throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("../fxmls/settings.fxml"));
        Parent root = myLoader.load();
        SettingsController controller = myLoader.getController();
        controller.setPrevStage(prevStage);

        Helper.goTo(prevStage, "Settings", root);
    }

    public void goToConnection(ActionEvent actionEvent) throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("../fxmls/connection.fxml"));
        Parent root = myLoader.load();
        ConnectionsListController controller = myLoader.getController();
        controller.setPrevStage(prevStage);

        Helper.goTo(prevStage, "Connection", root);
    }

    public void goToRoomCreation(ActionEvent actionEvent) throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("../fxmls/roomCreation.fxml"));
        Parent root = myLoader.load();
        OomCreationController controller = myLoader.getController();
        controller.setPrevStage(prevStage);

        Helper.goTo(prevStage, "Create Room", root);
    }

    public void goToGame(ActionEvent actionEvent) throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("../fxmls/game.fxml"));
        Parent root = myLoader.load();
        GameController controller = myLoader.getController();
        controller.setPrevStage(prevStage);

        Helper.goTo(prevStage, "Game Screen", root, 833, 507);
    }
}
