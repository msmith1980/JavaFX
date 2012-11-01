/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jfxml;

import data.Model.Person;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mark
 */
public class FirstFXMLController implements Initializable {

    @FXML
    private Button load;
    @FXML
    private TableView<Person> people;
    @FXML
    private AnchorPane host;

    @FXML
    protected void handleLoadAction(ActionEvent e) {
        people.setItems(peopleList);
        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
        firstNameCol.setPrefWidth(90);
        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));
        lastNameCol.setPrefWidth(85);
        people.getColumns().setAll(firstNameCol, lastNameCol);
    }
    private ObservableList<Person> peopleList = getPeople();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }

    private ObservableList<Person> getPeople() {

        List<Person> pList = new ArrayList<>();

        //Replace with objects from db
        Person p1 = new Person();
        p1.setFirstName("Mark");
        p1.setLastName("Smith");

        pList.add(p1);
        
        Person p2 = new Person();
        p2.setFirstName("Sue");
        p2.setLastName("Smith");
        
        pList.add(p2);

        ObservableList<Person> obList = FXCollections.observableList(pList);

        return obList;

    }
}
