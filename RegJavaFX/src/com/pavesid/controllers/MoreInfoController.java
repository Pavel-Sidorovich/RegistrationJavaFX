package com.pavesid.controllers;

import com.pavesid.interfaces.impls.DBRegistrationPerson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;


public class MoreInfoController extends BaseController {

    @FXML
    private TextField textName;

    @FXML
    private TextField textSecondName;

    @FXML
    private TextField textNumber;

    private RadioButton gender;

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private TextArea areaMore;

    @FXML
    private Button btnConnect;

    private DBRegistrationPerson dbRegistrationPerson;

    @FXML
    private void showDialog(ActionEvent actionEvent) {

        gender = (RadioButton) genderGroup.getSelectedToggle();
        System.out.println(textName.getText() +
                " " + textSecondName.getText() +
                " " + textNumber.getText() +
                " " + gender.getText() +
                " " + areaMore.getText());
    }

    @FXML
    private void clickOnName(MouseEvent mouseEvent) {
        textName.requestFocus();
    }

    @FXML
    private void clickOnSecondName(MouseEvent mouseEvent) {
        textSecondName.requestFocus();
    }

    @FXML
    private void clickOnNumber(MouseEvent mouseEvent) {
        textNumber.requestFocus();
    }

    @FXML
    private void clickOnSex(MouseEvent mouseEvent) {
        male.requestFocus();
    }

    @FXML
    private void clickOnMore(MouseEvent mouseEvent) {
        areaMore.requestFocus();
    }
}
