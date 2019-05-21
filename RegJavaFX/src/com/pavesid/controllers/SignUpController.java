package com.pavesid.controllers;

import com.pavesid.Main;
import com.pavesid.helper.DetectionSpecialChar;
import com.pavesid.helper.GenerateSecurePassword;
import com.pavesid.interfaces.impls.DBRegistrationPerson;
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

    private DBRegistrationPerson dbRegistrationPerson;

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
                if(DetectionSpecialChar.isMail(emailSignIn.getText())) {
                    String deffPass = GenerateSecurePassword.generatePassword(12);
                    dbRegistrationPerson.addPerson(new Person(emailSignIn.getText(), "", deffPass));
                    System.out.println(deffPass);
                    System.out.println("Тут должно отсылаться письмо");
                    Main.getNavigation().load("SignIn.fxml").Show();
                }else{
                    //Всплывающее окно, где написано, что не мэйл.
                    emailSignIn.setText("");
                }
                break;
        }
    }

}
