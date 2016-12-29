package screens.controllers;

import gameplay.Client;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import screens.classes.Field;
import screens.helpers.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by 1 on 21.12.2016.
 */
public class GameController implements Initializable {
    public static boolean send;
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
    @FXML
    public Label heatLabel;
    private Stage prevStage;

    public BufferedReader in = Client.in;
    public PrintWriter out = Client.out;


    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }


    public void goToFirstScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/fxmls/firstScreen.fxml"));
        Helper.goToFirstScreen(myLoader, prevStage);
    }

    public int pause() throws IOException {
        Client.status = Client.in.readLine();
        System.out.println("You've been " + Client.status);
        return 1;
    }

    public int heat() {
        Client.status = "8";
        Client.out.println(Client.status);
        return 1;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        heatLabel.setVisible(true);
//        Field myField = new Field();
//        for (int i = 0; i < myField.getCellsMatrix().length; i++) {
//            for (int j = 0; j < myField.getCellsMatrix().length; j++) {
//                myField.getCellsMatrix()[i][j].setGame(true);
//            }
//        }

        Field enemyField = new Field();
        for (int i = 0; i < enemyField.getCellsMatrix().length; i++) {
            for (int j = 0; j < enemyField.getCellsMatrix().length; j++) {
                enemyField.getCellsMatrix()[i][j].setGame(true);
            }
        }
        paneMyField.getChildren().add(Client.myField);
        paneEnemyField.getChildren().add(enemyField);
        paneMyField.setDisable(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                play();
            }
        }).start();

    }

    public synchronized void play() {
        try {
            String input = Client.in.readLine();
            Client.status = "8";
            System.out.println("input in play(): " + input);

            if (input.equals("y")) {
                paneEnemyField.setDisable(false);
                heatLabel.setText("Ваш ход!");
                heatLabel.setVisible(true);

                while (Client.status.equals("8")) {
                    Client.out.println(Client.status);
                }
                System.out.println("Отправили " + Client.status + " на сервер");
                Client.out.println(Client.status); // send -1 or 2


            }


            if (input.equals("n")) {
                paneEnemyField.setDisable(true);
                heatLabel.setVisible(false);

                String coord = Client.in.readLine();
                System.out.println("Получили координату " + coord);
                int i = Integer.parseInt(coord.charAt(0) + "");
                int j = Integer.parseInt(coord.charAt(2) + "");


                System.out.println("Beaten coord: " + i + j);


                System.out.println("BEATEN CELL: " + Client.myField.cells[i][j]);
                // painting our cell
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
//                        if (Client.myField.cells[i][j] == 0) {
//                            Client.myField.getCellsMatrix()[j][i].setColor(Color.LIGHTBLUE);
//                        }
//                        else  {
//                            Client.myField.getCellsMatrix()[j][i].setColor(Color.RED);
//                        }
                        Client.myField.getCellsMatrix()[j][i].setColor(Color.RED);

//                        System.out.println("\n MY FIELD");
//                        for (int k = 0; k < 10; k++) {
//                            for (int l = 0; l < 10; l++) {
//                                System.out.print(Client.myField.cells[i][j]);
//                            }
//                            System.out.println();
//                        }
                    }
                });


//                Client.myField.cells[i][j] = 3;
            }

            play();

//
//            while (input.equals("n")) {
//                pause();
//            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
