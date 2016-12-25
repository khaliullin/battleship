package controllers;

import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by 1 on 17.12.2016.
 */
public class FirstScreenController {
    @FXML
    public TextField txtHost;
    @FXML
    private Button btnSaveName;

    private Stage prevStage;

    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }

    public void saveName(ActionEvent actionEvent) throws IOException {
        String host = txtHost.getText();
        System.out.println(host);

        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("../fxmls/roomCreation.fxml"));
        Parent root = myLoader.load();
        RoomCreationController controller = myLoader.getController();
        controller.setPrevStage(prevStage);


        Helper.goTo(prevStage, "Connection", root);
    }
}
