package _09_CustomControlFXML;

import java.io.IOException;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

// In this example, the CustomControl class extends the VBox class (the type declared by the <fx:root> element), and sets itself as both the root and controller of the FXML document in its constructor.
// When the document is loaded, the contents of the CustomControl instance will be populated with the contents of the document.
public class CustomControl extends VBox {
    @FXML private TextField textField;

    public CustomControl() {
        // In order for the root to work we have to instantiate a FXML Loader
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("custom_control.fxml"));

        // Now we are able to set the ROOT and the CONTROLLER for the FXML layout (We don't do this inside FXML code when working with roots)
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        // Now it is enough to load the loader
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public String getText() {
        return textProperty().get();
    }

    public void setText(String value) {
        textProperty().set(value);
    }

    public StringProperty textProperty() {
        return textField.textProperty();
    }

    @FXML
    public void doSomething() {
        System.out.println("The button was clicked!");
    }
}


