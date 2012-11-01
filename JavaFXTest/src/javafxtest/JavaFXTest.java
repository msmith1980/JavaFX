/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxml.FirstFXMLController;

/**
 *
 * @author Mark
 */
public class JavaFXTest extends Application {
    
    @Override
    public void start(final Stage primaryStage) throws Exception {
       final Parent parent;
        parent = FXMLLoader.load(FirstFXMLController.class.getResource("FirstFXML.fxml"));
       primaryStage.setScene(new Scene(parent));
       primaryStage.setTitle("Contacts FX");
       primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(JavaFXTest.class, args);
    }
}
