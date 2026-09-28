package com.example.demo1;

import javafx.application.Platform;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class ControllerTest {

    @BeforeClass
    public static void initToolkit() {
        Platform.startup(() -> {});
    }

    private HelloController createController(TextField input, ListView<String> listOne, ListView<String> listTwo) throws Exception {
        HelloController controller = new HelloController();
        setField(controller, "input", input);
        setField(controller, "listOne", listOne);
        setField(controller, "listTwo", listTwo);
        return controller;
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    @Test
    public void testAddRaktarEgy() throws Exception {
        TextField input = new TextField();
        ListView<String> listOne = new ListView<>();
        ListView<String> listTwo = new ListView<>();
        HelloController controller = createController(input, listOne, listTwo);

        input.setText("asd");
        controller.addRaktarEgy();

        assertEquals(1, listOne.getItems().size());
        assertEquals("asd", listOne.getItems().getFirst());
        assertEquals("", input.getText());
    }

    @Test
    public void testAddRaktarKetto() throws Exception {
        TextField input = new TextField();
        ListView<String> listOne = new ListView<>();
        ListView<String> listTwo = new ListView<>();
        HelloController controller = createController(input, listOne, listTwo);

        input.setText("asd");
        controller.addRaktarKetto();

        assertEquals(1, listTwo.getItems().size());
        assertEquals("asd", listTwo.getItems().get(0));
        assertEquals("", input.getText());
    }

    @Test
    public void testAthelyezEgybolKettobe() throws Exception {
        TextField input = new TextField();
        ListView<String> listOne = new ListView<>();
        ListView<String> listTwo = new ListView<>();
        HelloController controller = createController(input, listOne, listTwo);

        listOne.getItems().add("asd");
        listOne.getSelectionModel().select(0);

        controller.athelyezEgybolKettobe();

        assertTrue(listOne.getItems().isEmpty());
        assertEquals(1, listTwo.getItems().size());
        assertEquals("asd", listTwo.getItems().getFirst());
    }

    @Test
    public void testAthelyezKettobolEgybe() throws Exception {
        TextField input = new TextField();
        ListView<String> listOne = new ListView<>();
        ListView<String> listTwo = new ListView<>();
        HelloController controller = createController(input, listOne, listTwo);

        listTwo.getItems().add("asd");
        listTwo.getSelectionModel().select(0);

        controller.athelyezKettobolEgybe();

        assertTrue(listTwo.getItems().isEmpty());
        assertEquals(1, listOne.getItems().size());
        assertEquals("asd", listOne.getItems().get(0));
    }

    @Test
    public void testTorlesEgy() throws Exception {
        TextField input = new TextField();
        ListView<String> listOne = new ListView<>();
        ListView<String> listTwo = new ListView<>();
        HelloController controller = createController(input, listOne, listTwo);

        listOne.getItems().add("asd");
        listOne.getSelectionModel().select(0);

        controller.torlesEgy();

        assertTrue(listOne.getItems().isEmpty());
    }

    @Test
    public void testTorlesKetto() throws Exception {
        TextField input = new TextField();
        ListView<String> listOne = new ListView<>();
        ListView<String> listTwo = new ListView<>();
        HelloController controller = createController(input, listOne, listTwo);

        listTwo.getItems().add("asd");
        listTwo.getSelectionModel().select(0);

        controller.torlesKetto();

        assertTrue(listTwo.getItems().isEmpty());
    }

    @Test
    public void testMentesEsInitialize() throws Exception {
        TextField input = new TextField();
        ListView<String> listOne = new ListView<>();
        ListView<String> listTwo = new ListView<>();
        HelloController controller = createController(input, listOne, listTwo);

        listOne.getItems().add("asd1");
        listTwo.getItems().add("asd2");

        controller.mentes();

        listOne.getItems().clear();
        listTwo.getItems().clear();

        controller.initialize();

        assertEquals(1, listOne.getItems().size());
        assertEquals("asd1", listOne.getItems().getFirst());
        assertEquals(1, listTwo.getItems().size());
        assertEquals("asd2", listTwo.getItems().getFirst());
    }
}