package com.pavesid.controllers;

import com.pavesid.helper.AlertWindow;
import com.pavesid.objects.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class SignInController extends BaseController {
    @FXML
    private Button connectSignIn;

    @FXML
    private TextField emailSignIn;

    @FXML
    private PasswordField passwordSignIn;

    @FXML
    private Button btnConnect;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnForgotPass;

    //private DBRegistrationPerson dbRegistrationPerson;

    public void showDialog(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) {
            return;
        }
        Button clickBtn = (Button) source;
        switch (clickBtn.getId()) {
            case "btnConnect":
                Person p = dbRegistrationPerson.getPerson(emailSignIn.getText());
                if (dbRegistrationPerson.isDefPass(p)) {
                    ChangeDefPassController controller = (ChangeDefPassController) navigation.load("ChangeDefPass.fxml");

                    navigation.getStage().setTitle("Change Password");
                    controller.setParameterFromSignIn(emailSignIn.getText());
                    controller.Show();
                } else if (p.getPassword().equals(passwordSignIn.getText())) {
                    System.out.println("All good");
                } else {
                    passwordSignIn.setText("");
                    emailSignIn.setText("");
                    AlertWindow.showAlert("Invalid email or password");
                }
                break;
            case "btnSignUp":
                navigation.getStage().setTitle("Sign Up");
                navigation.load("SignUp.fxml").Show();
                break;
            case "btnForgotPass":
                navigation.getStage().setTitle("Password Recovery");
                navigation.load("PasswordRecovery.fxml").Show();
                break;
        }
    }
}
