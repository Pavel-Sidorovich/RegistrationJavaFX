package com.pavesid.controllers;

import com.pavesid.Main;
import com.pavesid.interfaces.impls.DBRegistrationPerson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class ChangeDefPassController extends BaseController{

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private Button btnConnect;

    private DBRegistrationPerson dbRegistrationPerson;

    public void showDialog(ActionEvent actionEvent){
        Object source = actionEvent.getSource();

        if(!(source instanceof Button)){
            return;
        }
        Button clickBtn = (Button) source;
        switch (clickBtn.getId()){
            case "btnConnect":
                if(password.getText().equals(confirmPassword.getText())){
                    //email вернуть из прошлого окна
                    ////dbRegistrationPerson.getPerson(emailSignIn.getText());
                    //Устанавливаем пароль и дефолтный зануляем
                    //Снова переход на вход
                    Main.getNavigation().load("SignIn.fxml").Show();
                } else
                {
                    //Кидаем модальное окно, что не одинаковые пароли.
                    //Зануляем
                    password.setText("");
                    confirmPassword.setText("");
                }
                break;
        }
    }
}
