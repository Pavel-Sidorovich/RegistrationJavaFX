package com.pavesid.helper;

import javafx.scene.control.Alert;

public class AlertWindow {
    public static void showAlert(String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(text);

        alert.showAndWait();
    }
}
