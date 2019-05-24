package com.pavesid.controllers;

import com.pavesid.Main;
import com.pavesid.helper.AlertWindow;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SQLController extends BaseController {

    @FXML
    private TextField emailSignIn;

    @FXML
    private void connectToDBAction() {
        if (Main.getMyDB().isRightPass(emailSignIn.getText())) {
            navigation.getStage().setTitle("Sign In");
            navigation.load("SignIn.fxml").Show();
        } else {
            AlertWindow.showAlert("You have entered an incorrect DB password");

            emailSignIn.setText("");
        }
    }
}
