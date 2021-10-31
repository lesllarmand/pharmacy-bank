package com.example.proiectbanca;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class HelloController {

    @FXML
    void onButtonClickClient(ActionEvent event) {
    }

    @FXML
    void onButtonClickFISC(ActionEvent event) {

    }

    public void onButtonClickClient(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent NewCustomer = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/clientLoginRegister_PAGE.fxml")));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();

    }

    public void onButtonClickFISC(javafx.event.ActionEvent actionEvent) {
    }
}