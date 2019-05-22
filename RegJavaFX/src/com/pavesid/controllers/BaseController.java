package com.pavesid.controllers;

import com.pavesid.Main;
import com.pavesid.VAnavigation.Navigation;
import com.pavesid.interfaces.impls.DBRegistrationPerson;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;

public class BaseController implements Controller {

    private Node view;

    DBRegistrationPerson dbRegistrationPerson = new DBRegistrationPerson();
    Navigation navigation = Main.getNavigation();

    public BaseController() {

    }

    @Override
    public Node getView() {
        return view;
    }

    @Override
    public void setView (Node view){
        this.view = view;
    }

    @Override
    public void Show() {
        PreShowing();
        Main.getNavigation().Show(this);
        PostShowing();
    }

    public void PreShowing()
    {
    }

    public void PostShowing()
    {
    }

    public void showDialogToggle(ActionEvent actionEvent){
        Object source = actionEvent.getSource();

        if(!(source instanceof ToggleButton)){
            return;
        }
        ToggleButton clickBtn = (ToggleButton) source;
        switch (clickBtn.getId()){
            case "btnBack":
                Main.getNavigation().GoBack();
                break;
        }
    }

}