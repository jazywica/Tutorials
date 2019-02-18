package _01_helloworld;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


// The main class for a JavaFX application extends the javafx.application.Application
public class HelloWorld extends Application {
    // The root node contains one child node, a button control with text, plus an event handler to print a message when the button is pressed.
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) // The start() method is the main entry point for all JavaFX applications.
    {
        // Creates the stage and scene and makes the scene visible in a given pixel size.
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        // StackPane object is a resizable layout node. This means that the root node's size tracks the scene's size and changes when the stage is resized by a user.
        StackPane root = new StackPane();
        // The root node contains one child node, a button control with text, plus an event handler to print a message when the button is pressed.
        root.getChildren().add(btn);

        // The JavaFX Scene class is the container for all content
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
