package _10_RootControlFXML;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FXMLTableView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Note that the Java file does not contain the code for the scene
        primaryStage.setTitle("FXML TableView Example");

        // Create an instance of the CustomControl class and specify the text for the custom control
        FXMLTableViewController customControl = new FXMLTableViewController(); // this will initialize the FXML loader and set all things up

        primaryStage.setScene(new Scene(customControl));
        primaryStage.setTitle("Custom Control");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
