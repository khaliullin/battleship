package controllers;

import classes.Field;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by 1 on 18.12.2016.
 */
public class roomCreationController implements Initializable{

    @FXML
    public ChoiceBox choiseBoxTime;
    @FXML
    private Pane paneField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paneField.getChildren().add(new Field());
        choiseBoxTime.getItems().addAll("0:30", "1:00", "1:30");
    }
}
