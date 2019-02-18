package _11_Properties;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Button button1;
    Button button2;
    Button button3;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("New window");

        Person bucky = new Person();

        // StringProperty allows us to use Listeners, therefore we can set up a handler for any changes that happen to it
        bucky.firstNameProperty().addListener( (o, oldValue, newValue) -> {
            System.out.println("First Name changed from: " + oldValue + " to: " + newValue);
            System.out.println("firstNameProperty(): " + bucky.firstNameProperty());
            System.out.println("getFirstName(): " + bucky.getFirstName());
            System.out.println();
        });

        bucky.lastNameProperty().addListener((o, oldValue, newValue) -> bucky.doItWithFunction(o, oldValue, newValue));

        bucky.ageProperty().addListener((o, oldValue, newValue) -> {
            System.out.println("Age changed from: " + oldValue + " to: " + newValue);
            System.out.println("age Property(): " + o);
            System.out.println("the amount of prickles is now: " + bucky.getPrickles());
            System.out.println();
        });

        button1 = new Button("Change First Name");
        button1.setOnAction(e -> bucky.setFirstName("Porky"));

        button2 = new Button("Change Last Name");
        button2.setOnAction(e -> bucky.setLastName("Pie"));

        button3 = new Button("Add age");
        button3.setOnAction(e -> bucky.setAge(1));

        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(button1);
        layout.getChildren().add(button2);
        layout.getChildren().add(button3);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
