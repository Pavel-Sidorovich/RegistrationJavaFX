package com.pavesid.VAnavigation;

import com.pavesid.interfaces.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Navigation {

    private final Stage stage;
    private final Scene scene;

    private List<Controller> controllers = new ArrayList<>();


    public Navigation(Stage stage)
    {
        this.stage = stage;
        //scene = new Scene(new Pane(), 720, 720);
        scene = new Scene(new Pane(), 720, 720);
        stage.setMinHeight(720);
        stage.setMinWidth(720);
        stage.setScene(scene);
    }

    public Controller load(String sUrl)
    {
        try {

            //loads the fxml file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(sUrl));
            Node root = fxmlLoader.load();

            Controller controller = fxmlLoader.getController();
            controller.setView(root);

            return controller;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void Show(Controller controller)
    {
        try {
            scene.setRoot((Parent) controller.getView());
            controllers.add(controller);

//            System.out.println("Add to history: " + controller.toString() + ". Total scenes: " + controllers.size());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void GoBack()
    {
        if (controllers.size() > 1)
        {
            controllers.remove(controllers.get(controllers.size() - 1));
            scene.setRoot((Parent) controllers.get(controllers.size() - 1).getView());
        }

//        System.out.println("GoBack: " + controllers.get(controllers.size() - 1).toString() + ". Total scenes: " + controllers.size());
    }


    public void ClearHistory()
    {
        while (controllers.size() > 1)
            controllers.remove(0);

//        System.out.println("ClearHistory. Total scenes: " + controllers.size());
    }

    public void createModal(){
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(scene.getWindow());
        stage.showAndWait();
    }
}