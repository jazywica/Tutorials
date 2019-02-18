package _16_PartOfTheSceneFXML;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import java.io.IOException;

public class ScenePartController {

    @FXML
    private BorderPane mainView;

    @FXML
    private void handleChangeView(ActionEvent event) {
        try {
            String menuItemID = ((MenuItem) event.getSource()).getId();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml\\" + menuItemID + ".fxml"));
            loader.setController(this);

            mainView.setCenter(loader.load());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void closeApp(){
        Platform.exit();
    }
}
