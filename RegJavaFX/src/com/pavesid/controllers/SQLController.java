package com.pavesid.controllers;

import com.pavesid.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SQLController extends BaseController {
    @FXML
    private Button connectToDB;

    @FXML
    private TextField emailSignIn;

    @FXML
    private PasswordField passwordSignIn;

    @FXML
    private void connectToDBAction() {
        //if (Main.getMyDB().isRightPass(emailSignIn.getText())) {
        if(false){
            System.out.println("Зашли");
            Main.getNavigation().load("SignIn.fxml").Show();
        } else {
            //Main.getNavigation().createModal();
            System.out.println("Всплыло модальное окно, что пароль от БД не правильный");
        }
    }
}
