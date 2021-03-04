package view.ueberweisung;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import model.Untersuchungsbericht;

import java.io.IOException;

/**
 * The type Untersuchungs wahl controller.
 */
public class UntersuchungsWahlController extends TitledPane {
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

    @FXML
    private RadioButton chooseThis;
    private Untersuchungsbericht untersuchung;

    /**
     * Instantiates a new Untersuchungs wahl controller.
     *
     * @param u the u
     */
    public UntersuchungsWahlController(Untersuchungsbericht u){
        this.untersuchung=u;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ueberweisung/UntersuchungsWahl.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void init(){
        Date.setText("");
        Date.setVisible(true);
        Symtome.setText("");
        Symtome.setVisible(true);
        ICD.setText("");
        ICD.setVisible(true);
        Behandlung.getChildren().add(new Text(""));
        Behandlung.setVisible(true);
        Medikamente.getChildren().add(new Text(""));
        Medikamente.setVisible(true);
        Notiz.getChildren().add(new Text(""));
        Notiz.setVisible(true);
    }

    /**
     * Bericht choosen boolean.
     *
     * @return the boolean
     */
//  write method to check radiobuttons and set attribute in untersuchungsbericht
    public boolean BerichtChoosen(){return chooseThis.isSelected();}

    /**
     * Get untersuchung untersuchungsbericht.
     *
     * @return the untersuchungsbericht
     */
    public Untersuchungsbericht getUntersuchung(){return untersuchung;}
}


