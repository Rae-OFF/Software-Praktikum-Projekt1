package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class StartPageController extends BorderPane {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="buttonPatient"
    private Button buttonPatient; // Value injected by FXMLLoader

    @FXML // fx:id="buttonArzt"
    private Button buttonArzt; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert buttonPatient != null : "fx:id=\"buttonPatient\" was not injected: check your FXML file 'Start Seite.fxml'.";
        assert buttonArzt != null : "fx:id=\"buttonArzt\" was not injected: check your FXML file 'Start Seite.fxml'.";

    }

    public StartPageController(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/StartPage.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}