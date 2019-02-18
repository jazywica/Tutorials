package _02_FormDesign;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


// The main class for a JavaFX application extends the javafx.application.Application
public class FormDesign extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER); // alignment property changes the default position of the grid from the top left of the scene to the center.
        grid.setHgap(20); // gap defines the spacing between individual rows and columns
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25)); // The padding properties ensure there is a padding around the grid pane when you make the window smaller.

        // In-line style
        grid.setStyle("-fx-background-color: #D8BFD8;");

        // First row
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1); // The last two arguments specify the range of col and row that the field has to cover

        // Second row
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1); // The text field is added to the grid pane at column 1, row 1 so its going to be to the right of the userName

        // Third row
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        // Button with layout pane named hbBtn with custom spacing (defined in pixels)
        Button btn = new Button("Sign in"); // we can first create a button and then attach it to the layout pane when its being created
        HBox hbBtn = new HBox(34, btn); // The HBox pane sets a spacing for the buttons that is different from the alignment applied to the other controls in the grid pane.
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        Button btn2 = new Button("Sign out");
        hbBtn.getChildren().add(btn2); // we can also add a button in this way
        grid.add(hbBtn, 1, 4);

        // Prompt
        final Text actiontarget = new Text(); // this is just an empty field that we are going to fill in on action
        GridPane.setHalignment(actiontarget, HPos.RIGHT); // this is the way to force an alignment for a specific item that does not a have a layout pane

        final Text actiontarget2 = new Text();
        actiontarget2.setTextAlignment(TextAlignment.RIGHT); // this does not work
        actiontarget2.setStyle("-fx-text-align: right;"); // we can do the same by the use of the in-line style

        grid.add(actiontarget, 1, 6);
        grid.add(actiontarget2, 1, 7);

        btn.setOnAction(new EventHandler<ActionEvent>() // The setOnAction() method is used to register an event handler that sets the actiontarget object to Sign in button pressed
        {
            @Override
            public void handle(ActionEvent event) {
                actiontarget.setFill(Color.FIREBRICK); // this code will only execute together with the handle (when the button is pressed)
                actiontarget.setText("Sign in button pressed");
                actiontarget2.setText("Sign in button pressed");
            }
        });

        //grid.setGridLinesVisible(true); // you can display the grid lines, which is useful for debugging purposes.

        // Getting things ready
        Scene scene = new Scene(grid, 300, 275); // If you do not set the scene dimensions, the scene defaults to the minimum size needed to display its contents.
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
