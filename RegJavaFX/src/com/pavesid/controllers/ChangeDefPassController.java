package com.pavesid.controllers;

import com.pavesid.helper.AlertWindow;
import com.pavesid.interfaces.impls.DBRegistrationPerson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;


public class ChangeDefPassController extends BaseController{

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private Button btnConnect;

    private DBRegistrationPerson dbRegistrationPerson;

    private String emailFromSignIn;

    public String getEmailFromSignIn() {
        return emailFromSignIn;
    }

    public void setParameterFromSignIn(String emailFromSignIn) {
        this.emailFromSignIn = emailFromSignIn;
    }

    public void showDialog(ActionEvent actionEvent){
        Object source = actionEvent.getSource();

        if(!(source instanceof Button)){
            return;
        }
        Button clickBtn = (Button) source;
        switch (clickBtn.getId()){
            case "btnConnect":
                if(password.getText().equals(confirmPassword.getText())){
                    AlertWindow.showAlert(emailFromSignIn);
                    dbRegistrationPerson.updatePassPerson(emailFromSignIn, password.getText());
                    navigation.getStage().setTitle("Sign In");
                    navigation.load("SignIn.fxml").Show();
                } else
                {
                    AlertWindow.showAlert("Passwords do not match.");
                    password.setText("");
                    confirmPassword.setText("");
                }
                break;
        }
    }
}
