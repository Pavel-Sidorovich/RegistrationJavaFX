package com.pavesid.controllers;

import com.pavesid.helper.AlertWindow;
import com.pavesid.interfaces.impls.DBRegistrationPerson;
import com.pavesid.objects.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class MoreInfoController extends BaseController {

    @FXML
    private TextField textName;

    @FXML
    private Label labelName;

    @FXML
    private Button btnConnect;

    private DBRegistrationPerson dbRegistrationPerson;

    public void showDialog(ActionEvent actionEvent) {
        labelName.setLabelFor(textName);
        labelName.setLabelFor(textName);
    }

    public void show(ActionEvent actionEvent) {
        labelName.setLabelFor(textName);
    }
}
