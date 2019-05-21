//package com.pavesid.controllers;
//
//import com.pavesid.interfaces.impls.CollectionRegistrationBook;
//import com.pavesid.objects.Person;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//public class TableController{
//    private CollectionRegistrationBook book = new CollectionRegistrationBook();
//
//    @FXML
//    private Button connectSignIn;
//
//    @FXML
//    private TextField emailSignIn;
//
//    @FXML
//    private PasswordField passwordSignIn;
//
//    @FXML
//    private TableColumn<Person, String> columnFio;
//
//    @FXML
//    private TableColumn<Person, String> columnPhone;
//
//    @FXML
//    private TableView table;
//
//    void read(){
//        emailSignIn.getText();
//    }
//
//    @FXML
//    private void initialize(){
//        columnFio.setCellValueFactory(new PropertyValueFactory<>("fio"));
//        columnPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
//
//        book.fillTest();
//
//        table.setItems(book.getPersonList());
//        book.print();
//    }
//
//    public void showDialog(ActionEvent actionEvent){
//        Object source = actionEvent.getSource();
//
//        if(!(source instanceof Button)){
//            return;
//        }
//        Button clickBtn = (Button) source;
//
//        switch (clickBtn.getId()){
//            case "connectSignIn":
//                Person p = new Person(emailSignIn.getText(), passwordSignIn.getText());
//                book.add(p);
//                break;
//        }
//    }
//}
