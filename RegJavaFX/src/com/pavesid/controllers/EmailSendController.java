package com.pavesid.controllers;

import com.pavesid.Main;
import javafx.fxml.FXML;

public class EmailSendController extends BaseController {

    @FXML
    private void toSignIn() {
        navigation.getStage().setTitle("Sign In");
        Main.getNavigation().load("SignIn.fxml").Show();
    }
}
