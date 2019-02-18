package _17_PartOfTheSceneRootFXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import java.io.IOException;


public class ViewCController extends TableView {

    public ViewCController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/view_c.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
