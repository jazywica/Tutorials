package _17_PartOfTheSceneRootFXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import java.io.IOException;

// The controller type must extend the FXML's root type
public class ViewAController extends VBox {

    public ViewAController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/view_a.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
