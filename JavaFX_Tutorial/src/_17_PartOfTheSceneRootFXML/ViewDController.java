package _17_PartOfTheSceneRootFXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import java.io.IOException;


public class ViewDController extends GridPane {

    public ViewDController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/view_d.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
