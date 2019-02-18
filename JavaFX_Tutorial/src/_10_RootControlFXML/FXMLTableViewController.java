package _10_RootControlFXML;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class FXMLTableViewController extends GridPane {

    @FXML private TableView<Person> tableView;

    //Fields for initializing a table with JavaFX
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> secondNameColumn;

    // Fields for adding a row to the table
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField emailField;

    private ObservableList<Person> data;

    public FXMLTableViewController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml_tableview.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    // This is one way of initializing data - with 'initialize()' method that is called when FXMLLoader starts, it will disable the items declared inside the FXML code
    @FXML private void initialize() {
        data = FXCollections.observableArrayList(
                new Person("Jacob", "Smith", "jacob.smith@exampleJAVAFX.com"),
                new Person("Isabella", "Johnson", "isabella.johnson@exampleJAVAFX.com"),
                new Person("Ethan", "Williams", "ethan.williams@exampleJAVAFX.com"),
                new Person("Emma", "Jones", "emma.jones@exampleJAVAFX.com"));

//        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("First Name"));
//        secondNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("Last Name"));
//        Active.setCellValueFactory(new PropertyValueFactory<User, String>("active"));

        tableView.getItems().setAll(data);
    }

    // This Method is only for adding new elements, works with both JavaFX and FXML methods
    @FXML
    protected void addPerson(ActionEvent event) {
        ObservableList<Person> data = tableView.getItems();
        data.add(new Person(firstNameField.getText(), lastNameField.getText(), emailField.getText()));

        // Clearing the input fields after population is over
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
    }
}
