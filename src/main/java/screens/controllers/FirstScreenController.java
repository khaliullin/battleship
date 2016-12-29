package screens.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import screens.helpers.Helper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by 1 on 17.12.2016.
 */
public class FirstScreenController implements Initializable {
    public static String ip;
    @FXML
    public TextField txtHost;

    public static String getIp() {
        return ip;
    }

    private Stage prevStage;

    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }

    public void saveName(ActionEvent actionEvent) throws IOException {
        ip = txtHost.getText();
        System.out.println(ip);

        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/fxmls/roomCreation.fxml"));
        Parent root = myLoader.load();
        RoomCreationController controller = myLoader.getController();
        controller.setPrevStage(prevStage);


        Helper.goTo(prevStage, "Генерация карты", root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
