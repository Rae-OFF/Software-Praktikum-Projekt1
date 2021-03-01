package view.FunctionView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class PatientMainViewController {
    @FXML
    private Text pVorname;

    @FXML
    private Text pNachname;

    @FXML
    private Text pBday;

    @FXML
    private Text pSex;

    @FXML
    private TextFlow pAdress;

    @FXML
    private Button pHausArzt;

    @FXML
    private Button pZumDataAndern;

    @FXML
    private Button pZumUntersuchungsberichte;

    @FXML
    private Button pZumUeberweisung;

    @FXML
    private Button pZumRevision;

    @FXML
    private Button PLogout;

}
