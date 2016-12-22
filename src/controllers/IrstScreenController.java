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
public class IrstScreenController {

    @FXML
    private TextField txtName;
    @FXML
    private Button btnSaveName;

    private Stage prevStage;

    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }

    public void saveName(ActionEvent actionEvent) throws IOException {
        String name = txtName.getText();
        System.out.println(name);

        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("../fxmls/mainScreen.fxml"));
        Parent root = myLoader.load();
        AinScreenController controller = myLoader.getController();
        controller.setPrevStage(prevStage);


        Helper.goTo(prevStage, "Main Screen", root);
    }
}
