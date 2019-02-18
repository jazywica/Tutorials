package _17_PartOfTheSceneRootFXML;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Here we have to reference the same data type as it is defined inside the FXML root
public class ScenePartRootController extends GridPane {
    @FXML private TabPane firstView; // this is a handle for manipulating the tab pane in FXML
    @FXML private VBox secondView; // same for the second view, but there we operate more on the controller (root) itself
//    @FXML private ViewAController viewAController; // these two are not really necessary as we are not addressing them in the code below
//    @FXML private ViewBController viewBController;
    @FXML private ViewCController viewC; // here we address the controllers directly via its name which is defined inside the main_view FXML
    @FXML private ViewDController viewD;

    public ScenePartRootController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/view_main.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    // This is one way of initializing data - with 'initialize()' method that is called when FXMLLoader starts, it will disable the items declared inside the FXML code
    @FXML private void initialize() {
    }

    @FXML
    private void handleChangeViewTabs(ActionEvent event) {
        Map<String, Integer> keymap = new HashMap<String, Integer>() {{
            put("view_a", 0);
            put("view_b", 1);
        }};

        String menuItemID = ((MenuItem) event.getSource()).getId();
        firstView.getSelectionModel().select(keymap.get(menuItemID));
    }

    @FXML
    private void handleChangeViewVisibility(ActionEvent event) {
        String menuItemID = ((MenuItem) event.getSource()).getId();
        if("view_c".equals(menuItemID)) {
            viewD.setVisible(false);
            viewC.setVisible(true);
        }
        else{
            viewC.setVisible(false);
            viewD.setVisible(true);
        }
    }

    @FXML
    private void closeApp(){
        Platform.exit();
    }
}
