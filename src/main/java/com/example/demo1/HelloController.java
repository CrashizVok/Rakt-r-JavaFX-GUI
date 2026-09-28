package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.List;
import java.util.Map;

public class HelloController {

    @FXML
    private TextField input;

    @FXML
    private ListView<String> listOne;

    @FXML
    private ListView<String> listTwo;

    private final Raktar raktarKezelo = new Raktar();

    @FXML
    public void initialize() {
        try {
            Map<Integer, List<String>> adatok = raktarKezelo.betoltes();
            listOne.getItems().addAll(adatok.get(1));
            listTwo.getItems().addAll(adatok.get(2));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    protected void addRaktarEgy() {
        String szoveg = input.getText().trim();
        if (!szoveg.isEmpty()) {
            listOne.getItems().add(szoveg);
            input.setText("");
            input.requestFocus();
        }
    }

    @FXML
    protected void addRaktarKetto() {
        String szoveg = input.getText().trim();
        if (!szoveg.isEmpty()) {
            listTwo.getItems().add(szoveg);
            input.setText("");
            input.requestFocus();
        }
    }

    @FXML
    protected void athelyezEgybolKettobe() {
        int index = listOne.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            String elem = listOne.getItems().remove(index);
            listTwo.getItems().add(elem);
            listTwo.getSelectionModel().select(elem);
            listTwo.scrollTo(elem);
        }
    }

    @FXML
    protected void athelyezKettobolEgybe() {
        int index = listTwo.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            String elem = listTwo.getItems().remove(index);
            listOne.getItems().add(elem);
            listOne.getSelectionModel().select(elem);
            listOne.scrollTo(elem);
        }
    }

    @FXML
    protected void torlesEgy() {
        int index = listOne.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            listOne.getItems().remove(index);
            int ujIndex = Math.min(index, listOne.getItems().size() - 1);
            if (ujIndex >= 0) {
                listOne.getSelectionModel().select(ujIndex);
            }
        }
    }

    @FXML
    protected void torlesKetto() {
        int index = listTwo.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            listTwo.getItems().remove(index);
            int ujIndex = Math.min(index, listTwo.getItems().size() - 1);
            if (ujIndex >= 0) {
                listTwo.getSelectionModel().select(ujIndex);
            }
        }
    }

    @FXML
    protected void mentes() {
        try {
            raktarKezelo.mentes(listOne.getItems(), listTwo.getItems());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}