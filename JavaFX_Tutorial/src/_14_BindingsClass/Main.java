package _14_BindingsClass;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
Using the High-Level Binding API
The High-Level API is the quickest and easiest way to begin using bindings in your own applications. It consists of two parts:
the Fluent API, and the Bindings class. The Fluent API exposes methods on the various dependency objects, whereas the Bindings class provides static factory methods instead.

The binding API defines a set of interfaces that enable objects to be notified when a value change or invalidation takes place.
The Observable and ObservableValue interfaces fire the change notifications, and the InvalidationListener and ChangeListener interfaces receive them.
The difference between the two is that ObservableValue wraps a value and fires its changes to any registered ChangeListener,
whereas Observable (which does not wrap a value) fires its changes to any registered InvalidationListener.
 */

public class Main {

    private static String handleStringBuilder(StringProperty s, IntegerProperty i){
        String reply = s.getValue() + i.getValue().toString();
        // The advantage of having a method handler is that we can a message each time an event happens
        System.out.println("Automatic reply in the background: The variable has changed");
        return reply;
    }

    public static void main(String[] args) {

        // Fluent API, consider a simple use case in which two integers are bound so that their values are always added together.
        IntegerProperty num1 = new SimpleIntegerProperty(1);
        IntegerProperty num2 = new SimpleIntegerProperty(2);
        NumberBinding sum = num1.add(num2); // The dependency types are both IntegerProperty, and the binding itself is NumberBinding.
        System.out.println(sum.getValue());
        // Now we change the value of 'num1' so we can test if the binding works automatically
        num1.set(2);
        System.out.println(sum.getValue());
        System.out.println();

        // You could also use the Bindings class to do the same thing
        IntegerProperty num3 = new SimpleIntegerProperty(1);
        IntegerProperty num4 = new SimpleIntegerProperty(2);
        NumberBinding sum2 = Bindings.add(num3,num4);
        System.out.println(sum2.getValue());
        num3.setValue(2);
        System.err.println(sum2.getValue());

        // You could also use the createStringBinding to sorm a string from many inputs on a CHANGE OF AN OBSERVABLE
        StringProperty str1 = new SimpleStringProperty("hello user number ");
        IntegerProperty num5 = new SimpleIntegerProperty(1);
        String test = str1.getValue() + num5.getValue().toString();
        StringBinding sum3 = Bindings.createStringBinding(()-> str1.getValue() + num5.getValue().toString(), num5);
        System.out.println(sum3.getValue());
        num5.setValue(5); // this changed the bound string but since we didn't call it, we won't see it
        num5.setValue(10);
        System.err.println(sum3.getValue());

        IntegerProperty num6 = new SimpleIntegerProperty(1);
        StringBinding sum4 = Bindings.createStringBinding(() -> handleStringBuilder(str1, num6), num6);
        sum4.getDependencies();
        num6.setValue(5);
        num6.setValue(10);
        num6.setValue(15);
        System.err.println(sum4.getValue());


        // THE BILL EXAMPLE
        // The JavaFX binding and property implementations all support lazy evaluation, which means that when a change occurs,
        // the value is not immediately recomputed. Recomputation happens later, if and when the value is subsequently requested.
        Bill bill1 = new Bill();
        Bill bill2 = new Bill();
        Bill bill3 = new Bill();

        // the bill total (a binding) will be marked as invalid the first time it detects a change in one of its dependencies.
        // However, the binding object will recalculate itself only if the total is actually requested again.
        NumberBinding total = Bindings.add(bill1.amountDueProperty().add(bill2.amountDueProperty()), bill3.amountDueProperty());
        total.addListener(new InvalidationListener() {
            @Override public void invalidated(Observable o) {
                System.out.println("The binding is now invalid.");
            }
        });

        // First call makes the binding invalid - the invalidation listener will fire
        bill1.setAmountDue(200.00);

        // The binding is already invalid - the invalidation listener will not fire again, even if another bill changes
        bill2.setAmountDue(100.00);
        bill3.setAmountDue(75.00);

        // Make the binding valid...
        System.out.println(total.getValue());

        // Make invalid...
        bill3.setAmountDue(150.00);

        // Make valid...
        System.out.println(total.getValue());
    }
}
