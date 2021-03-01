package view.`zusammenfassung der Behandlungsschritt`
/**
 * Sample Skeleton for 'Seite von Zusammenfassung.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.text.TextFlow;


public class Zusammenfassung {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="pDaten"
    private TextFlow pDaten; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert pDaten != null : "fx:id=\"pDaten\" was not injected: check your FXML file 'Seite von Zusammenfassung.fxml'.";

    }
}
