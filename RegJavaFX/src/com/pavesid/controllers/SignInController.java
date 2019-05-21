package com.pavesid.controllers;

import javafx.fxml.FXML;

import javafx.scene.control.*;

import com.pavesid.styles.lk;

public class SignInController {
    @FXML
    private Button connectSignIn;

    @FXML
    private TextField emailSignIn;

    @FXML
    private PasswordField passwordSignIn;

    void read(){
        emailSignIn.getText();
    }
}
