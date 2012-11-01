/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Mark
 */
public class Person {

    private StringProperty firstName;
    private StringProperty lastName;

    public StringProperty firstNameProperty() {
        if (firstName == null) {
            firstName = new SimpleStringProperty(this, "firstName");
        }
        return firstName;
    }

    public StringProperty lastNameProperty() {
        if (lastName == null) {
            lastName = new SimpleStringProperty(this, "lastName");
        }
        return lastName;
    }

    public void setFirstName(String value) {
        firstNameProperty().setValue(value);
    }

    public void setLastName(String value) {
        lastNameProperty().setValue(value);
    }

    public String getFistName() {
        return firstNameProperty().getValue();
    }
    
    public String getFirstName(){
        return lastNameProperty().getValue();
    }
}
