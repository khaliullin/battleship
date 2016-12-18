package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by 1 on 17.12.2016.
 */
public class firstScreenController {

    @FXML
    private TextField txtName;
    @FXML
    private Button btnSaveName;

    public void saveName(ActionEvent actionEvent) throws IOException {
        String name = txtName.getText();
        System.out.println(name);
        Parent root2 = FXMLLoader.load(getClass().getResource("../fxmls/mainScreen.fxml"));
        txtName.getScene().setRoot(root2);
    }
}
