package _15_ToggleButton;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


// The main class for a JavaFX application extends the javafx.application.Application
public class TButton extends Application {
    // The root node contains one child node, a button control with text, plus an event handler to print a message when the button is pressed.
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Creates the stage and scene and makes the scene visible in a given pixel size.
        primaryStage.setTitle("Toggle button sample");
        final ToggleGroup group = new ToggleGroup();
        final Rectangle rect = new Rectangle(145, 50);

        ToggleButton tb1 = new ToggleButton("Minor");
        tb1.setToggleGroup(group);
        ToggleButton tb2 = new ToggleButton("Major");
        tb2.setToggleGroup(group);
        ToggleButton tb3 = new ToggleButton("Critical");
        tb3.setToggleGroup(group);
        ToggleButton tb4 = new ToggleButton("Singleton"); // here we don't assign any group just to test how we can follow a single on-off button


        // The setUserData method inherited by the ToggleButton class from the Node class helps you to associate any selected option with a particular value.
        // In this example, the user data indicates which color should be used to paint the rectangle.
        tb1.setUserData(Color.LIGHTGREEN);
        tb2.setUserData(Color.LIGHTBLUE);
        tb3.setUserData(Color.SALMON);

        // This is how we can monitor the behaviour of buttons in a group
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) {
                if (new_toggle == null)
                    rect.setFill(Color.WHITE);
                else
                    rect.setFill((Color) group.getSelectedToggle().getUserData());
            }
        });

        // This is how we can monitor a single button
        tb4.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println("the toggle property from: " + oldValue + " to: " + newValue);
            }
        });

        // Lets put it all on the screen now
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER); // alignment property changes the default position of the grid from the top left of the scene to the center.
        grid.setHgap(20); // gap defines the spacing between individual rows and columns
        grid.setVgap(10);

        HBox box1 = new HBox();
        box1.getChildren().add(tb1);
        box1.getChildren().add(tb2);
        box1.getChildren().add(tb3);

        HBox box2 = new HBox();
        box2.getChildren().add(tb4);

        grid.add(box1, 0, 0);
        grid.add(box2, 0, 1);
        grid.add(rect, 0, 2);

        // The JavaFX Scene class is the container for all content
        primaryStage.setScene(new Scene(grid, 300, 250));
        primaryStage.show();
    }
}
