package view.Revision;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class RevisionsController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="reviewBackButton"
    private Button reviewBackButton; // Value injected by FXMLLoader

    @FXML // fx:id="reviewOutput"
    private ListView<String> reviewOutput; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert reviewBackButton != null : "fx:id=\"reviewBackButton\" was not injected: check your FXML file 'Revision.fxml'.";
        assert reviewOutput != null : "fx:id=\"reviewOutput\" was not injected: check your FXML file 'Revision.fxml'.";

    }
}
