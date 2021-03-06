package com.pavesid.controllers;

import com.pavesid.Main;
import com.pavesid.helper.AlertWindow;
import com.pavesid.helper.DetectionSpecialChar;
import com.pavesid.helper.GenerateSecurePassword;
import com.pavesid.interfaces.impls.DBRegistrationPerson;
import com.pavesid.mail.SendEmail;
import com.pavesid.objects.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PasswordRecoveryController extends BaseController {

    @FXML
    private Button btnRecoveryPass;

    @FXML
    private TextField emailForgotPass;

    public void recoveryPass(){

        String email = emailForgotPass.getText();
                if(DetectionSpecialChar.isMail(emailForgotPass.getText())) {
                    //Insert new Def password
                    if(true){                        //Письмо успешно ушло)
                        String defPass = GenerateSecurePassword.generatePassword(12);
                        System.out.println(defPass);
                        dbRegistrationPerson.updateDefPassPerson(new Person(email, "", defPass));
                        SendEmail.send(email, defPass);
                        Main.getNavigation().load("EmailSend.fxml").Show();
                    } else {
                        System.out.println("Error");
                    }
                }else{
                    //Всплывающее окно, где написано, что не мэйл.
                    AlertWindow.showAlert("It doesn't look like email");
                    emailForgotPass.setText("");
                }

    }

}
