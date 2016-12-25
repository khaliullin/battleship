package controllers;

import classes.Cell;
import classes.Field;
import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by 1 on 18.12.2016.
 */
public class RoomCreationController implements Initializable{

    @FXML
    public Button btnGenerate;
    @FXML
    public Button btnBegin;
    @FXML
    public Button btnBack;
    @FXML
    public Button btnAddShip;
    @FXML
    private Pane paneField;

    private Stage prevStage;

    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paneField.getChildren().add(new Field());
    }

    public void addShip(ActionEvent actionEvent) {
        Field field = (Field) paneField.getChildren().get(0);
        for (int i = 0; i < field.getCells().length; i++){
            for (int j = 0; j < field.getCells().length; j++){
                if (field.getCellsMatrix()[i][j].getColor() == Color.GREY){
                    field.getCellsMatrix()[i][j].setColor(Color.GREEN);
                    field.getCellsMatrix()[i][j].setShip(true);
                    field.getCells()[i][j] = 2;//корабль
                }
            }
        }
    }

    public void generateField(ActionEvent actionEvent) {
        //some actions by Sagit
    }

    public void startGame(ActionEvent actionEvent) throws IOException {
        //some actions
        //
        //


        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("../fxmls/game.fxml"));
        Parent root = myLoader.load();
        GameController controller = myLoader.getController();
        controller.setPrevStage(prevStage);

        Helper.goTo(prevStage, "Game Screen", root);
    }

    public void goToFirstScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("../fxmls/firstScreen.fxml"));
        Helper.goToFirstScreen(myLoader, prevStage);
    }
}
