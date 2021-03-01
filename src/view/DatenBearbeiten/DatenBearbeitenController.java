package view.DatenBearbeiten;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class DatenBearbeitenController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="pVorname"
    private TextField pVorname; // Value injected by FXMLLoader

    @FXML // fx:id="pNachname"
    private TextField pNachname; // Value injected by FXMLLoader

    @FXML // fx:id="pBday"
    private DatePicker pBday; // Value injected by FXMLLoader

    @FXML // fx:id="pIsmale"
    private RadioButton pIsmale; // Value injected by FXMLLoader

    @FXML // fx:id="sex"
    private ToggleGroup sex; // Value injected by FXMLLoader

    @FXML // fx:id="pIsfemale"
    private RadioButton pIsfemale; // Value injected by FXMLLoader

    @FXML // fx:id="pAdress"
    private TextArea pAdress; // Value injected by FXMLLoader

    @FXML // fx:id="pSetnum"
    private TextField pSetnum; // Value injected by FXMLLoader

    @FXML // fx:id="pAnum"
    private TextField pAnum; // Value injected by FXMLLoader

    @FXML // fx:id="pSetpass"
    private TextField pSetpass; // Value injected by FXMLLoader

    @FXML // fx:id="neuPatient"
    private Button neuPatient; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert pVorname != null : "fx:id=\"pVorname\" was not injected: check your FXML file 'DatenBearbeiten.fxml'.";
        assert pNachname != null : "fx:id=\"pNachname\" was not injected: check your FXML file 'DatenBearbeiten.fxml'.";
        assert pBday != null : "fx:id=\"pBday\" was not injected: check your FXML file 'DatenBearbeiten.fxml'.";
        assert pIsmale != null : "fx:id=\"pIsmale\" was not injected: check your FXML file 'DatenBearbeiten.fxml'.";
        assert sex != null : "fx:id=\"sex\" was not injected: check your FXML file 'DatenBearbeiten.fxml'.";
        assert pIsfemale != null : "fx:id=\"pIsfemale\" was not injected: check your FXML file 'DatenBearbeiten.fxml'.";
        assert pAdress != null : "fx:id=\"pAdress\" was not injected: check your FXML file 'DatenBearbeiten.fxml'.";
        assert pSetnum != null : "fx:id=\"pSetnum\" was not injected: check your FXML file 'DatenBearbeiten.fxml'.";
        assert pAnum != null : "fx:id=\"pAnum\" was not injected: check your FXML file 'DatenBearbeiten.fxml'.";
        assert pSetpass != null : "fx:id=\"pSetpass\" was not injected: check your FXML file 'DatenBearbeiten.fxml'.";
        assert neuPatient != null : "fx:id=\"neuPatient\" was not injected: check your FXML file 'DatenBearbeiten.fxml'.";

    }
}
