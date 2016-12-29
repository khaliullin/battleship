package screens.controllers;

import gameplay.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import screens.classes.Field;
import screens.helpers.Helper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by 1 on 18.12.2016.
 */
public class RoomCreationController implements Initializable {
    @FXML
    public Button btnGenerate;
    @FXML
    public Button btnBegin;
    @FXML
    public Button btnBack;
    @FXML
    private Pane paneField;

    private Stage prevStage;


    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paneField.getChildren().add(new Field());
        System.out.println("IP адрес:  " + FirstScreenController.getIp());
        Client client = new Client();
        System.out.println("Client created");

        try {
            Client.index = Integer.parseInt(Client.in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        paneField.setDisable(true);

    }


    public void generateField(ActionEvent actionEvent) throws IOException {
        System.out.println("generate button pressed");
        Client.out.println("-11");

        Client.myField = (Field) paneField.getChildren().get(0);

        System.out.println("======================");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int coord = Integer.parseInt(Client.in.readLine());
                System.out.print(coord);
                if (coord == 1) {
                    Client.myField.getCellsMatrix()[j][i].setColor(Color.GREEN);
                    Client.myField.getCellsMatrix()[j][i].setShip(true);
                    //корабль
                    Client.myField.getCells()[j][i] = 1;
                }
            }
            System.out.println();
        }
        System.out.println("======================");
        Client.myField.setDisable(true);


//        CoordinatesSendThread coordinatesSendThread = new CoordinatesSendThread(Client.out, Client.myField, Client.q);
//        coordinatesSendThread.start();
    }

    public void startGame(ActionEvent actionEvent) throws IOException, InterruptedException {

        System.out.println("\n\nENEMY FIELD");
        for (int i = 0; i < Client.myField.cells.length; i++) {
            for (int j = 0; j < Client.myField.cells.length; j++) {
                Client.out.println(Client.myField.cells[j][i]);
                Client.enemyField.cells[j][i] = Integer.parseInt(Client.in.readLine());
                System.out.print(Client.enemyField.cells[j][i]);
            }
            System.out.println();
        }


//        CoordinatesGetThread coordinatesGetThread = new CoordinatesGetThread(Client.in, Client.enemyField, Client.q);

//        coordinatesSendThread.join();
//        coordinatesGetThread.start();
//        coordinatesGetThread.join();


//        try {
////            coordinatesSendThread.join();
////            coordinatesGetThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        Client.out.println("-12");

        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/fxmls/game.fxml"));
        Parent root = myLoader.load();
        GameController controller = myLoader.getController();
        controller.setPrevStage(prevStage);

        Helper.goTo(prevStage, "Игра", root);
    }

    public void goToFirstScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/fxmls/firstScreen.fxml"));
        Helper.goToFirstScreen(myLoader, prevStage);
    }

}
