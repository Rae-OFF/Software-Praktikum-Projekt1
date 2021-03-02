package view.untersuchungsbericht;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.EPAController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UntersuchungsberichtEingabeController extends Parent {


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

    private EPAController EPAControl;
    private Stage mainStage;

    public UntersuchungsberichtEingabeController(Stage primaryStage, EPAController EPAControl) {
        mainStage = primaryStage;
        this.EPAControl = EPAControl;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/untersuchungsbericht/UntersuchungsberichtEingabe.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
