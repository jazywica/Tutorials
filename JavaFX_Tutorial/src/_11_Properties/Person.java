package _11_Properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class Person {

    // The StringProperty class is is abstract so if we want to get a writable object we have to use SimpleStringProperty with the name and a default value
    private StringProperty firstName = new SimpleStringProperty(this, "First Name", "Bobby");
    private StringProperty lastName = new SimpleStringProperty(this, "Last Name", "Dean");
    private IntegerProperty age = new SimpleIntegerProperty(this, "Age", 1);
    private IntegerProperty prickles = new SimpleIntegerProperty(this, "Pickles", 10);

    public Person() {
        // This is an example of BINDING
        this.prickles.bind(age.multiply(10)); // note that we bind prickles with age therefore we don't need any setters for prickles
    }

    // Returns the StringProperty object itself
    public StringProperty firstNameProperty() {
        return firstName;
    }

    // Return the firstName value (ie. "Bucky")
    public String getFirstName() {
        return firstName.get();
    }

    // Set the firstName value
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    // Same thing for the last name
    public String getLastName() {
        return lastName.get();
    }
    public StringProperty lastNameProperty() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    // Same thing for the integer age
    public IntegerProperty ageProperty() { return age; }
    public int getAge() { return age.get(); }
    public void setAge(int age) { this.age.set(this.age.get() + age); }

    // We only need a getter when it comes to prickles, as it is bind with age
    public int getPrickles() {return prickles.get();}

    // Function to intercept the changes made to person's age
    public void doItWithFunction(ObservableValue o, String oldValue, String newValue){
        System.out.println("Last Name changed from: " + oldValue + " to: " + newValue);
        System.out.println("lastNameProperty(): " + o);
        System.out.println("getLastName(): " + lastName.get());
        System.out.println();
    }
}
