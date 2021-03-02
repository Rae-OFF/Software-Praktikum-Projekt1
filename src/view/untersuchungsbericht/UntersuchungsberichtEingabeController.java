package view.untersuchungsbericht;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UntersuchungsberichtEingabeController {


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="untersuchungsberichtDatum"
    private TextField untersuchungsberichtDatum; // Value injected by FXMLLoader

    @FXML // fx:id="untersuchungsberichtUhrzeit"
    private TextField untersuchungsberichtUhrzeit; // Value injected by FXMLLoader

    @FXML // fx:id="untersuchungsberichtVersicherungsnummer"
    private TextField untersuchungsberichtVersicherungsnummer; // Value injected by FXMLLoader

    @FXML // fx:id="untersuchungsberichtSymptome"
    private TextField untersuchungsberichtSymptome; // Value injected by FXMLLoader

    @FXML // fx:id="untersuchungsberichtICD"
    private TextField untersuchungsberichtICD; // Value injected by FXMLLoader

    @FXML // fx:id="untersuchungsberichtBehandlung"
    private TextField untersuchungsberichtBehandlung; // Value injected by FXMLLoader

    @FXML // fx:id="untersuchungsberichtMedikamente"
    private TextField untersuchungsberichtMedikamente; // Value injected by FXMLLoader

    @FXML // fx:id="untersuchungsberichtNotesField"
    private TextField untersuchungsberichtNotesField; // Value injected by FXMLLoader

    @FXML // fx:id="untersuchungsberichtSaveButton"
    private Button untersuchungsberichtSaveButton; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert untersuchungsberichtDatum != null : "fx:id=\"untersuchungsberichtDatum\" was not injected: check your FXML file 'model.Untersuchungsbericht eingabe.fxml'.";
        assert untersuchungsberichtUhrzeit != null : "fx:id=\"untersuchungsberichtUhrzeit\" was not injected: check your FXML file 'model.Untersuchungsbericht eingabe.fxml'.";
        assert untersuchungsberichtVersicherungsnummer != null : "fx:id=\"untersuchungsberichtVersicherungsnummer\" was not injected: check your FXML file 'model.Untersuchungsbericht eingabe.fxml'.";
        assert untersuchungsberichtSymptome != null : "fx:id=\"untersuchungsberichtSymptome\" was not injected: check your FXML file 'model.Untersuchungsbericht eingabe.fxml'.";
        assert untersuchungsberichtICD != null : "fx:id=\"untersuchungsberichtICD\" was not injected: check your FXML file 'model.Untersuchungsbericht eingabe.fxml'.";
        assert untersuchungsberichtBehandlung != null : "fx:id=\"untersuchungsberichtBehandlung\" was not injected: check your FXML file 'model.Untersuchungsbericht eingabe.fxml'.";
        assert untersuchungsberichtMedikamente != null : "fx:id=\"untersuchungsberichtMedikamente\" was not injected: check your FXML file 'model.Untersuchungsbericht eingabe.fxml'.";
        assert untersuchungsberichtNotesField != null : "fx:id=\"untersuchungsberichtNotesField\" was not injected: check your FXML file 'model.Untersuchungsbericht eingabe.fxml'.";
        assert untersuchungsberichtSaveButton != null : "fx:id=\"untersuchungsberichtSaveButton\" was not injected: check your FXML file 'model.Untersuchungsbericht eingabe.fxml'.";

    }
}
