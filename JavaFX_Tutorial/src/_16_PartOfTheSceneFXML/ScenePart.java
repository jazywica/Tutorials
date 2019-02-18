package _16_PartOfTheSceneFXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ScenePart extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent Root = FXMLLoader.load(getClass().getResource("fxml/view_main.fxml"));
        Scene scene = new Scene(Root);
        stage.setScene(scene);
        stage.show();
    }
}
