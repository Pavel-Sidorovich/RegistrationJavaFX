package com.pavesid;

import com.pavesid.VAnavigation.Navigation;
import com.pavesid.objects.MyDB;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private static MyDB myDB = new MyDB();
    private static Navigation navigation;

    public static MyDB getMyDB()
    {
        return myDB;
    }

    public static Navigation getNavigation()
    {
        return navigation;
    }

    @Override
    public void start(Stage primaryStage){
        navigation = new Navigation(primaryStage);

        primaryStage.setTitle("SQl password");
        primaryStage.show();

        //navigate to first view
        Main.getNavigation().load("SQL.fxml").Show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}