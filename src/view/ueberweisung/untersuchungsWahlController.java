package view.ueberweisung;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;

public class untersuchungsWahlController extends TitledPane {
    @FXML
    private TitledPane Bericht1;

    @FXML
    private Text Date;

    @FXML
    private RadioButton GrundChoose;

    @FXML
    private Text Grund;

    @FXML
    private RadioButton SymtomeChoose;

    @FXML
    private Text Symtome;

    @FXML
    private RadioButton ICDChoose;

    @FXML
    private Text ICD;

    @FXML
    private TextFlow Behandlung;

    @FXML
    private TextFlow Medikamente;

    @FXML
    private TextFlow Notiz;

    @FXML
    private RadioButton BehandlungChoose;

    @FXML
    private RadioButton MedChoose;

    @FXML
    private RadioButton NotizChoose;
    public untersuchungsWahlController(Untersuchungsbericht u) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/ueberweisung/untersuchungBericht.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
            // load Date, Grund, Symtome, ICD of Untersuchungsbericht

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
