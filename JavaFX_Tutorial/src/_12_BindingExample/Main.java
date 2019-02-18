package _12_BindingExample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    ObservableList<Person> obsList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("New window");

        // 1. Self-Updating Labels
        Label name = new Label("Please enter your name:");
        TextField userInput = new TextField();
        userInput.setMaxWidth(200);
        Label firstLabel = new Label("Welcome to the site ");
        Label secondLabel = new Label(); // this is an empty label in which we are going to show the bound input in

        HBox bottomText = new HBox(firstLabel, secondLabel);
        bottomText.setAlignment(Pos.CENTER);
        VBox vb = new VBox(10, name, userInput, bottomText);
        vb.setAlignment(Pos.CENTER);

        // In order to bind the label we need to get the properties on it, hence '.textProperty()'
        secondLabel.textProperty().bind(userInput.textProperty());

        // 2. Observing changes in a list
        obsList = FXCollections.observableArrayList();
        Label listItems = new Label("Add elements to the list:");
        TextField nameInput = new TextField();
        nameInput.setMaxWidth(200);
        TextField ageInput = new TextField();
        ageInput.setMaxWidth(200);
        Button addButton = new Button("Add Element");
        Button deleteButton = new Button("Delete Element");

        // this code will add elements to our list
        addButton.setOnAction(x -> {
            obsList.add(new Person(nameInput.getText(),Integer.getInteger(ageInput.getText())));
        });
        deleteButton.setOnAction(x -> {
            obsList.remove(x); // this will simply remove the first element, as all we need is to observe the change in the List
        });

        // this will listen for changes made on it
        obsList.addListener((ListChangeListener.Change<? extends Person> change) -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    change.getAddedSubList().stream().forEach(t -> System.out.println("addition was made, item added: " + t.Name));
//                    this.entries.addAll(change.getAddedSubList());
                }
                if (change.wasRemoved()) {
                    change.getRemoved().stream().forEach(t -> System.out.println("deletion was made, item deleted:" + t.Name));
//                    this.entries.removeAll(change.getRemoved());
//                    change.getRemoved().stream().forEach(t -> this.getChildren().remove(t));
                }
            }
            nameInput.clear();
            ageInput.clear();
        });

        vb.getChildren().add(listItems);
        vb.getChildren().add(nameInput);
        vb.getChildren().add(ageInput);
        vb.getChildren().add(addButton);
        vb.getChildren().add(deleteButton);

        Scene scene = new Scene(vb, 300, 300);
        window.setScene(scene);
        window.show();
    }
}
