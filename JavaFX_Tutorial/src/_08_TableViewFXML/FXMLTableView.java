package _08_TableViewFXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLTableView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Note that the Java file does not contain the code for the scene
        primaryStage.setTitle("FXML TableView Example");

        // Pane (subclass of Region, Parent, Node) as Scene is also a container (since widgets like Button) get added to it, rather than to Scene. Apparently Pane handles layout and Scene does not.
        Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("fxml_tableview.fxml"));
        Node n = myPane.getChildren().get(1); // this is how the table looks like when t is passed to the scene

        Scene myScene = new Scene(myPane);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
