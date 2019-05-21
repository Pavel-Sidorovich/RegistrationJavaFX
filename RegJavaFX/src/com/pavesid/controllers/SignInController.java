package com.pavesid.controllers;

import com.pavesid.Main;
import com.pavesid.interfaces.impls.DBRegistrationPerson;
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

    private DBRegistrationPerson dbRegistrationPerson;

    public void showDialog(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) {
            return;
        }
        Button clickBtn = (Button) source;
        switch (clickBtn.getId()) {
            case "btnConnect":
                Person p = dbRegistrationPerson.getPerson(emailSignIn.getText());
                if (dbRegistrationPerson.isDeffPass(p)) {
                    //Окно с изменением пароля
                } else if (p.getPassword().equals(passwordSignIn.getText())) {
                    System.out.println("All good");
                } else {
                    System.out.println("Something not right");
                }
                break;
            case "btnSignUp":
                Main.getNavigation().load("SignUp.fxml").Show();
                break;
            case "btnForgotPass":
                //Main.getNavigation().load(Main.getNavigation().).Show();
                System.out.println("Тут должно быть восстановление пароля. В идеале кидается на почту новый пароль и ожиается потом изменение.");
                break;
        }
    }
}
