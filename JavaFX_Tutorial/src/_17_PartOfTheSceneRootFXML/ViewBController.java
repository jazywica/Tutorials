package _17_PartOfTheSceneRootFXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import java.io.IOException;


public class ViewBController extends VBox {

    public ViewBController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/view_b.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
