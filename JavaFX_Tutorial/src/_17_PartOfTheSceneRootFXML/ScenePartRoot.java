package _17_PartOfTheSceneRootFXML;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ScenePartRoot extends Application {

    @Override
    public void start(Stage stage) {

        // Here we initialize the main controller
        ScenePartRootController mainControl = new ScenePartRootController();
        stage.setScene(new Scene(mainControl));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
