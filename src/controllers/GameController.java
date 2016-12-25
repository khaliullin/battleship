package controllers;

import classes.Field;
import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.*;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by 1 on 21.12.2016.
 */
public class GameController implements Initializable{
    @FXML
    public Label lblMyName;
    @FXML
    public Label lblEnemyName;
    @FXML
    public Pane paneEnemyField;
    @FXML
    public Pane paneMyField;
    @FXML
    public Button btnBack;
    private Stage prevStage;



    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }


    public void goToFirstScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("../fxmls/firstScreen.fxml"));
        Helper.goToFirstScreen(myLoader, prevStage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Field myField = new Field();
        for (int i = 0; i < myField.getCellsMatrix().length; i++){
            for(int j = 0; j < myField.getCellsMatrix().length; j++){
                myField.getCellsMatrix()[i][j].setGame(true);
            }
        }
        Field enemyField = new Field();
        for (int i = 0; i < enemyField.getCellsMatrix().length; i++){
            for(int j = 0; j < enemyField.getCellsMatrix().length; j++){
                enemyField.getCellsMatrix()[i][j].setGame(true);
            }
        }
        paneMyField.getChildren().add(myField);
        paneEnemyField.getChildren().add(enemyField);
        paneMyField.setDisable(true);
    }
}
