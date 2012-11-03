/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jfxml;

import data.Model.Person;
import data.Model.dataAccess.PersonRepository;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;

/**
 * FXML Controller class
 *
 * @author Mark
 */
public class FirstFXMLController implements Initializable {

    String valueFromText;
    
    private PersonRepository repository;
    @FXML
    private Button load;
    @FXML
    private TableView<Person> people;
    @FXML
    private AnchorPane host;
    @FXML
    private WebView localWeb;
    private WebEngine localWebEngine;

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
        repository = new PersonRepository();
        localWebEngine = localWeb.getEngine();

        localWebEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends State> ov, State t, State t1) {
                if (t1 == Worker.State.SUCCEEDED) {

                    JSObject window = (JSObject) localWebEngine.executeScript("window");
                    window.setMember("app", new Web());
                    // note next classes are from org.w3c.dom domain
                    EventListener listener;
                    listener = new EventListener() {
                        @Override
                        public void handleEvent(Event evt) {
                            JSObject window = (JSObject) localWebEngine.executeScript("window");
                            window.setMember("app", new Web());

                            Object value = localWebEngine.executeScript("getText()");
                            System.out.print(valueFromText);
                        }
                    };

                    //Document doc = localWebEngine.getDocument();
                    //Element el;
                    //el = doc.getElementById("datepicker");
                    //((EventTarget) el).addEventListener("change", listener, false);
                }
            }
        });



        URL page = getClass().getResource("helloHtml.html");
        localWebEngine.load(page.toExternalForm());

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

    public class Web {

        public void getMessage(String msg) {
            valueFromText = msg;
        }
    }
}
