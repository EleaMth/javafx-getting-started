package org.openjfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MyHeader extends VBox {

    public MyHeader() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("my_header.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}


