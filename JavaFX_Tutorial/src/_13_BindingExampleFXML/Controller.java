package _13_BindingExampleFXML;

import javafx.fxml.Initializable;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");
    }


//    public void handleButtonClick(){
//        System.out.println("Run some code that the user doesn't see");
//        button.setText("Stop touching me");
//    }
}
