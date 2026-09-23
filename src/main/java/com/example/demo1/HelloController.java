package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Objects;

public class HelloController {
    @FXML
    private TextField input;

    @FXML
    ObservableList<String> items = FXCollections.observableArrayList();
    private ListView<String> list = new ListView<>(items);


    @FXML
    protected boolean checkAvailable(){
        return !Objects.equals(input.getText(), "");
    }

    @FXML
    protected void addRaktarEgy() {
        if (checkAvailable()){
            Raktar storage = new Raktar();
            storage.setItem(input.getText());
            System.out.println(storage.getItem());
        }
    }

    @FXML
    protected void addRaktarKetto(){
        if (checkAvailable()){
            Raktar storage = new Raktar();
            storage.setItem(input.getText());
            System.out.println(storage.getItem());
        }
    }
}