package com.pavesid.controllers;

import com.pavesid.Main;
import com.pavesid.helper.AlertWindow;
import com.pavesid.helper.DetectionSpecialChar;
import com.pavesid.helper.GenerateSecurePassword;
import com.pavesid.interfaces.impls.DBRegistrationPerson;
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

    private DBRegistrationPerson dbRegistrationPerson;

    public void recoveryPass(){

                if(DetectionSpecialChar.isMail(emailForgotPass.getText())) {
                    String defPass = GenerateSecurePassword.generatePassword(12);
                    //Insert new Def password
                    System.out.println(defPass);
                    if(true){                        //Письмо успешно ушло)
                        Main.getNavigation().load("EmailSent.fxml").Show();
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
