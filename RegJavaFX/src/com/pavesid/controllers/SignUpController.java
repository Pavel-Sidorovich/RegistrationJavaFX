package com.pavesid.controllers;

import com.pavesid.Main;
import com.pavesid.helper.AlertWindow;
import com.pavesid.helper.DetectionSpecialChar;
import com.pavesid.helper.GenerateSecurePassword;
import com.pavesid.mail.SendEmail;
import com.pavesid.objects.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SignUpController  extends BaseController {
    @FXML
    private Button btnSignIn;

    @FXML
    private Button btnNewSignIn;

    @FXML
    private TextField emailSignIn;

    //private DBRegistrationPerson dbRegistrationPerson;

    public void showDialog(ActionEvent actionEvent){
        Object source = actionEvent.getSource();

        if(!(source instanceof Button)){
            return;
        }
        Button clickBtn = (Button) source;
        switch (clickBtn.getId()){
            case "btnSignIn":
                Main.getNavigation().load("SignIn.fxml").Show();
                break;
            case "btnNewSignIn":
                String email = emailSignIn.getText();
                if(DetectionSpecialChar.isMail(email)) {
                    String defPass = GenerateSecurePassword.generatePassword(12);
                    dbRegistrationPerson.addPerson(new Person(email, "", defPass));
                    SendEmail.send(email, defPass);
                    Main.getNavigation().load("EmailSend.fxml").Show();
                }else{
                    //Всплывающее окно, где написано, что не мэйл.
                    AlertWindow.showAlert("It doesn't look like email");
                    emailSignIn.setText("");
                }
                break;
        }
    }

}
