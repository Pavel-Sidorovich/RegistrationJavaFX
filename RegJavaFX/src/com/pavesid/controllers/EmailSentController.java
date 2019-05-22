package com.pavesid.controllers;

import com.pavesid.Main;
import javafx.fxml.FXML;

public class EmailSentController extends BaseController {

    @FXML
    private void toSignIn() {
        Main.getNavigation().load("SignIn.fxml").Show();
    }
}
