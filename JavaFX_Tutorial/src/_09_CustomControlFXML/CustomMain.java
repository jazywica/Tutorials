package _09_CustomControlFXML;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CustomMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Create an instance of the CustomControl class and specify the text for the custom control
        CustomControl customControl = new CustomControl(); // this will initialize the FXML loader and set all things up
        customControl.setText("Hello!");

        Scene scene = new Scene(customControl);
        stage.setScene(scene);
        stage.setTitle("Custom Control");
        stage.setWidth(300);
        stage.setHeight(200);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
