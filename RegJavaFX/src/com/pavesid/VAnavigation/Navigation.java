package com.pavesid.VAnavigation;

import com.pavesid.controllers.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Navigation {

    private final Stage stage;
    private final Scene scene;

    private List<Controller> controllers = new ArrayList<>();


    public Navigation(Stage stage) {
        this.stage = stage;
        scene = new Scene(new Pane(), 720, 720);
        stage.setMinHeight(720);
        stage.setMinWidth(720);
        stage.setScene(scene);
        handleExit();
    }

    public Controller load(String sUrl) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(sUrl));
            Node root = fxmlLoader.load();

            Controller controller = fxmlLoader.getController();
            controller.setView(root);

            return controller;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void Show(Controller controller) {
        try {
            scene.setRoot((Parent) controller.getView());
            controllers.add(controller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void GoBack() {
        if (controllers.size() > 1) {
            controllers.remove(controllers.get(controllers.size() - 1));
            scene.setRoot((Parent) controllers.get(controllers.size() - 1).getView());
        }
    }


    public void ClearHistory() {
        while (controllers.size() > 1)
            controllers.remove(0);
    }

    public void createModal() {
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(scene.getWindow());
        stage.showAndWait();
    }

    public Stage getStage() {
        return stage;
    }

    public void handleExit(){
        stage.addEventHandler(KeyEvent.KEY_PRESSED, t -> {
            if(t.getCode()== KeyCode.ESCAPE) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exit");
                alert.setHeaderText("Are you sure you want to quit?");
                alert.showAndWait().filter(ButtonType.OK::equals).ifPresent(b -> {

                    stage.close();

                });
            }

        });
    }
}